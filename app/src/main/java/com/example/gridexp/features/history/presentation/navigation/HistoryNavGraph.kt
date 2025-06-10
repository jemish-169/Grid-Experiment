package com.example.gridexp.features.history.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gridexp.animation.AnimateScreen
import com.example.gridexp.features.history.presentation.navigation.HistoryRoute.HistoryScreen
import com.example.gridexp.features.history.presentation.screen.HistoryScreen

@Composable
fun HistoryNavGraph(
    onBackOrFinish: () -> Unit
) {
    val historyNavController = rememberNavController()

    NavHost(
        navController = historyNavController,
        startDestination = HistoryScreen
    ) {

        composable<HistoryScreen>(
            popEnterTransition = AnimateScreen.rightPopEnterTransition(),
            enterTransition = AnimateScreen.leftEnterTransition(),
            popExitTransition = AnimateScreen.rightPopExitTransition(),
            exitTransition = AnimateScreen.leftExitTransition()
        ) {
            HistoryScreen(
                onBackClick = {
                    handleBackClick(historyNavController, onBackOrFinish)
                }
            )
        }
    }
}

private fun handleBackClick(historyNavController: NavHostController, onBackOrFinish: () -> Unit) {
    if (historyNavController.previousBackStackEntry == null) onBackOrFinish()
    else historyNavController.navigateUp()
}