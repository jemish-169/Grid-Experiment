package com.example.gridexp.features.home.presentation.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.gridexp.core.presentation.navigation.RootRoute

data class ModuleItem(
    val title: String,
    val backgroundColor: Color,
    val contentColor: Color,
    val icon: ImageVector,
    val route: RootRoute
)