package com.example.aisc2024_planta_androidapp.main.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.layout_util.FixedGrid
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient

@Composable
fun WeatherInfo(
    temperature: String,
    isSunny: Boolean
) {
    val (bgColor, bgImageRes) =
        if (isSunny)
            Pair(Color(0xFFFFEA47), R.drawable.sunny_deco_image)
        else
            Pair(Color(0xFF4285F4), R.drawable.rainy_deco_image)

    OutlinedCard(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surfaceContainerHigh
        ),
    ) { Box {
        // decorative background blur
        Box(Modifier.blur(200.dp).matchParentSize()) {
            Box(Modifier
                .background(bgColor, CircleShape)
                .size(80.dp)
                .align(Alignment.TopEnd)
            )
        }
        Column {
            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .padding(horizontal = 16.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row(Modifier.clickable {}) {
                        Icon(
                            imageVector = Icons.Rounded.LocationOn,
                            contentDescription = "Location",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(3.dp))
                        Text(
                            text = "Thành phố Hồ Chí Minh",
                            style = typography.labelSmall,
                            color = colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = temperature,
                        style = typography.headlineLarge.copy(
                            brush = colorScheme.primaryGradient
                        ),
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = "Nắng đẹp",
                        style = typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurfaceVariant,
                    )
                }

                Image(
                    modifier = Modifier.size(120.dp),
                    painter = painterResource(bgImageRes),
                    contentDescription = "Weather banner",
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            // Statistics
            FixedGrid(
                columns = 2,
                itemCount = 4,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 16.dp, top = 12.dp)
            ) { index ->
                when (index) {
                    0 -> WeatherDetailItem(
                        metricType = MetricType.UV_INDEX,
                        label = "Chỉ số UV",
                        value = "Trung bình"
                    )
                    1 -> WeatherDetailItem(
                        metricType = MetricType.WIND_SPEED,
                        label = "Tốc độ gió",
                        value = "16km/h"
                    )
                    2 -> WeatherDetailItem(
                        metricType = MetricType.HUMIDITY,
                        label = "Độ ẩm",
                        value = "58%"
                    )
                    3 -> WeatherDetailItem(
                        metricType = MetricType.PRECIPITATION,
                        label = "Khả năng mưa",
                        value = "14%"
                    )
                }
            }
        }
    } }
}