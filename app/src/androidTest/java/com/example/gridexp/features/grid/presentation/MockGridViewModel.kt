package com.example.gridexp.features.grid.presentation

import com.example.gridexp.features.grid.presentation.viewmodel.IGridViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MockGridViewModel : IGridViewModel {
    private val _input = MutableStateFlow("Initial")
    override val inputText: StateFlow<String> = _input

    override val textList: List<Int> = (0..1).toList()

    override fun onInputChange(text: String) {
        _input.value = text
    }
}
