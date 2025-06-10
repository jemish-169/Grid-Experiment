package com.example.gridexp.features.grid.presentation.navigation

import kotlinx.serialization.Serializable

sealed class GridRoute {

    // Grid related screens

    @Serializable
    data object GridScreen : GridRoute()
}