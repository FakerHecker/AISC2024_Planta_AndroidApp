package com.example.aisc2024_planta_androidapp.screen.main.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient
import com.example.aisc2024_planta_androidapp.util.addGradient

@Composable
fun DailyTaskItem(
    imageModel: Any?,
    name: String,
    location: String,
    task: String,
    time: String,
    taskIcon: Int,
    points: Int,
    onClick: () -> Unit,
) {
    OutlinedCard(
        shape = RoundedCornerShape(8.dp),
        onClick = onClick,
        colors = CardDefaults.outlinedCardColors().copy(
            containerColor = colorScheme.surfaceContainerHigh
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(78.dp)
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(8.dp)) {
            AsyncImage(
                model = imageModel,
                contentDescription = "Plant Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .clip(RoundedCornerShape(4.dp))
                    .size(62.dp)
            )
            Spacer(Modifier.width(8.dp))
            Column(Modifier.fillMaxHeight()) {
                Text(text = name, style = typography.labelLarge)
                Text(text = location, style = typography.bodySmall)
                Spacer(Modifier.weight(1f))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(R.drawable.icon_time),
                        contentDescription = null,
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(text = time, style = typography.labelSmall)
                }
            }
            Spacer(Modifier.weight(1f))
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End,
                modifier = Modifier.fillMaxHeight()
            ) {
                val buttonIsEnabled = true
                OutlinedIconButton(
                    onClick = {}, // TODO
                    colors = IconButtonDefaults.iconButtonColors().copy(
                        containerColor = colorScheme.surfaceContainerHighest
                    ),
                    border = BorderStroke(1.dp, colorScheme.outline),
                    enabled = buttonIsEnabled,
                    modifier = Modifier
                        .alpha(if (buttonIsEnabled) 1.0f else 0.5f)
                        .size(36.dp)
                ) {
                    Icon(
                        painter = painterResource(taskIcon),
                        contentDescription = "task icon",
                        tint = colorScheme.primary,
                        modifier = Modifier
                            .addGradient(colorScheme.primaryGradient)
                            .size(20.dp),
                    )
                }
                Row(verticalAlignment = Alignment.Bottom) {
                    Row {
                        Text(
                            text = task,
                            style = typography.labelSmall,
                            modifier = Modifier.alignByBaseline()
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Text(
                            text = "+$points",
                            color = colorScheme.primary,
                            style = typography.labelLarge,
                            modifier = Modifier.alignByBaseline()
                        )
                        Spacer(modifier = Modifier.size(2.dp))
                    }
                    Image(
                        painter = painterResource(id = R.drawable.ic_point),
                        contentDescription = "Task Icon",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}