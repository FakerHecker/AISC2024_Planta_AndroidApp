package com.example.aisc2024_planta_androidapp.component.effect

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * If went into composition scope, make status bar to the color in `toDark`.
 * After leaving, set back to default.
 * @param toDark if true, set to dark-colored icons, else light
 */
@Composable
fun StatusBarColorEffect(toDark: Boolean) {
    val view = LocalView.current
    val isLightTheme = !isSystemInDarkTheme()
    DisposableEffect(Unit) {
        val window = (view.context as Activity).window
        val insetController = WindowCompat.getInsetsController(window, view)
        if (!view.isInEditMode) {
            // this is named stupidly.
            // set it to true, it becomes black???
            insetController.isAppearanceLightStatusBars = toDark
            insetController.isAppearanceLightNavigationBars = toDark
        }
        onDispose {
            insetController.isAppearanceLightStatusBars = isLightTheme
            insetController.isAppearanceLightNavigationBars = isLightTheme
        }
    }
}