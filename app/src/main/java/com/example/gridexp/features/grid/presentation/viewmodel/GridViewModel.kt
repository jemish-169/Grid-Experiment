package com.example.gridexp.features.grid.presentation.viewmodel

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GridViewModel @Inject constructor() : ViewModel() {
    fun onInputChange(text: String) {
        _inputText.update { text } // update{} is used to avoid race condition
    }

    private val _inputText = MutableStateFlow("")
    val inputText: StateFlow<String> = _inputText

    private val _textList = (0..11).toList()
    val textList: List<Int> = _textList

}