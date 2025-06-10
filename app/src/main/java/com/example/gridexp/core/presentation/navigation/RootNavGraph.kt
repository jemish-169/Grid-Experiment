package com.example.gridexp.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.gridexp.animation.AnimateScreen
import com.example.gridexp.features.grid.presentation.navigation.GridNavGraph
import com.example.gridexp.features.history.presentation.navigation.HistoryNavGraph
import com.example.gridexp.features.home.presentation.navigation.HomeNavGraph

@Composable
fun RootNavGraph(
    rootNavController: NavHostController,
    onBackOrFinish: () -> Unit,
) {

    NavHost(
        navController = rootNavController,
        startDestination = RootRoute.HomeNavGraph
    ) {

        composable<RootRoute.HomeNavGraph>(
            popEnterTransition = AnimateScreen.rightPopEnterTransition(),
            enterTransition = AnimateScreen.leftEnterTransition(),
            popExitTransition = AnimateScreen.rightPopExitTransition(),
            exitTransition = AnimateScreen.leftExitTransition()
        ) {
            HomeNavGraph (
                navigateToModule = { route ->
                    rootNavController.navigate(route)
                }
            )
        }

        composable<RootRoute.GridNavGraph>(
            popEnterTransition = AnimateScreen.rightPopEnterTransition(),
            enterTransition = AnimateScreen.leftEnterTransition(),
            popExitTransition = AnimateScreen.rightPopExitTransition(),
            exitTransition = AnimateScreen.leftExitTransition()
        ) {
            GridNavGraph(
                onBackOrFinish = onBackOrFinish
            )
        }

        composable<RootRoute.HistoryNavGraph>(
            popEnterTransition = AnimateScreen.rightPopEnterTransition(),
            enterTransition = AnimateScreen.leftEnterTransition(),
            popExitTransition = AnimateScreen.rightPopExitTransition(),
            exitTransition = AnimateScreen.leftExitTransition()
        ) {
            HistoryNavGraph(
                onBackOrFinish = onBackOrFinish
            )
        }

    }
}