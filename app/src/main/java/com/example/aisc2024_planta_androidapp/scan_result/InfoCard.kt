package com.example.aisc2024_planta_androidapp.scan_result

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AcUnit
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme


// TODO: generalize to generic-notification
@Composable
fun InfoCard(
    icon: @Composable (Modifier) -> Unit,
    title: String,
    subtitle: String,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        colors = CardDefaults.cardColors()
            .copy(containerColor = colorScheme.surfaceContainerHigh),
        modifier = modifier
    ) {
        Row(Modifier.padding(8.dp)) {
            icon(
                Modifier
                    .size(36.dp)
                    .border(1.dp, colorScheme.outline, CircleShape)
                    .background(colorScheme.surfaceContainerHighest, shape = CircleShape)
                    .padding(8.dp)
            )
            Spacer(Modifier.width(8.dp))
            Column {
                Text(title, style = typography.labelMedium)
                Spacer(Modifier.height(2.dp))
                Text(subtitle, style = typography.bodySmall)
            }
        }
    }
}

@Preview
@Composable
private fun IconCardPrev() {
    AISC2024_Planta_AndroidAppTheme {
        InfoCard(
            title = "Ánh sáng",
            subtitle = "Bán phần",
            icon = {
                Icon(imageVector = Icons.Default.AcUnit, contentDescription = null, modifier = it)
            },
            modifier = Modifier
                .width(148.dp)
        )
    }
}