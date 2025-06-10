package com.example.gridexp.features.home.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.gridexp.features.home.presentation.navigation.HomeRoute.HomeScreen
import com.example.gridexp.animation.AnimateScreen
import com.example.gridexp.core.presentation.navigation.RootRoute
import com.example.gridexp.features.home.presentation.screen.HomeScreen

@Composable
fun HomeNavGraph(
    navigateToModule: (RootRoute) -> Unit
) {
    val homeNavController = rememberNavController()

    NavHost(
        navController = homeNavController,
        startDestination = HomeScreen
    ) {

        composable<HomeScreen>(
            popEnterTransition = AnimateScreen.rightPopEnterTransition(),
            enterTransition = AnimateScreen.leftEnterTransition(),
            popExitTransition = AnimateScreen.rightPopExitTransition(),
            exitTransition = AnimateScreen.leftExitTransition()
        ) {
            HomeScreen(
                navigateToModule = navigateToModule
            )
        }
    }
}