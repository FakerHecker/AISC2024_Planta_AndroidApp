package com.example.aisc2024_planta_androidapp.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Recommendations() {
    Column (
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Row  (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            // Example recommendations
            RecommendationItem("Cây đuôi công", "45 ngày")
            RecommendationItem("Cây đuôi công", "45 ngày")
        }
        Row  (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            // Example recommendations
            RecommendationItem("Cây đuôi công", "45 ngày")
            RecommendationItem("Cây đuôi công", "45 ngày")
        }
        Row  (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            // Example recommendations
            RecommendationItem("Cây đuôi công", "45 ngày")
            RecommendationItem("Cây đuôi công", "45 ngày")
        }
    }
}