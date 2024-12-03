package com.example.aisc2024_planta_androidapp.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.aisc2024_planta_androidapp.R

@Composable
fun NewsItem(title: String) {
    OutlinedCard(
        onClick = {},
        modifier = Modifier.size(width = 220.dp, height = 248.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AsyncImage(
                model = R.drawable.post_image,
                contentDescription = "Hình minh họa tin tức",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Text(
                    text = "Cách chăm sóc cây cảnh trong nhà",
                    style = typography.labelLarge
                )
                Text(
                    text = "Chăm sóc cây · Mẹo vặt",
                    style = typography.bodySmall
                )
                Text(
                    text = "15/08/2024 · 3 phút đọc",
                    style = typography.bodySmall
                )
            }
            Spacer(Modifier.weight(1f))
            Row(verticalAlignment = Alignment.CenterVertically) {
                AsyncImage(
                    model = R.drawable.author_image,
                    contentDescription = "Avatar tác giả",
                    modifier = Modifier.size(20.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = "Planta",
                    style = typography.labelSmall
                )
            }
        }

    }
}