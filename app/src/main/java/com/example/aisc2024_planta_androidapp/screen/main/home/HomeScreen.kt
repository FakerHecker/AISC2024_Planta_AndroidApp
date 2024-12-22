package com.example.aisc2024_planta_androidapp.screen.main.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.screen.main.component.DailyTaskSection
import com.example.aisc2024_planta_androidapp.screen.main.home.component.SectionHeader
import com.example.aisc2024_planta_androidapp.screen.main.home.component.NewsSection
import com.example.aisc2024_planta_androidapp.screen.main.home.component.RecommendationSection
import com.example.aisc2024_planta_androidapp.screen.main.home.component.SearchBarHomeScreen
import com.example.aisc2024_planta_androidapp.screen.main.home.component.weather.WeatherInfo

@Composable
fun HomeScreen(nestedScrollConnection: NestedScrollConnection) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(nestedScrollConnection)
            .padding(horizontal = 16.dp)
    ) {
        item {
            SearchBarHomeScreen()
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Thời tiết hôm nay",
                style = typography.titleMedium,
                color = colorScheme.onSurface,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            WeatherInfo()

            // Tasks for Today
            Spacer(Modifier.height(8.dp))
            SectionHeader("Nhiệm vụ trong ngày", {})
            Spacer(Modifier.height(2.dp))
            DailyTaskSection(
                showExtendButton = false,
                showChangeDayButtons = false
            )

            Spacer(Modifier.height(8.dp))
            SectionHeader("Tin tức mới", {})
            Spacer(Modifier.height(2.dp))
            NewsSection()

            SectionHeader("Gợi ý cho bạn", {})
            RecommendationSection()
            Spacer(Modifier.height(32.dp))
        }
        // TODO: move recommendation items here
    }
}

