package com.example.aisc2024_planta_androidapp.screen.main.garden.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R

@Composable
fun PremiumAdsCard(
    userName: String = "Plantie",
    onClick: () -> Unit = {},
) {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surfaceContainerHigh
        ),
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Row (
            modifier = Modifier.padding(10.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // TODO: extract this circle box
            Box(
                Modifier
                .clip(CircleShape)
                .background(Color(0xFFFFFBD6))
                .border(1.dp, Color(0xFFFFE7C2), CircleShape)
            ) {
                Icon(
                    painterResource(R.drawable.icon_stars), null,
                    tint = Color(0xFFFFCE0A),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(20.dp)
                )
            }

            Column(Modifier.weight(1f)) {
                Text(
                    text = "Hi $userName,",
                    style = typography.labelMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Bạn đang được thêm tối đa 10 cây vào vườn. Nâng cấp Premium ngay để thêm cây vào vườn không giới hạn nhé!",
                    style = typography.bodySmall,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Nâng cấp ngay",
                        color = colorScheme.primary,
                        style = typography.labelMedium,
                    )
                }
            }
        }
    }
}