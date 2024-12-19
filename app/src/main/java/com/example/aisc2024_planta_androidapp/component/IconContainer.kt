package com.example.aisc2024_planta_androidapp.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun IconContainer(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues = PaddingValues(8.dp),
    background: Color = colorScheme.surfaceContainerHighest,
    border: Color = colorScheme.outline,
    content: @Composable () -> Unit
) {
    Box(modifier
        .clip(CircleShape)
        .background(background)
        .border(1.dp, border, CircleShape)
    ) {
        Box(Modifier.padding(contentPadding)) {
            content()
        }
    }
}