package com.example.aisc2024_planta_androidapp.screen.main.garden.component

import com.example.aisc2024_planta_androidapp.screen.scan_result.info.component.InfoCard
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.layout_util.FixedGrid
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme
import com.example.aisc2024_planta_androidapp.ui.theme.Typography


@Composable
fun InfoCardGarden() {
    OutlinedCard(
        colors = CardDefaults.cardColors()
            .copy(containerColor = colorScheme.surfaceContainerHigh),
        modifier = Modifier.fillMaxWidth()
    ) { Box(Modifier.fillMaxWidth()) {
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())) {
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
            Spacer(Modifier.height(2.dp))
            Text("(Calathea makoyana)", style = typography.bodyMedium)
            Spacer(Modifier.height(8.dp))
            Row {
                Text("Danh mục:", style = typography.labelMedium)
                Spacer(Modifier.width(4.dp))
                Text("Trong nhà · Trang trí", style = typography.bodySmall)
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
            PlantInfoTable()
            Spacer(Modifier.height(20.dp))
            Text("Mô tả", style = typography.headlineSmall)
            Spacer(Modifier.height(8.dp))
            Text(
                text = "Cây đuôi công là một loài cây cảnh thuộc họ Dong (Marantaceae), với những chiếc lá uốn cong đặc trưng giống như đuôi của con công. Nổi bật với vẻ đẹp lạ mắt và màu sắc tuyệt đẹp, loài cây này đã trở thành một trong những lựa chọn hàng đầu cho những ai yêu thích cây cảnh trong nhà.",
                style = Typography.bodyLarge,
                color = colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(8.dp))
            Text("Cách trồng và chăm sóc", style = typography.headlineSmall)
            Spacer(Modifier.height(16.dp))
            PlantCareInfo()
            Spacer(Modifier.height(8.dp))
            Text("Phân bón tham khảo", style = typography.headlineSmall)
            Spacer(Modifier.height(8.dp))
            PlantFertilizer(
                image = painterResource(R.drawable.biogreen),
                title = "Phân bón lá, Đạm cá pha vi lượng magie BIOGREEN",
                content = "Phân bón hữu cơ, phân bón lá đa trung vi lượng Magie pha Đạm cá BIOGREEN cung cấp mọi dinh dưỡng thiết yếu cho cây trồng (chai 500ml)",
                backgroundColor = colorScheme.surfaceContainerHigh
            )
            Spacer(Modifier.height(16.dp))
            PlantFertilizer(
                image = painterResource(R.drawable.npk),
                title = "Phân NPK trung vi lượng Đầu Bò",
                content = "Kích thích ra rễ mạnh, đâm chồi nhanh, ra lá mạnh, cây xanh tốt và thúc ra hoa nhiều, tăng màu sắc của hoa. Phục hồi nhanh sau khi cắt tỉa, đốn cành. Tăng sức chống chịu với điều kiện môi trường không thuận lợi",
                backgroundColor = colorScheme.surfaceContainerHigh
            )
            Spacer(Modifier.height(16.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()) {
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors().copy(containerColor = Color.Transparent),
                    modifier = Modifier
                        .clip(RoundedCornerShape(100))
                        .height(40.dp).fillMaxWidth()
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

@Composable
fun PlantInfoTable() {
    val tableData = listOf(
        "Tên thường gọi" to "Cây đuôi công",
        "Tên khoa học" to "Calathea makoyana",
        "Họ cây" to "Thuộc họ Dong (Marantaceae)",
        "Nguồn gốc" to "Từ vùng nhiệt đới Nam Mỹ"
    )

    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = colorScheme.surfaceContainerHigh
        ),
        modifier = Modifier.padding(4.dp)
    ) {
        Column(modifier = Modifier.padding(4.dp)) { // Use Column instead of LazyColumn
            tableData.forEachIndexed { index, (label, value) ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp, horizontal = 4.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = label,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.weight(1f)
                    )
                    Text(
                        text = value,
                        modifier = Modifier.weight(1.85f).padding(horizontal = 8.dp)
                    )
                }
                // Add HorizontalDivider conditionally
                if (index < tableData.size - 1) {
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
fun PlantCareInfo() {
    val cardBackgroundColor = colorScheme.surfaceContainerHigh // Light Green

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        PlantCareCard(
            image = ImageVector.vectorResource(R.drawable.icon_sun),
            title = "Ánh sáng",
            content = "Cây đuôi công ưa ánh sáng bán phần, không ưa ánh sáng quá mạnh. Nếu trồng ở nơi có ánh nắng quá gay gắt thường xuyên, chúng rất dễ bị cháy lá. Trường hợp trồng cây ở trong nhà, bạn nên đem cây đi phơi nắng định kỳ, đảm bảo cây có thể quang hợp một cách tốt nhất.",
            backgroundColor = cardBackgroundColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        PlantCareCard(
            image = ImageVector.vectorResource(R.drawable.icon_humidity_mid),
            title = "Độ ẩm",
            content = "Về nhiệt độ, loài cây này ưa mát, do đó, hãy cố gắng duy trì nhiệt độ môi trường trồng cây ở mức từ 21 – 29 độ C, đảm bảo độ ẩm duy trì ở mức 60%.",
            backgroundColor = cardBackgroundColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        PlantCareCard(
            image = ImageVector.vectorResource(R.drawable.icon_water),
            title = "Tưới nước",
            content = "Loài cây đuôi công này cần lượng nước vừa phải. Cứ 2 ngày, bạn nên tưới nước cho cây một lần với lượng nước vừa phải, tránh tưới quá nhiều làm cây bị ngập úng.",
            backgroundColor = cardBackgroundColor
        )
        Spacer(modifier = Modifier.height(16.dp))
        PlantCareCard(
            image = ImageVector.vectorResource(R.drawable.icon_soil),
            title = "Bón phân",
            content = "Cứ khoảng 3 tháng, bạn nên bón phân đạm và phân vi lượng cho cây 1 lần. Khi bón nên pha loãng chúng với nước rồi tưới lên cây, nhờ vậy cây sẽ hấp thụ chất dinh dưỡng tốt hơn.",
            backgroundColor = cardBackgroundColor
        )
    }
}

@Composable
fun PlantCareCard(
    image: ImageVector,
    title: String,
    content: String,
    backgroundColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        border = BorderStroke(1.dp, colorScheme.outline)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.Top
        ) {
            Icon(
                imageVector = image,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(colorScheme.surfaceContainerHighest) // Darker Green
                    .padding(8.dp),
                tint = colorScheme.onSurfaceVariant
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = title,
                    style = typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    color = colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = content,
                    style = typography.bodyMedium,
                    color = colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun PlantFertilizer(
    image: Painter,
    title: String,
    content: String,
    backgroundColor: Color
){
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = backgroundColor),
        border = BorderStroke(1.dp, colorScheme.outline)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(colorScheme.surfaceContainerHighest) // Darker Green
                    .padding(8.dp),
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(1f)
            ) {
                Text(
                    text = title,
                    style = typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    color = colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = content,
                    style = typography.bodyMedium,
                    color = colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

