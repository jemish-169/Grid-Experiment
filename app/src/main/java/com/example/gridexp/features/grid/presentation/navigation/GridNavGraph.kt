package com.example.gridexp.features.grid.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gridexp.animation.AnimateScreen
import com.example.gridexp.features.grid.presentation.navigation.GridRoute.GridScreen
import com.example.gridexp.features.grid.presentation.screen.GridScreen

@Composable
fun GridNavGraph(
    onBackOrFinish: () -> Unit
) {
    val gridNavController = rememberNavController()

    NavHost(
        navController = gridNavController,
        startDestination = GridScreen
    ) {

        composable<GridScreen>(
            popEnterTransition = AnimateScreen.rightPopEnterTransition(),
            enterTransition = AnimateScreen.leftEnterTransition(),
            popExitTransition = AnimateScreen.rightPopExitTransition(),
            exitTransition = AnimateScreen.leftExitTransition()
        ) {
            GridScreen(
                onBackClick = {
                    handleBackClick(gridNavController, onBackOrFinish)
                }
            )
        }
    }
}

private fun handleBackClick(gridNavController: NavHostController, onBackOrFinish: () -> Unit) {
    if (gridNavController.previousBackStackEntry == null) onBackOrFinish()
    else gridNavController.navigateUp()
}