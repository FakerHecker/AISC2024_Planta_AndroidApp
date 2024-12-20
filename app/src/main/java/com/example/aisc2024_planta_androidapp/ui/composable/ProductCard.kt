package com.example.aisc2024_planta_androidapp.ui.composable

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme

@Composable
fun ProductCard(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    OutlinedCard(
        colors = CardDefaults.cardColors()
            .copy(containerColor = colorScheme.surfaceContainerHigh),
        modifier = modifier
    ) {
        Column(Modifier.padding(8.dp)) {
            Image(
                painter = painterResource(R.drawable.plant_image),
                contentDescription = "plant image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(Modifier.height(8.dp))
            Text("Cây đuôi công", style = typography.labelLarge)
            Text("Trong nhà · Trang trí", style = typography.bodySmall)
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("120,000₫", style = typography.titleMedium.copy(
                    brush = Brush.linearGradient(listOf(
                        Color(0xFF059710),
                        Color(0xFF04CB01)
                    ))
                ))
                OutlinedIconButton(onClick = {},
                    border = BorderStroke(1.dp, colorScheme.outline),
                    modifier = Modifier.size(40.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_plant_outlined),
                        contentDescription = "View plant" // TODO: ??? check this
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ProductCardPreview() {
    AISC2024_Planta_AndroidAppTheme {
        ProductCard(Modifier.width(156.dp))
    }
}