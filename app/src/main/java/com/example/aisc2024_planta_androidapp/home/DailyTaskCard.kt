package com.example.aisc2024_planta_androidapp.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R


@Composable
fun DailyTaskCard() {
    val scrollState = rememberScrollState();
    Box(
        modifier = Modifier
            .fillMaxWidth().background(colorScheme.surface)
    ) {
        Column(modifier = Modifier
            .padding(horizontal = 8.dp)) {
            Spacer(modifier = Modifier.size(8.dp))
            DailyTaskItem(
                imageRes = R.drawable.plant_image, // Replace with your plant image resource
                name = "Cây đuôi công",
                location = "Trong nhà",
                task = "Tưới 500ml nước",
                time = "5 phút trước",
                taskIcon = R.drawable.icon_water, // Replace with appropriate icon
                points = 2
            )
            Spacer(modifier = Modifier.size(8.dp))
            DailyTaskItem(
                imageRes = R.drawable.plant_image, // Replace with your plant image resource
                name = "Cây đuôi công",
                location = "Trong nhà",
                task = "Tưới 500ml nước",
                time = "2:45 pm",
                taskIcon = R.drawable.icon_water, // Replace with appropriate icon
                points = 2
            )
            Spacer(modifier = Modifier.size(8.dp))
            DailyTaskItem(
                imageRes = R.drawable.plant_image, // Replace with your plant image resource
                name = "Cây đuôi công",
                location = "Trong nhà",
                task = "Xới đất",
                time = "9:00 am",
                taskIcon = R.drawable.icon_scissors, // Replace with appropriate icon
                points = 2
            )
            Spacer(modifier = Modifier.size(8.dp))
        }
    }
}