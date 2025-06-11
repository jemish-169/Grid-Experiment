package com.example.gridexp.features.grid.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GridViewModel @Inject constructor() : ViewModel(), IGridViewModel {
    private val _inputText = MutableStateFlow("")
    override val inputText: StateFlow<String> = _inputText

    override val textList = (0..11).toList()

    override fun onInputChange(text: String) {
        _inputText.update { text } // update{} is used to avoid race condition
    }
}