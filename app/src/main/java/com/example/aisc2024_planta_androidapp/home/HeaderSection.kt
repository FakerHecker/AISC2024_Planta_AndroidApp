package com.example.aisc2024_planta_androidapp.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HeaderSection(
    stringHeader: String,
    onShowAll: () -> Unit,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringHeader,
            style = typography.titleMedium,
            color = colorScheme.onSurface,
        )
        TextButton(onClick = onShowAll) {
            Text(
                text = "Xem tất cả",
                style = typography.labelLarge,
                color = colorScheme.primary
            )
        }
    }
}