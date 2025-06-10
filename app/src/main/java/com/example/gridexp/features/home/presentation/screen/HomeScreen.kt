package com.example.gridexp.features.home.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.GridView
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.gridexp.R
import com.example.gridexp.core.presentation.navigation.RootRoute
import com.example.gridexp.features.home.presentation.components.ModuleItemUI
import com.example.gridexp.features.home.presentation.model.ModuleItem
import com.example.gridexp.theme.lightPink
import com.example.gridexp.theme.lightSky
import com.example.gridexp.theme.pink
import com.example.gridexp.theme.sky

@Composable
fun HomeScreen(navigateToModule: (RootRoute) -> Unit) {
    val modules = getHomeModules()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(12.dp)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(modules, key = { it.route.toString() }) { module ->
                ModuleItemUI(module) {
                    navigateToModule(module.route)
                }
            }
        }
    }
}

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