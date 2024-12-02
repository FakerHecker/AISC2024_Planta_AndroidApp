package com.example.aisc2024_planta_androidapp.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FeatureItem(title: String, subtitle: String, iconRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { /* Handle Click */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Feature Icon
        Image(
            painter = painterResource(id = iconRes), // Replace with your drawable resource
            contentDescription = title, // Accessibility description
            modifier = Modifier.size(36.dp) // Set the size of the image
        )

        Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text

        Column {
            // Feature Title
            Text(
                text = title,
                color = colorScheme.onSurfaceVariant,
                style = typography.labelMedium,
                fontWeight = FontWeight.Normal
            )

            // Feature Subtitle
            Text(
                text = subtitle,
                color = colorScheme.onSurfaceVariant,
                style = typography.bodySmall,
                fontWeight = FontWeight.Normal
            )
        }
    }
}