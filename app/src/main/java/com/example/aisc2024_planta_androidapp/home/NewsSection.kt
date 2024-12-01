package com.example.aisc2024_planta_androidapp.home

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun NewsSection() {
    val scrollState = rememberScrollState()

    Row(
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        modifier = Modifier.horizontalScroll(scrollState)
    ) {
        // Example news items
        NewsItem("post 1")
        NewsItem("post 2")
        NewsItem("post 3")
    }
}