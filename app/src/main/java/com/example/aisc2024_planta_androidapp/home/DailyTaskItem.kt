package com.example.aisc2024_planta_androidapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R

@Composable
fun DailyTaskItem(imageRes: Int, name: String, location: String, task: String, time: String, taskIcon: Int, points: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, colorScheme.outline, RoundedCornerShape(8.dp))
            .background(colorScheme.surfaceContainerHigh)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(modifier = Modifier.size(8.dp))
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = "Plant Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(62.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .border(1.dp, colorScheme.outline)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Column(modifier = Modifier
                .weight(1f)
                .offset(y = 2.dp)) {
                Text(text = name, fontWeight = FontWeight.Bold, style = typography.labelLarge)
                Text(text = location, style = typography.bodySmall)
                Spacer(modifier = Modifier.size(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.icon_time),
                        contentDescription = "Time Icon",
                        modifier = Modifier.size(14.dp)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = time, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.labelSmall)
                }
            }
        }
        Column(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(end = 8.dp, top = 8.dp),
            horizontalAlignment = Alignment.End
        ) {
            // Top right circular icon button
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(36.dp)
                    .background(color = colorScheme.outline, shape = CircleShape)
                    .border(width = 1.dp, color = colorScheme.surfaceContainerHighest, shape = CircleShape)
            ) {
                Icon(
                    painter = painterResource(id = taskIcon), // Replace with your drop icon resource
                    contentDescription = "Water Icon",
                    tint = colorScheme.primary, // Green tint for the icon
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            // Task name, points, and icon
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = task, fontWeight = FontWeight.Normal, style = typography.labelSmall) // Task name added here
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = "+$points", color = colorScheme.primary, fontWeight = FontWeight.Bold, style = typography.labelLarge)
                Spacer(modifier = Modifier.size(2.dp))
                Icon(
                    painter = painterResource(id = R.drawable.icon_point),
                    contentDescription = "Task Icon",
                    modifier = Modifier.size(20.dp),
                    tint = colorScheme.primary
                )
            }
        }
    }
}