package com.example.aisc2024_planta_androidapp.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R

@Composable
fun WeatherInfo() {

    val temperature = "34°"

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(252.dp),
        colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainerHigh),
        border = BorderStroke(1.dp, colorScheme.outline)
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp)
            ) {
                // Left side: Weather information
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row() {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(3.dp))
                        Text(
                            text = "Thành phố Hồ Chí Minh",
                            style = MaterialTheme.typography.labelSmall,
                            color = colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {

                            }
                        )
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = temperature,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurfaceVariant,
                    )
                    Text(
                        text = "Nắng đẹp",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurfaceVariant,
                    )

                    // Grid-like structure for weather details
                }

                // Right side: Weather image
                Image(
                    modifier = Modifier
                        .padding(top = 8.dp, end = 16.dp)
                        .size(120.dp),
                    painter = painterResource(id = R.drawable.sunny_image), // Replace with your image resource
                    contentDescription = "Weather Icon",
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            // Statistics
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
            ) {
                // First Row
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    WeatherDetailItem(
                        iconRes = R.drawable.ic_uv,
                        label = "Chỉ số UV",
                        value = "Trung bình"
                    )
                    WeatherDetailItem(
                        iconRes = R.drawable.ic_wind,
                        label = "Tốc độ gió",
                        value = "16km/h"
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
                // Second Row
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    WeatherDetailItem(
                        iconRes = R.drawable.ic_humid,
                        label = "Độ ẩm",
                        value = "58%")
                    WeatherDetailItem(
                        iconRes = R.drawable.ic_rain,
                        label = "Khả năng mưa",
                        value = "14%"
                    )
                }
            }
        }

    }
}