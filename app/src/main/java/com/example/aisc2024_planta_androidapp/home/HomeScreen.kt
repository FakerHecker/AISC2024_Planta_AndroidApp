package com.example.aisc2024_planta_androidapp.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aisc2024_planta_androidapp.AppRoute
import com.example.aisc2024_planta_androidapp.scan.ScanScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeMainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) {
        Box(modifier = Modifier
            .padding(bottom = 80.dp)
            .background(colorScheme.surface)) {
            HomeScreenNavHost(navController)
        }
    }
}

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        HeaderHomeScreen()
        Spacer(modifier = Modifier.height(4.dp))
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
        HeaderSection("Nhiệm vụ trong ngày")
        Spacer(modifier = Modifier.padding(2.dp))
        DailyTasksSection()
        Spacer(modifier = Modifier.size(8.dp))
        HeaderSection("Tin tức mới")
        Spacer(modifier = Modifier.padding(2.dp))
        NewsSection()
        HeaderSection("Gợi ý cho bạn")
        Recommendations()
    }
}
