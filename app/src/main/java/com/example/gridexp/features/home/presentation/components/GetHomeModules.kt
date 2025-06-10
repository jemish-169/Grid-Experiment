package com.example.gridexp.features.home.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.History
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.gridexp.R
import com.example.gridexp.core.presentation.navigation.RootRoute
import com.example.gridexp.features.home.presentation.model.ModuleItem
import com.example.gridexp.theme.lightPink
import com.example.gridexp.theme.lightSky
import com.example.gridexp.theme.pink
import com.example.gridexp.theme.sky

@Composable
fun getHomeModules() = listOf(
    ModuleItem(
        title = stringResource(R.string.grid),
        backgroundColor = lightPink,
        contentColor = pink,
        icon = Icons.Filled.GridView,
        route = RootRoute.GridNavGraph
    ),
    ModuleItem(
        title = stringResource(R.string.history),
        backgroundColor = lightSky,
        contentColor = sky,
        icon = Icons.Filled.History,
        route = RootRoute.HistoryNavGraph
    )
)