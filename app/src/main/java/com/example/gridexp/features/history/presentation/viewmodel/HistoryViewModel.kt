package com.example.gridexp.features.history.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gridexp.R
import com.example.gridexp.common.domain.state.AppState
import com.example.gridexp.di.ResourceManager
import com.example.gridexp.features.history.domain.HistoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val historyRepository: HistoryRepository,
    private val resourceManager: ResourceManager
) : ViewModel(), IHistoryViewModel {

    private val _imageListState = MutableStateFlow<AppState<List<String>, String>>(AppState.Idle)
    override val imageListState: StateFlow<AppState<List<String>, String>> =
        _imageListState
            .onStart { getImageList() }
            .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000L), AppState.Loading)


    private fun getImageList() {
        viewModelScope.launch {
            try {
                val imageListRes = historyRepository.getImagesFromInternalStorage()
                imageListRes.fold(
                    onSuccess = { imageList ->
                        _imageListState.update {
                            if (imageList.isNotEmpty()) {
                                AppState.Success(imageList)
                            } else {
                                AppState.Error(resourceManager.getString(R.string.no_images_are_saved))
                            }
                        }
                    },
                    onFailure = { error ->
                        _imageListState.update {
                            AppState.Error(
                                error.message
                                    ?: resourceManager.getString(R.string.something_went_wrong)
                            )
                        }
                    }
                )

            } catch (e: Exception) {
                _imageListState.update {
                    AppState.Error(
                        resourceManager.getString(
                            R.string.failed_to_load_images,
                            e.message.toString()
                        )
                    )
                }
            }
        }
    }
}