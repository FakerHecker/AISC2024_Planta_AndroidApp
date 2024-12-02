package com.example.aisc2024_planta_androidapp.scan_result.info.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconToggleButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.layout_util.FixedGrid
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme

@Composable
fun ResultInfoCard(modifier: Modifier = Modifier) {
    OutlinedCard(
        colors = CardDefaults.cardColors()
            .copy(containerColor = colorScheme.surfaceContainerHigh),
        modifier = modifier
    ) { Box(Modifier.fillMaxWidth()) {
        Column(
            Modifier
                .padding(8.dp)
                .fillMaxWidth()) {
            // switch to horizontal pager
            Image(
                painter = painterResource(R.drawable.fake_result_plant),
                contentDescription = "Plant",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(Modifier.height(20.dp))
            Text("Cây đậu phộng", style = typography.titleLarge)
            Spacer(Modifier.height(2.dp))
            Text("(Goober peas)", style = typography.bodyMedium)
            Spacer(Modifier.height(8.dp))
            Row {
                Text("Danh mục:", style = typography.labelMedium)
                Spacer(Modifier.width(4.dp))
                Text("Ngoài trời", style = typography.bodySmall)
            }
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("45 ngày", style = typography.headlineSmall.copy(
                    brush = Brush.linearGradient(
                        colors = listOf(Color(0xFF059710), Color(0xFF04CB01)),
                    )
                ))
                var checked by remember { mutableStateOf(false) }
                OutlinedIconToggleButton(
                    checked = checked,
                    onCheckedChange = { checked = it },
                    // TODO: add checked color here
                    colors = IconButtonDefaults.outlinedIconToggleButtonColors(),
                    border = BorderStroke(1.dp, colorScheme.outline)
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = "Favorite"
                    )
                }
            }
            Spacer(Modifier.height(8.dp))

            val cards: List<Triple<Painter, String, String>> = listOf(
                Triple(painterResource(R.drawable.icon_sun), "Ánh sáng", "Bán phần"),
                Triple(painterResource(R.drawable.icon_humidity_mid), "Độ ẩm", "50-60%"),
                Triple(painterResource(R.drawable.icon_water), "Tưới nước", "2 ngày/lần"),
                Triple(painterResource(R.drawable.icon_soil), "Bón phân", "3 tháng/lần")
            )
            FixedGrid(columns = 2, itemCount = 4,
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) { index ->
                val currentCard = cards[index]
                InfoCard(
                    icon = { Icon(
                        painter = currentCard.first,
                        contentDescription = null, modifier = it)
                    },
                    title = currentCard.second, subtitle = currentCard.third,
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(Modifier.height(20.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()) {
                OutlinedButton(onClick = { /*TODO*/ }) {
                    Text("Xem chi tiết")
                }
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors().copy(containerColor = Color.Transparent),
                    modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .height(40.dp)
                        .background(
                            brush = Brush.linearGradient(
                                colors = listOf(Color(0xFF059710), Color(0xFF04CB01))
                            )
                        )
                ) {
                    Icon(painter = painterResource(R.drawable.icon_plant_outlined), contentDescription = null)
                    Text("Thêm vào vườn")
                }
            }
        }

        // "Phu hop nhat" card
        Row(modifier = Modifier
            .background(colorScheme.surfaceContainerHigh, RoundedCornerShape(8.dp))
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .align(Alignment.TopCenter)
        ) {
            Text("Phù hợp nhất", style = typography.labelMedium)
        }
    } }
}

@Preview
@Composable
private fun ResultInfoPreview() {
    AISC2024_Planta_AndroidAppTheme {
        ResultInfoCard(Modifier.width(328.dp))
    }
}