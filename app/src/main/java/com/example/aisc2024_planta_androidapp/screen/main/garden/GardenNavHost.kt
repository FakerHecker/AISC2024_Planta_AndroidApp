package com.example.aisc2024_planta_androidapp.screen.main.garden

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aisc2024_planta_androidapp.AppRoute
import com.example.aisc2024_planta_androidapp.screen.main.garden.component.InfoCardGarden

@Composable
fun GardenNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val inTransition = fadeIn(tween(durationMillis = 250)) + slideInVertically { it / 50 }
    val outTransition = fadeOut(tween(durationMillis = 250))

    NavHost(
        navController = navController,
        startDestination = GardenRoute.GardenScreen.name, // Start within the Garden section
        enterTransition = { inTransition },
        popEnterTransition = { inTransition },
        exitTransition = { outTransition },
        popExitTransition = { outTransition },
        modifier = modifier
    ) {
        composable(GardenRoute.GardenScreen.name) {
            GardenScreen(navController) // Pass navController to GardenScreen
        }
        composable(GardenRoute.PlantInfoScreen.name) {
            InfoCardGarden()
        }
    }
}

// Define routes specifically for the Garden section
enum class GardenRoute {
    GardenScreen,
    PlantInfoScreen
}