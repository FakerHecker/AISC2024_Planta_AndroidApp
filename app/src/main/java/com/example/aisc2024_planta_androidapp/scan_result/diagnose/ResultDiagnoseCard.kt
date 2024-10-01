package com.example.aisc2024_planta_androidapp.scan_result.diagnose

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.ContentCut
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.scan_result.info.InfoCard
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme

@Composable
fun ResultDiagnoseCard(modifier: Modifier = Modifier) {
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
                painter = painterResource(R.drawable.plant_image),
                contentDescription = "Plant",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .aspectRatio(1f)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )
            Spacer(Modifier.height(20.dp))
            Text("Cây đuôi công", style = typography.titleLarge)
            Spacer(Modifier.height(8.dp))
            SeverityCard()
            Spacer(Modifier.height(8.dp))
            Row {
                Text("Danh mục:", style = typography.labelMedium)
                Spacer(Modifier.width(4.dp))
                Text("Bệnh thường gặp · Bệnh trên lá", style = typography.bodySmall)
            }
            Spacer(Modifier.height(20.dp))
            Text("Mô tả", style = typography.titleMedium)
            Spacer(Modifier.height(8.dp))
            Text(
                "Bệnh đốm lá cây xuất hiện khi lá cây bị xuất hiện những đốm nhỏ có màu sắc, hình dáng và kích thước không đồng nhất. Phiến lá bị quăn lại, có các đốm màu nâu, đen, tím… Lá cũng khô héo và rụng, gây mất khả năng quang hợp và dẫn đến cái chết của cây.",
                style = typography.bodySmall
            )

            Spacer(Modifier.height(20.dp))
            Text("Cách xử lý", style = typography.titleMedium)
            Spacer(Modifier.height(12.dp))
            InfoCard(
                icon = {
                    Icon(
                        imageVector = Icons.Default.ContentCut,
                        contentDescription = null,
                        modifier = it
                    )
                },
                title = "Tỉa cành",
                subtitle = "Cắt bỏ những lá bị sâu bệnh và tiến hành đốt chúng để phòng tránh loại bệnh thường gặp trên cây cảnh này."
            )
            Spacer(Modifier.height(12.dp))
            InfoCard(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = null,
                        modifier = it
                    )
                },
                title = "Phun thuốc",
                subtitle = "Phun thuốc đều cả mặt trước và sau của lá cây cũng như thân và cành cây, định kỳ theo hướng dẫn của nhà sản xuất hoặc chuyên gia."
            )

            Spacer(Modifier.height(20.dp))
            Text("Thuốc tham khảo", style = typography.titleMedium)
            Spacer(Modifier.height(12.dp))
            InfoCard(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = null,
                        modifier = it
                    )
                },
                title = "Daconil 500SC",
                subtitle = "Thuốc trừ nấm bệnh, tiếp xúc mạnh, trị bệnh và phòng trừ nhiều loại bệnh trên nhiều loại cây trồng khác nhau."
            )
            Spacer(Modifier.height(12.dp))
            InfoCard(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Spa,
                        contentDescription = null,
                        modifier = it
                    )
                },
                title = "Fovathane 80WP",
                subtitle = "Thuốc trừ bệnh Fovathane là thuốc nội hấp, lưu dẫn cực mạnh trị nhiều loại bệnh trên nhiều loại cây trồng khác nhau."
            )
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
private fun ResultDiagPreview() {
    AISC2024_Planta_AndroidAppTheme {
        ResultDiagnoseCard()
    }
}