package com.example.gridexp.core.presentation.navigation

import kotlinx.serialization.Serializable

sealed class RootRoute {

    // screens that has separate module

    @Serializable
    data object HomeNavGraph : RootRoute()

    @Serializable
    data object GridNavGraph : RootRoute()

    @Serializable
    data object HistoryNavGraph : RootRoute()
}
