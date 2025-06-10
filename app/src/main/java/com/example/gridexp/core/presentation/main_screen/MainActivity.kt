package com.example.gridexp.core.presentation.main_screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.gridexp.core.presentation.navigation.RootNavGraph
import com.example.gridexp.theme.GridExpTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // show Splash screen till Activity is creating
        installSplashScreen()

        setContent {
            val rootNavController = rememberNavController()
            GridExpTheme {
                RootNavGraph (
                    rootNavController = rootNavController,
                    onBackOrFinish = { handleBackClick(rootNavController) }
                )
            }
        }
    }

    private fun handleBackClick(rootNavController: NavHostController) {
        if (rootNavController.previousBackStackEntry == null) finish()
        else rootNavController.navigateUp()
    }
}