package com.example.aisc2024_planta_androidapp.scan_result.diagnose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme

private val primary = Color(0xFFFFA61D)
private val primaryBackground = Color(0xFFFFFBD6)

@Composable
fun SeverityCard(modifier: Modifier = Modifier) {
    Row(modifier = modifier
        .background(primaryBackground, RoundedCornerShape(8.dp))
        .border(1.dp, primary, RoundedCornerShape(8.dp))
        .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {
        Text(
            "Trung bình",
            style = typography.labelMedium,
            color = primary
        )
    }
}

@Preview
@Composable
private fun SCardPrev() {
    AISC2024_Planta_AndroidAppTheme {
        SeverityCard()
    }
}