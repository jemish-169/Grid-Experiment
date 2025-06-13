package com.example.gridexp.features.grid.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gridexp.R
import com.example.gridexp.common.domain.state.AppState
import com.example.gridexp.di.ResourceManager
import com.example.gridexp.features.grid.domain.GridRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GridViewModel @Inject constructor(
    private val gridRepository: GridRepository,
    private val resourceManager: ResourceManager
) : ViewModel(), IGridViewModel {
    private val _inputText = MutableStateFlow("")
    override val inputText: StateFlow<String> = _inputText

    override val textList = (0..11).toList()

    private val _saveImageState = MutableStateFlow<AppState<String, String>>(AppState.Idle)
    override val saveImageState: StateFlow<AppState<String, String>> = _saveImageState

    override fun onInputChange(text: String) {
        _inputText.update { text } // update{} is used to avoid race condition
    }

    override fun saveImage() {
        val saveText = _inputText.value

        if (saveText.isBlank()) {
            _saveImageState.value =
                AppState.Error(resourceManager.getString(R.string.please_enter_some_text))
            return
        }

        _saveImageState.value = AppState.Loading

        viewModelScope.launch {
            gridRepository.saveAsImage(saveText)
                .onSuccess { filePath ->
                    _saveImageState.value = AppState.Success(
                        resourceManager.getString(R.string.image_saved_successfully_at, filePath)
                    )
                }
                .onFailure { exception ->
                    _saveImageState.value = AppState.Success(
                        resourceManager.getString(
                            R.string.failed_to_save_image,
                            exception.message ?: resourceManager.getString(
                                R.string.something_went_wrong
                            )
                        )
                    )
                }
        }
    }
}