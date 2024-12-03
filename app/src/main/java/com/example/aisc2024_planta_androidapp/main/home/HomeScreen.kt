package com.example.aisc2024_planta_androidapp.main.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.main.home.component.DailyTasksSection
import com.example.aisc2024_planta_androidapp.main.home.component.SectionHeader
import com.example.aisc2024_planta_androidapp.main.home.component.NewsSection
import com.example.aisc2024_planta_androidapp.main.home.component.RecommendationSection
import com.example.aisc2024_planta_androidapp.main.home.component.SearchBarHomeScreen
import com.example.aisc2024_planta_androidapp.main.home.component.WeatherInfo

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
            SectionHeader("Nhiệm vụ trong ngày", {})
            Spacer(modifier = Modifier.padding(2.dp))
            DailyTasksSection()
            Spacer(modifier = Modifier.size(8.dp))
            SectionHeader("Tin tức mới", {})
            Spacer(modifier = Modifier.padding(2.dp))
            NewsSection()
            SectionHeader("Gợi ý cho bạn", {})
            RecommendationSection()
        }
        // TODO: move recommendation items here
    }
}
