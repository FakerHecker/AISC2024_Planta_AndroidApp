package com.example.aisc2024_planta_androidapp.screen.scan.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun StepIndicator(stepCount: String, text: String) {
    Column(Modifier.width(66.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            stepCount,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = typography.labelLarge,
            modifier = Modifier
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(size = 12.dp)
                )
                .size(24.dp)
                .wrapContentHeight(Alignment.CenterVertically)
        )
        Spacer(Modifier.height(4.dp))
        Text(
            text,
            color = Color.White,
            textAlign = TextAlign.Center,
            style = typography.labelSmall
        )
    }
}