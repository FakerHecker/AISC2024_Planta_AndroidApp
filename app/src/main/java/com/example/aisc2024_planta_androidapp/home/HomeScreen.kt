package com.example.aisc2024_planta_androidapp.home
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Message
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        ){
            // Icon profile
            Image(
                painter = painterResource(id = R.drawable.container_profile),
                contentDescription = "User Profile",
                modifier = Modifier
                    .size(40.dp)
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
        Text(
            text = "Tin tức mới",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        NewsSection()

        // Recommendations
        Text(
            text = "Gợi ý cho bạn",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 16.dp)
        )
        Recommendations()
    }
}

@Composable
fun WeatherInfo() {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE8F5E9))
    )
    {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {
                // Left side: Weather information
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Row()
                    {
                        Icon(imageVector = Icons.Default.LocationOn, 
                            contentDescription = "Location", 
                            modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.size(3.dp))
                        ClickableText(
                            text = AnnotatedString(
                                text = "Thành phố Hồ Chí Minh",
                                spanStyle = SpanStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                )
                            )) {
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
                        text = "Nắng đẹp",
                        fontSize = 20.sp,
                        color = Color.Black
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
                    WeatherDetailItem(iconRes = R.drawable.icon_uv, label = "Chỉ số UV", value = "Trung bình")
                    WeatherDetailItem(iconRes = R.drawable.icon_uv, label = "Tốc độ gió", value = "16km/h")
                }
                // Second Row
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    WeatherDetailItem(iconRes = R.drawable.icon_uv, label = "Độ ẩm", value = "58%")
                    WeatherDetailItem(iconRes = R.drawable.icon_uv, label = "Khả năng mưa", value = "14%")
                }
            }
        }

    }
}

@Composable
fun WeatherDetailItem(iconRes: Int, label: String, value: String) {
    Box(modifier = Modifier
        .size(width = 160.dp, height = 60.dp)){
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier.padding(start = 12.dp)
        ){
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = label,
                modifier = Modifier.size(40.dp) // Adjust icon size
            )
            Spacer(modifier = Modifier.size(2.dp))
            Column (){
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
    Column {
        // Example news items
        NewsItem("Cách chăm sóc cây cảnh trong nhà")
        NewsItem("Cách chăm sóc cây đuôi công")
    }
}

@Composable
fun NewsItem(title: String) {
    Text(text = title, modifier = Modifier.padding(vertical = 4.dp))
}

@Composable
fun Recommendations() {
    Column {
        // Example recommendations
        RecommendationItem("Cây đuôi công", "45 ngày")
        RecommendationItem("Cây đuôi công", "45 ngày")
    }
}

@Composable
fun RecommendationItem(name: String, duration: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = name, modifier = Modifier.weight(1f))
        Text(text = duration, modifier = Modifier.weight(1f))
    }
}