package com.example.gridexp.features.history.presentation.viewmodel

import com.example.gridexp.common.domain.state.AppState
import kotlinx.coroutines.flow.StateFlow

interface IHistoryViewModel {
    val imageListState: StateFlow<AppState<List<String>, String>>
}