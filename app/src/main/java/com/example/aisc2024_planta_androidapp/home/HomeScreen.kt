package com.example.aisc2024_planta_androidapp.home

import android.util.Log
import android.widget.HorizontalScrollView
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Message
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aisc2024_planta_androidapp.R

@Composable
fun HomeScreen() {
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icon profile
            Image(
                painter = painterResource(id = R.drawable.container_profile),
                contentDescription = "User Profile",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.size(10.dp))
            // Text Header
            Text(
                text = "Chào Plantie 🍀",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .weight(1f)
            )
            // Message icon
            Icon(
                imageVector = Icons.AutoMirrored.Filled.Message,
                contentDescription = "Message Icon",

                modifier = Modifier
                    .size(40.dp)
                    .padding(top = 16.dp)
            )
        }
        Spacer(modifier = Modifier.padding(10.dp))
        Text(
            text = "Thời tiết hôm nay",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        // Weather Info
        WeatherInfo()

        // Tasks for Today
        Text(
            text = "Nhiệm vụ trong ngày",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        TaskList()

        // News Section
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Tin tức mới",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF005200),
                modifier = Modifier.padding(vertical = 16.dp)
            )
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(
                        onClick = {
                        },
                        indication = null,
                        interactionSource = remember { MutableInteractionSource() })
                    .background(Color.Transparent)
                    .offset(x = (16).dp),
            ) {
                Text(
                    text = "Xem tất cả",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF059710)
                )
            }
//            TextButton(
//                onClick = {},
//                modifier = Modifier
//                    .background(Color.Transparent)
//                    .offset(x = (16).dp)
//                    .indication(
//                        interactionSource = remember { MutableInteractionSource() },
//                        indication = null
//                    ),
//                colors = ButtonDefaults.textButtonColors(
//                    containerColor = Color.Transparent,
//                    contentColor = Color(0xFF059710)
//                ),
//                shape = RectangleShape,
//                contentPadding = PaddingValues(15.dp, 12.dp),
//            ) {
//                Text(
//                    text = "Xem tất cả",
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold
//                )
//            }
        }
        Spacer(modifier = Modifier.padding(2.dp))
        NewsSection()

        // Recommendations
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Gợi ý cho bạn",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF005200),
                modifier = Modifier.padding(vertical = 16.dp)
            )
//            Box(
//                modifier = Modifier
//                    .padding(16.dp)
//                    .clickable(
//                        onClick = {
//                        },
//                        indication = null,
//                        interactionSource = remember { MutableInteractionSource() })
//                    .background(Color.Transparent)
//                    .offset(x = (16).dp),
//            ) {
//                Text(
//                    text = "Xem tất cả",
//                    fontSize = 20.sp,
//                    fontWeight = FontWeight.Bold,
//                    color = Color(0xFF059710)
//                )
//            }
        }
        Recommendations()
    }
}

@Composable
fun WeatherInfo() {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9))
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(16.dp)
            ) {
                // Left side: Weather information
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row() {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location",
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(modifier = Modifier.size(3.dp))
                        ClickableText(
                            text = AnnotatedString(
                                text = "Thành phố Hồ Chí Minh", spanStyle = SpanStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            )
                        ) {
                            // Can click to call API location
                        }
                    }

                    Text(
                        text = "34°",
                        fontSize = 48.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                    Text(
                        text = "Nắng đẹp", fontSize = 20.sp, color = Color.Black
                    )

                    // Grid-like structure for weather details
                }

                // Right side: Weather image
                Image(
                    painter = painterResource(id = R.drawable.sunny_image), // Replace with your image resource
                    contentDescription = "Weather Icon",
                    modifier = Modifier.size(100.dp) // Adjust size as needed
                )
            }
            // Statistics
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // First Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    WeatherDetailItem(
                        iconRes = R.drawable.icon_uv, label = "Chỉ số UV", value = "Trung bình"
                    )
                    WeatherDetailItem(
                        iconRes = R.drawable.icon_uv, label = "Tốc độ gió", value = "16km/h"
                    )
                }
                // Second Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    WeatherDetailItem(iconRes = R.drawable.icon_uv, label = "Độ ẩm", value = "58%")
                    WeatherDetailItem(
                        iconRes = R.drawable.icon_uv, label = "Khả năng mưa", value = "14%"
                    )
                }
            }
        }

    }
}

