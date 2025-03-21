package com.example.aisc2024_planta_androidapp.screen.main.garden

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardDefaults.cardColors
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.PopupProperties
import androidx.navigation.NavHostController
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.screen.main.component.DailyTaskSection
import com.example.aisc2024_planta_androidapp.screen.main.garden.component.PremiumAdsCard
import com.example.aisc2024_planta_androidapp.ui.layout_util.FixedGrid
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient

@Composable
fun GardenScreen(
    onNavigateToPlantInfo: () -> Unit,
    onNavigateUpgrade: () -> Unit
) {
    val scrollState = rememberScrollState()
    Scaffold (
        floatingActionButton = { onClickIconAdd() },
        containerColor = colorScheme.surfaceContainer
    ){
        paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(horizontal = 16.dp).padding(paddingValues)
        ) {
            PremiumAdsCard(onNavigateUpgrade)
            Spacer(Modifier.height(16.dp))
            DailyTaskSection()
            MyGardenSection(onNavigateToPlantInfo)
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyPlantCard(start: String,
                end: String,
                onNavigateToPlantInfo: () -> Unit,
                modifier: Modifier = Modifier) {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }

    OutlinedCard(
        colors = cardColors().copy(
            containerColor = colorScheme.surfaceContainerHigh
        ),
        onClick = {
            showBottomSheet = true // TODO
        },
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
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row (
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        Text(start,
                            style = typography.titleMedium.copy(
                                brush = colorScheme.primaryGradient,
                            ),
                            modifier = Modifier.alignByBaseline()
                        )

                        Text(end,
                            style = typography.labelSmall.copy(
                                brush = colorScheme.primaryGradient,
                            ),
                            modifier = Modifier.alignByBaseline()
                        )
                    }
                    LinearProgressIndicator(
                        progress = { 0.4f },
                        modifier = Modifier.fillMaxWidth().height(4.dp),
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
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(64.dp)
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
                    BottomSheetItem(iconId = R.drawable.ic_filter_vintage, title = "Thông tin cây trồng", onClick = {
                        onNavigateToPlantInfo()
                    })
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
        modifier = Modifier
            .clickable { onClick() }
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
fun MyGardenSection(onNavigateToPlantInfo: () -> Unit) {
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
        FixedGrid(
            columns = 2,
            itemCount = 9, // Increased to 9
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
        ) { index ->
            if (index == 0)
            {
                // New MyPlantCard at the beginning
                MyPlantCard("0", "/45 ngày", onNavigateToPlantInfo, Modifier.fillMaxWidth())
            } else if (index == 1)
            {
                MyPlantCard("5", "/45 ngày", onNavigateToPlantInfo, Modifier.fillMaxWidth())
            } else if (index == 2)
            {
                MyPlantCard("8", "/45 ngày", onNavigateToPlantInfo, Modifier.fillMaxWidth())
            } else if (index == 3)
            {
                MyPlantCard("12", "/45 ngày", onNavigateToPlantInfo, Modifier.fillMaxWidth())
            } else if (index == 4)
            {
                MyPlantCard("15", "/45 ngày", onNavigateToPlantInfo, Modifier.fillMaxWidth())
            } else
            {
                MyPlantCard("10", "/45 ngày", onNavigateToPlantInfo, Modifier.fillMaxWidth())
            }
        }
    }
}

@Composable
fun DropdownBox() {
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Trong nhà") }
    Box {
        Box(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(8.dp))
                .border(BorderStroke(1.dp, Color(0xFFCAE0CD)), shape = RoundedCornerShape(8.dp))
                .background(Color(0xFFFDFFFA), shape = RoundedCornerShape(8.dp))
                .clickable(onClick = { expanded = true })
        ) {
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.padding(end = 14.dp)
            ){
                Text(
                    text = selectedOption,
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
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.padding(end = 16.dp, top = 8.dp)
        ) {
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Trong nhà"
                    expanded = false
                },
                text = { Text(text = "Trong nhà") }
            )
            DropdownMenuItem(
                onClick = {
                    selectedOption = "Ngoài trời"
                    expanded = true
                },
                text = {Text(text = "Ngoài trời", color = Color(0xFF005200))}
            )
        }
    }
}

@Composable
fun onClickIconAdd(){
    var expanded by remember { mutableStateOf(value = false) }
    val items = listOf(
        MiniFabItems(R.drawable.icon_plant_outlined, colorScheme.primary, "Thêm cây", false, "Số cây trong vườn đã đầy!"),
        MiniFabItems(R.drawable.icon_doc, colorScheme.primary,"Xuất báo cáo", true, "Bạn đã tạo báo cáo thành công!"),
        MiniFabItems(R.drawable.icon_google_calendar, Color.Unspecified, "Thêm lịch vào Google Calendar", true, "Bạn đã thêm lịch vào báo cáo thành công!")
    )

    val transition = updateTransition(targetState = expanded, label = "transition")
    val rotation by transition.animateFloat(label = "rotation") {
        if (it) 315f else 0f
    }

    Column(horizontalAlignment = Alignment.End) {
        if(expanded){
            AnimatedVisibility(
                visible = expanded,
                enter = fadeIn() + slideInVertically(initialOffsetY = { it }) + expandVertically(),
                exit = fadeOut() + slideOutVertically(targetOffsetY = { it }) + shrinkVertically()
            ) {
                LazyColumn(horizontalAlignment = Alignment.End) {
                    items(items.size) {
                        ItemUi(image = items[it].image, tint = items[it].color, title = items[it].title, premium = items[it].premium, notification = items[it].notification)
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }

        FloatingActionButton(
            onClick = { expanded = !expanded },
            modifier = Modifier.rotate(rotation).size(56.dp),
            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
            shape = CircleShape,
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_add), // Thay thế bằng icon scan của bạn
                contentDescription = "Scan",
                tint = colorScheme.primary
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemUi(image: Int, tint: Color, title: String, premium: Boolean = false, notification: String) {
    var showDialog by remember { mutableStateOf(false) } // State to control dialog visibility

    FloatingActionButton(
        onClick = { showDialog = true }, // Show the dialog on click
        modifier = Modifier.height(40.dp),
        containerColor = colorScheme.surfaceContainer,
        shape = CircleShape
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier.padding(horizontal = 10.dp)
        ) {
            Icon(painter = painterResource(id = image), tint = tint, contentDescription = "")
            Spacer(modifier = Modifier.size(10.dp))
            Text(text = title, color = colorScheme.primary, style = typography.labelLarge)
            Spacer(modifier = Modifier.size(10.dp))
            if (premium) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_stars),
                    tint = Color(0xFFFFCE0A),
                    contentDescription = ""
                )
            }
        }
    }

    // AlertDialog composable
    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false }, // Hide dialog when dismissed
            title = { Text("Thông báo") },
            text = { Text(notification) },
            confirmButton = {
                Button(
                    onClick = {
                        // Handle confirm action
                        showDialog = false
                    }
                ) {
                    Text("OK")
                }
            },
        )
    }
}

data class MiniFabItems(
    val image: Int,
    val color: Color,
    val title: String,
    val premium: Boolean,
    val notification: String
)

