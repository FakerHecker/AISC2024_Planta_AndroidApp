package com.example.aisc2024_planta_androidapp.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aisc2024_planta_androidapp.R

@Composable
fun GardenScreen() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(horizontal = 16.dp)
    ) {
        PremiumUpgradeCard()
        TaskSection()
        MyGardenSection()
    }
}

@Composable
fun PremiumUpgradeCard(
    userName: String = "Plantie",
    onCardClick: () -> Unit = {},
    onUpgradeClick: () -> Unit = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCardClick() },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFCAE0CD)),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFCFFF8)
        ),
    ) {
        Row (
            modifier = Modifier
                .padding(10.dp),
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_premium),
                contentDescription = "Premium Icon",
                modifier = Modifier.size(54.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = "Hi $userName,",
                    style = MaterialTheme.typography.bodyLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = Color(0xFF005200)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Bạn đang được thêm tối đa 10 cây vào vườn. Nâng cấp Premium ngay để thêm cây vào vườn không giới hạn nhé!",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color(0xFF005200)
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        text = "Nâng cấp ngay",
                        color = Color(0xFF059710),
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(0.dp)
                    )
                }

            }
        }
    }
}

@Composable
fun TaskCard(
    plantName: String,
    plantStatus: String,
    timeAgo: String,
    waterAmount: String,
    waterIconRes: Int,
    plantImageRes: Int,
    onCardClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 8.dp)
            .clickable { onCardClick },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFCAE0CD)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFCFFF8))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = plantImageRes),
                contentDescription = "Plant Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(4.dp))
            )

            Spacer(modifier = Modifier.width(8.dp))

            Column {
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column {
                        Text(
                            text = plantName,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF388E3C)
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = plantStatus,
                            fontSize = 14.sp,
                            color = Color(0xFF005200)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .background(
                                color = Color(0xFFEBFEED),
                                shape = CircleShape
                            )
                            .border(
                                width = 1.dp,
                                color = Color(0xFFCAE0CD),
                                shape = CircleShape
                            )
                            .padding(8.dp) ,
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                        painter = painterResource(id = R.drawable.ic_water_light),
                        contentDescription = "Water Icon",
                        modifier = Modifier.size(20.dp)
                        )
                    }

                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row (
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.icon_time),
                            contentDescription = "Water Icon",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = timeAgo,
                            fontSize = 11.sp,
                            color = Color(0xFF005200),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ) {
                        Text(
                            text = waterAmount,
                            fontSize = 11.sp,
                            color = Color(0xFF005200),
                            fontWeight = FontWeight.Bold
                        )
                        Row (
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(2.dp)
                        ) {
                            Text(
                                text = "+2",
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF059710)
                            )
                            Image(
                                painter = painterResource(id = R.drawable.ic_leaf_point),
                                contentDescription = "Points",
                                modifier = Modifier.size(20.dp).padding(1.dp, 0.dp, 0.dp, 0.dp)
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TaskSection(){
    Column(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .border(1.dp, Color.LightGray, RoundedCornerShape(12.dp)),
            colors = CardDefaults.cardColors(
                containerColor = Color.White,
            )
        ){
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFEBFEED))
                    .padding(vertical = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color(0xFFCAE0CD), CircleShape)
                            .background(Color.White)
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_left),
                            contentDescription = "Left Button",
                            modifier = Modifier.size(12.dp)
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(0.dp)
                    ) {
                        Text(
                            text = "Thứ 4",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF005200)
                        )
                        Text(
                            text = "21/08/2024",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF059710)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .border(1.dp, Color(0xFFCAE0CD), CircleShape)
                            .background(Color.White)
                            .clickable {},
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_right),
                            contentDescription = "Right Button",
                            modifier = Modifier.size(12.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Column (
                modifier = Modifier.fillMaxWidth()
            ) {
                TaskCard(
                    plantName = "Cây đuôi công",
                    plantStatus = "Trong nhà",
                    timeAgo = "5 phút trước",
                    waterAmount = "Tưới 500ml nước",
                    waterIconRes = R.drawable.icon_time,
                    plantImageRes = R.drawable.plant_image,
                    onCardClick = {}
                )
                TaskCard(
                    plantName = "Cây đuôi công",
                    plantStatus = "Trong nhà",
                    timeAgo = "5 phút trước",
                    waterAmount = "Tưới 500ml nước",
                    waterIconRes = R.drawable.icon_time,
                    plantImageRes = R.drawable.plant_image,
                    onCardClick = {}
                )
                TaskCard(
                    plantName = "Cây đuôi công",
                    plantStatus = "Trong nhà",
                    timeAgo = "5 phút trước",
                    waterAmount = "Tưới 500ml nước",
                    waterIconRes = R.drawable.icon_time,
                    plantImageRes = R.drawable.plant_image,
                    onCardClick = {}
                )
                TaskCard(
                    plantName = "Cây đuôi công",
                    plantStatus = "Trong nhà",
                    timeAgo = "5 phút trước",
                    waterAmount = "Tưới 500ml nước",
                    waterIconRes = R.drawable.icon_time,
                    plantImageRes = R.drawable.plant_image,
                    onCardClick = {}
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 116.dp)
                    .padding(top = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                        .border(1.dp, Color(0xFFCAE0CD), RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                        .clickable {},
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Mở rộng",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF005200),
                        textAlign = TextAlign.Center,
                    )
                }
            }
        }
    }
}

