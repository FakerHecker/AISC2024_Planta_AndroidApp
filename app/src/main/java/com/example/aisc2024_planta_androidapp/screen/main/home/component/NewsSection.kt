package com.example.aisc2024_planta_androidapp.screen.main.home.component

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R

@Composable
fun NewsSection() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        modifier = Modifier.horizontalScroll(rememberScrollState())
    ) {
        for (i in (1..3)) {
            NewsItem(
                title = "Cách chăm sóc cây cảnh trong nhà",
                category = "Chăm sóc cây · Mẹo vặt",
                bannerImageModel = R.drawable.post_image,
                postedDate = "15/08/2024",
                timeToRead = "3 phút đọc",
                authorImageModel = R.drawable.author_image,
                authorName = "Planta"
            )
        }
    }
}