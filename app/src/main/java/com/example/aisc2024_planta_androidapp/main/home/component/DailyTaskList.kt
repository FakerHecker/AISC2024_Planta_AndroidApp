package com.example.aisc2024_planta_androidapp.main.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R

@Composable
fun DailyTaskList(modifier: Modifier = Modifier) {
    val items = remember { List(3) { it } }
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
            .background(colorScheme.surface)
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 20.dp, bottom = 8.dp)
    ) {
        for (it in items) {
            DailyTaskItem(
                imageModel = R.drawable.plant_image, // Replace with your plant image resource
                name = "Cây đuôi công",
                location = "Trong nhà",
                task = "Tưới 500ml nước",
                time = "5 phút trước",
                taskIcon = R.drawable.icon_water, // Replace with appropriate icon
                points = 2
            )
        }
    }
}