@Composable
fun WeatherDetailItem(iconRes: Int, label: String, value: String) {
    Box(
        modifier = Modifier.size(width = 160.dp, height = 60.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.Start, modifier = Modifier.padding(start = 12.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier.size(40.dp) // Adjust icon size
            )
            Spacer(modifier = Modifier.size(2.dp))
            Column() {
                Text(text = label, fontSize = 12.sp, color = Color.Gray)
                Text(text = value, fontSize = 14.sp, fontWeight = FontWeight.Bold)
            }
        }
    }

}

@Composable
fun TaskList() {
    Column {
        // Example tasks
        TaskItem("Cây đuôi công", "5 phút trước", "Tưới 500ml nước +2")
        TaskItem("Cây đuôi công", "2:45 pm", "Tưới 500ml nước +2")
        TaskItem("Cây đuôi công", "9:00 am", "Xới đất +2")
    }
}

@Composable
fun TaskItem(name: String, time: String, action: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = name, modifier = Modifier.weight(1f))
        Text(text = time, modifier = Modifier.weight(1f))
        Text(text = action, modifier = Modifier.weight(1f))
    }
}

@Composable
fun NewsSection() {
    val scrollState = rememberScrollState()

    Row(
        horizontalArrangement = Arrangement.spacedBy(14.dp),
        modifier = Modifier.horizontalScroll(scrollState)
    ) {
        // Example news items
        NewsItem("post 1")
        NewsItem("post 2")
        NewsItem("post 3")
    }
}

@Composable
fun NewsItem(title: String) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .clickable(onClick = {})
            .width(220.dp)
            .height(248.dp)
            .clip(RoundedCornerShape(6.dp)),
        border = BorderStroke(
            1.66.dp, Color(0xFFCAE0CD)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            //plant iamge
            Image(
                painter = painterResource(id = R.drawable.post_image),
                contentDescription = "Post Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(95.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            //title & tag
            Column(
            ) {
                Text(
                    text = "Cách chăm sóc cây cảnh trong nhà",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF005200)
                )
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    Text(
                        text = "Chăm sóc cây · Mẹo vặt",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF005200)
                    )
                    Text(
                        text = "15/08/2024 · 3 phút đọc",
                        fontSize = 13.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color(0xFF005200)
                    )
                }
            }
            //author
            Row {
                Image(
                    painter = painterResource(id = R.drawable.author_image),
                    contentDescription = "Tác giả",
                    modifier = Modifier.size(25.dp),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = "Planta",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF005200)
                )
            }
        }

    }
}

@Composable
fun Recommendations() {
    Column (
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        Row  (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            // Example recommendations
            RecommendationItem("Cây đuôi công", "45 ngày")
            RecommendationItem("Cây đuôi công", "45 ngày")
        }
        Row  (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            // Example recommendations
            RecommendationItem("Cây đuôi công", "45 ngày")
            RecommendationItem("Cây đuôi công", "45 ngày")
        }
        Row  (
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ){
            // Example recommendations
            RecommendationItem("Cây đuôi công", "45 ngày")
            RecommendationItem("Cây đuôi công", "45 ngày")
        }
    }
}

@Composable
fun RecommendationItem(name: String, duration: String) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .clickable(onClick = {})
            .width(180.dp)
            .height(275.dp)
            .clip(RoundedCornerShape(6.dp)),
        border = BorderStroke(
            1.66.dp, Color(0xFFCAE0CD)
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            //plant iamge
            Image(
                painter = painterResource(id = R.drawable.plant_image),
                contentDescription = "Recommend Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            //title & tag
            Column(
            ) {
                Text(
                    text = "Cây đuôi cong",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF005200)
                )
                Text(
                    text = "Trong nhà · Trang trí",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF005200)
                )
            }
            //author
            Row (
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
                    .padding(0.dp, 0.dp, 4.dp, 0.dp)
            ) {
                Text(
                    text = "45 ngày",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF04CB010)
                )
                Box(
                    modifier = Modifier
                        .border(
                            border = BorderStroke(0.5.dp, Color(0xFFCAE0CD)),  // Độ dày và màu sắc của viền
                            shape = CircleShape  // Hình dạng viền là hình tròn
                        )
                        .padding(8.dp)  // Khoảng cách giữa icon và viền
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.potted_plant),
                        contentDescription = "Recommend Icon",
                        modifier = Modifier
                            .size(25.dp),
                        tint = Color(0xFF059710)
                    )
                }


            }
        }

    }
}