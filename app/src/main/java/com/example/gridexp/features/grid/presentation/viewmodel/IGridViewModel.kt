package com.example.gridexp.features.grid.presentation.viewmodel

import kotlinx.coroutines.flow.StateFlow

interface IGridViewModel {
    val inputText: StateFlow<String>
    val textList: List<Int>
    fun onInputChange(text: String)
}
