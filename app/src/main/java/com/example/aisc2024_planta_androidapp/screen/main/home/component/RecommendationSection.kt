package com.example.aisc2024_planta_androidapp.screen.main.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.layout_util.FixedGrid

@Composable
fun RecommendationSection() {
    // Example recommendations
    FixedGrid(
        columns = 2,
        itemCount = 6,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        RecommendationItem(
            name = "Cây đuôi công",
            category = "Trong nhà · Trang trí",
            duration = "45 ngày",
            imageModel = R.drawable.plant_image
        )
    }
}