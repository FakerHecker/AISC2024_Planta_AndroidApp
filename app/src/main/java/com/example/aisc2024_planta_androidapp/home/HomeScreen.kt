package com.example.aisc2024_planta_androidapp.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeMainScreen(
    onScan: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    Scaffold(
        topBar = {
            HomeScreenTopBar(scrollBehavior)
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                onScan = onScan
            )
        },
        containerColor = colorScheme.surface
    ) { innerPadding ->
        HomeScreenNavHost(
            navController,
            scrollBehavior.nestedScrollConnection,
            Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun HomeScreen(nestedScrollConnection: NestedScrollConnection) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
            .padding(16.dp)
    ) {
        item {
            SearchBarHomeScreen()
            Text(
                text = "Thời tiết hôm nay",
                style = typography.titleMedium,
                color = colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )
            // Weather Info
            WeatherInfo(
                temperature = "34°",
                isSunny = false
            )
            // Tasks for Today
            Spacer(modifier = Modifier.padding(8.dp))
            HeaderSection("Nhiệm vụ trong ngày", {})
            Spacer(modifier = Modifier.padding(2.dp))
            DailyTasksSection()
            Spacer(modifier = Modifier.size(8.dp))
            HeaderSection("Tin tức mới", {})
            Spacer(modifier = Modifier.padding(2.dp))
            NewsSection()
            HeaderSection("Gợi ý cho bạn", {})
            Recommendations()
        }
    }
}
