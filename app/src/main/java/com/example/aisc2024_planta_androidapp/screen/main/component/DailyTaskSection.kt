package com.example.aisc2024_planta_androidapp.screen.main.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults.outlinedIconButtonColors
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient

@Composable
fun DailyTaskSection(
    showExtendButton: Boolean = true,
    showChangeDayButtons: Boolean = true,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surface,
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .background(colorScheme.surfaceContainerHighest)
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (showChangeDayButtons) {
                // TODO: extract the outlined button
                OutlinedIconButton(
                    colors = outlinedIconButtonColors().copy(
                        containerColor = colorScheme.surfaceContainerHigh,
                    ),
                    border = BorderStroke(1.dp, colorScheme.outline),
                    onClick = {}, // TODO
                ) {
                    Icon(painterResource(R.drawable.icon_arrow_left), "Ngày hôm trước")
                }
            }

            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Thứ 2",
                    style = typography.labelMedium,
                    color = colorScheme.onSurfaceVariant,
                )
                Text(
                    text = "23/12/2024",
                    style = typography.titleMedium.copy(
                        brush = colorScheme.primaryGradient
                    ),
                )
            }

            if (showChangeDayButtons) {
                OutlinedIconButton(
                    colors = outlinedIconButtonColors().copy(
                        containerColor = colorScheme.surfaceContainerHigh,
                    ),
                    border = BorderStroke(1.dp, colorScheme.outline),
                    onClick = {}, // TODO
                ) {
                    Icon(painterResource(R.drawable.icon_arrow_right), "Ngày hôm sau")
                }
            }
        }

        DailyTaskList()

        if (showExtendButton) {
            val buttonShape = RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)
            OutlinedCard (
                border = BorderStroke(1.dp, colorScheme.outline),
                shape = buttonShape,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {}, // TODO
            ) {
                Text(
                    text = "Mở rộng",
                    style = typography.labelMedium,
                    modifier = Modifier.padding(horizontal = 30.dp, vertical = 6.dp)
                )
            }
        }
    }
}

@Composable
private fun DailyTaskList(modifier: Modifier = Modifier) {
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
                points = 2,
                onClick = {} // TODO
            )
        }
    }
}

