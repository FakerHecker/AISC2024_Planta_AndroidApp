package com.example.aisc2024_planta_androidapp.screen.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.aisc2024_planta_androidapp.screen.main.component.BottomNavigationBar
import com.example.aisc2024_planta_androidapp.screen.main.component.MainScreenTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onScan: () -> Unit,
    onNavigateToProfile: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    var titleBarText by rememberSaveable { mutableStateOf("Chào Plantie 🍀") }
    Scaffold(
        topBar = {
            MainScreenTopBar(
                title = titleBarText,
                scrollBehavior = scrollBehavior,
                onNavigateToProfile = onNavigateToProfile
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
            onTitleChange = { titleBarText = it },
            modifier = Modifier.padding(innerPadding)
        )
    }
}
