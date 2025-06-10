package com.example.gridexp.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.luminance
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = lightBlue,
    secondary = lightBlue,
    tertiary = lightGrey,
    background = black,
    surface = black,
    onPrimary = white,
    onSecondary = white,
    onTertiary = darkGrey,
    onBackground = white,
    onSurface = white
)

private val LightColorScheme = lightColorScheme(
    primary = darkBlue,
    secondary = darkBlue,
    tertiary = darkGrey,
    background = white,
    surface = white,
    onPrimary = black,
    onSecondary = black,
    onTertiary = lightGrey,
    onBackground = black,
    onSurface = black
)

@Composable
fun GridExpTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.copy(0.9f).toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
                if (colorScheme.primary.luminance() < 0.25f) false else true
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}