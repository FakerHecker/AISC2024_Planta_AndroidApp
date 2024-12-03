package com.example.aisc2024_planta_androidapp.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.aisc2024_planta_androidapp.AppRoute

@Composable
fun HomeScreenNavHost(
    navController: NavHostController,
    nestedScrollConnection: NestedScrollConnection,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.HomeScreen.name,
        modifier = modifier
    ) {
        composable(AppRoute.HomeScreen.name) {
            HomeScreen(nestedScrollConnection)
        }
        composable(AppRoute.Garden.name) {  }
    }
}