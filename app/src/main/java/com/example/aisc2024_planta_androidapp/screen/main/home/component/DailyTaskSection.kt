package com.example.aisc2024_planta_androidapp.screen.main.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient

@Composable
fun DailyTasksSection(modifier: Modifier = Modifier) {
    OutlinedCard(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surfaceContainerHighest,
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp).fillMaxWidth()
        ) {
            Text(
                text = "Thứ 2",
                style = typography.labelMedium,
                color = colorScheme.onSurfaceVariant,
            )
            Text(
                text = "21/08/2024",
                style = typography.titleMedium.copy(
                    brush = colorScheme.primaryGradient
                ),
            )
        }
        DailyTaskList()
    }
}