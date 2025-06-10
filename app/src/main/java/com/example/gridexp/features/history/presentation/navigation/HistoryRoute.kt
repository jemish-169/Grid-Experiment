package com.example.gridexp.features.history.presentation.navigation

import kotlinx.serialization.Serializable

sealed class HistoryRoute {

    // History related screens

    @Serializable
    data object HistoryScreen : HistoryRoute()
}