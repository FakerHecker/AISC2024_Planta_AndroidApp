package com.example.aisc2024_planta_androidapp.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aisc2024_planta_androidapp.R

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
                modifier = Modifier
                    .fillMaxWidth()
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
                            border = BorderStroke(
                                0.5.dp,
                                Color(0xFFCAE0CD)
                            ),  // Độ dày và màu sắc của viền
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