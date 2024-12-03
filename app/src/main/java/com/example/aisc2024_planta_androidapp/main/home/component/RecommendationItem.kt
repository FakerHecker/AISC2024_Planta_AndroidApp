package com.example.aisc2024_planta_androidapp.main.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient

@Composable
fun RecommendationItem(
    name: String,
    category: String,
    duration: String,
    imageModel: Any?,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        onClick = {},
        colors = CardDefaults.outlinedCardColors().copy(
            containerColor = colorScheme.surfaceContainerHigh
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                model = imageModel,
                contentDescription = "Recommend Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = name,
                    style = typography.labelLarge,
                    color = colorScheme.onSurfaceVariant
                )
                Text(
                    text = category,
                    style = typography.bodySmall,
                    color = colorScheme.onSurfaceVariant
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = duration,
                    style = typography.titleMedium.copy(
                        brush = colorScheme.primaryGradient
                    )
                )
                OutlinedIconButton(
                    onClick = {},
                    border = BorderStroke(1.dp, colorScheme.outline)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_plant_outlined),
                        contentDescription = "Recommend Icon",
                        tint = colorScheme.primary
                    )
                }
            }
        }

    }
}