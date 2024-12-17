package com.example.aisc2024_planta_androidapp.screen.main

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aisc2024_planta_androidapp.AppRoute
import com.example.aisc2024_planta_androidapp.screen.main.garden.GardenScreen
import com.example.aisc2024_planta_androidapp.screen.main.home.HomeScreen

@Composable
fun MainScreenNavHost(
    navController: NavHostController,
    nestedScrollConnection: NestedScrollConnection,
    onTitleChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val inTransition = fadeIn(tween(durationMillis = 250)) + slideInVertically { it / 50 }
    val outTransition = fadeOut(tween(durationMillis = 250))
    NavHost(
        navController = navController,
        startDestination = AppRoute.HomeScreen.name,
        enterTransition = { inTransition },
        popEnterTransition = { inTransition },
        exitTransition = { outTransition },
        popExitTransition = { outTransition },
        modifier = modifier
    ) {
        composable(AppRoute.HomeScreen.name) {
            LaunchedEffect(Unit) {
                onTitleChange("Chào Plantie \uD83C\uDF40")
            }
            HomeScreen(nestedScrollConnection)
        }
        composable(AppRoute.Garden.name) {
            LaunchedEffect(Unit) {
                onTitleChange("Vườn cây \uD83E\uDEB4")
            }
            GardenScreen()
        }
    }
}