@Preview
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPlantCard(modifier: Modifier = Modifier) {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }


    OutlinedCard(
        colors = CardDefaults.cardColors()
            .copy(containerColor = colorScheme.surfaceContainerHigh),
        modifier = modifier.clickable(onClick = {
            showBottomSheet = true
        })
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
            Text("Cây đuôi công", style = typography.titleMedium, color = Color(0xFF005200))
            Text("17/08/2024", style = typography.bodyMedium, color = Color(0xFF005200))
            Spacer(Modifier.height(8.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Column (
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(4.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom
                    ) {

                        Text("10", style = typography.titleMedium.copy(
                            brush = Brush.linearGradient(listOf(
                                Color(0xFF059710),
                                Color(0xFF04CB01)
                            )),
                            fontWeight = FontWeight.Bold
                        ))

                        Text("/45 ngày", style = typography.titleSmall.copy(
                            brush = Brush.linearGradient(listOf(
                                Color(0xFF059710),
                                Color(0xFF04CB01)
                            )),
                            fontWeight = FontWeight.Bold
                        ))
                    }
                    LinearProgressIndicator(
                        progress = 10f / 45f,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(4.dp)
                            .clip(RoundedCornerShape(2.dp)),
                        color = Color(0xFF059710),
                        trackColor = Color(0xFFCAE0CD)
                    )
                }
                OutlinedIconButton(onClick = { /*TODO*/ },
                    border = BorderStroke(1.dp, Color(0xFFCAE0CD)),
                    modifier = Modifier.size(48.dp)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.ic_heart),
                        contentDescription = "View plant", // TODO: ??? check this
                        modifier = Modifier.size(20.dp),
                        tint = Color.Unspecified
                    )
                }
            }
        }
    }

    if(showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            containerColor = Color(0xFFF8F8F8)
        ) {
            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(0.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.plant_image),
                        contentDescription = "Plant Image",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(64.dp)
                            .clip(RoundedCornerShape(4.dp))
                    )

                    Spacer(modifier = Modifier.width(8.dp))

                    Column {
                        Row (
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top,
                            modifier = Modifier.fillMaxWidth().height(64.dp)
                        ) {
                            Column {
                                Text(
                                    text = "Cây đuôi công",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color(0xFF005200)
                                )
                                Text(
                                    text = "Trong nhà",
                                    fontSize = 14.sp,
                                    color = Color(0xFF005200)
                                )
                            }
                        }
                    }
                }

                Spacer(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(2.dp)
                        .drawBehind {
                            drawLine(
                                color = Color(0xFFCAE0CD),
                                start = Offset(0f, size.height),
                                end = Offset(size.width, size.height),
                                strokeWidth = 2f
                            )
                        }
                )
                Column (
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                ) {

                    BottomSheetItem(iconId = R.drawable.ic_filter_vintage, title = "Thông tin cây trồng", onClick = { })
                    BottomSheetItem(iconId = R.drawable.ic_cancel, title = "Xóa cây trồng ra khỏi vườn", onClick = {})
                }
            }
        }
    }
}

@Composable
fun BottomSheetItem(iconId: Int, title: String, onClick: () -> Unit) {
    val icon = painterResource(id = iconId)

    Row (
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.clickable { onClick() }
            .fillMaxWidth()
            .clip(RoundedCornerShape(4.dp))

    ) {
        Icon(painter = icon, contentDescription = null, modifier = Modifier.size(16.dp))
        Text(
            text = title,
            color = Color(0xFF005200),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun MyGardenSection() {
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Vườn cây của tôi",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF005200),
                modifier = Modifier.padding(vertical = 16.dp)
            )
            DropdownBox()
        }

        Column (
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                MyPlantCard(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
                MyPlantCard(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                MyPlantCard(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun DropdownBox() {
    val expanded = remember { mutableStateOf(false) }
    val selectedOption = remember { mutableStateOf("Trong nhà") }
    Box(
        modifier = Modifier.padding(0.dp),
    ) {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .border(BorderStroke(1.dp, Color(0xFFCAE0CD)), shape = RoundedCornerShape(8.dp))
                .background(Color(0xFFFDFFFA), shape = RoundedCornerShape(8.dp))
                .clickable(onClick = { expanded.value = true })
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 14.dp)
            ){
                Text(
                    text = selectedOption.value,
                    fontSize = 12.sp,
                    color = Color(0xFF005200),
                    modifier = Modifier
                        .padding(14.dp, 3.dp, 3.dp, 4.dp)
                )
                Image(
                    painter = painterResource(R.drawable.ic_arrow_dropdown),
                    contentDescription = "View plant", // TODO: ??? check this
                    modifier = Modifier.size(8.dp),
                )
            }

        }

        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier
                .background(Color(0xFFFDFFFA), shape = RoundedCornerShape(8.dp))
                .border(BorderStroke(1.dp, Color(0xFFCAE0CD)))
        ) {
            DropdownMenuItem(
                onClick = {
                    selectedOption.value = "Trong nhà"
                    expanded.value = false
                },
                text = {Text(text = "Trong nhà", color = Color(0xFF005200))}
            )
            DropdownMenuItem(
                onClick = {
                    selectedOption.value = "Ngoài trời"
                    expanded.value = false
                },
                text = {Text(text = "Ngoài trời", color = Color(0xFF005200))}
            )
        }
    }
}



