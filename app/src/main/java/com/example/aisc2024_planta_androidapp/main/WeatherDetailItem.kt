package com.example.aisc2024_planta_androidapp.main

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R

enum class MetricType {
    UV_INDEX, WIND_SPEED, HUMIDITY, PRECIPITATION
}

private data class IconProperty(
    @DrawableRes val iconRes: Int,
    val containerColor: Long,
    val borderColor: Long,
    val iconColor: Long
)

@Composable
fun WeatherDetailItem(
    metricType: MetricType,
    label: String,
    value: String,
    modifier: Modifier = Modifier
) {
    val iconProps = when (metricType) {
        MetricType.UV_INDEX -> IconProperty(
            iconRes = R.drawable.icon_sun,
            containerColor = 0xFFFFFBD6,
            borderColor = 0xFFFFE7C2,
            iconColor = 0xFFFFCE0A
        )
        MetricType.WIND_SPEED -> IconProperty(
            iconRes = R.drawable.icon_wind,
            containerColor = 0xFFF6ECFE,
            borderColor = 0xFFE3C5FC,
            iconColor = 0xFF8F19F0
        )
        MetricType.HUMIDITY -> IconProperty(
            iconRes = R.drawable.icon_humidity_mid,
            containerColor = 0xFFEBFEED,
            borderColor = 0xFFBDEEC1,
            iconColor = 0xFF0BD51C
        )
        MetricType.PRECIPITATION -> IconProperty(
            iconRes = R.drawable.icon_rain,
            containerColor = 0xFFF1F3F8,
            borderColor = 0xFFD6DCEA,
            iconColor = 0xFF3E497A
        )
    }

    Row(modifier) {
        Box(Modifier
            .size(36.dp)
            .border(1.dp, Color(iconProps.borderColor), CircleShape)
            .background(Color(iconProps.containerColor), CircleShape)
        ) {
            Icon(
                painter = painterResource(iconProps.iconRes),
                contentDescription = label,
                tint = Color(iconProps.iconColor),
                modifier = Modifier.align(Alignment.Center)
            )
        }
        Spacer(Modifier.width(8.dp))
        Column {
            Text(text = label,
                style = typography.labelSmall,
                color = colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Bold
            )
            Text(text = value,
                style = typography.labelLarge,
                color = colorScheme.onSurfaceVariant,
                fontWeight = FontWeight.Bold
            )
        }
    }
}