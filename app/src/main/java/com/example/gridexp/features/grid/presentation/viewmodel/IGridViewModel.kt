package com.example.gridexp.features.grid.presentation.viewmodel

import com.example.gridexp.common.domain.state.AppState
import kotlinx.coroutines.flow.StateFlow

interface IGridViewModel {
    val inputText: StateFlow<String>
    val textList: List<Int>
    val saveImageState: StateFlow<AppState<String, String>>
    fun onInputChange(text: String)
    fun saveImage()
}
