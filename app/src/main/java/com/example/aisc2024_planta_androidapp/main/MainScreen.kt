package com.example.aisc2024_planta_androidapp.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.aisc2024_planta_androidapp.main.component.BottomNavigationBar
import com.example.aisc2024_planta_androidapp.main.component.MainScreenTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onScan: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        topBar = {
            MainScreenTopBar(
                title = "Chào Plantie 🍀",
                scrollBehavior = scrollBehavior,
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                onScan = onScan
            )
        },
        containerColor = colorScheme.surface
    ) { innerPadding ->
        MainScreenNavHost(
            navController,
            scrollBehavior.nestedScrollConnection,
            Modifier.padding(innerPadding)
        )
    }
}
