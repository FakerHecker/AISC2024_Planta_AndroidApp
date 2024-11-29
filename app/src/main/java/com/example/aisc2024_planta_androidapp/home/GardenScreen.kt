package com.example.aisc2024_planta_androidapp.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(32.dp))
        PremiumUpgradeCard()

        TaskSection()

        Spacer(modifier =  Modifier.height(16.dp))
    }
}

@Composable
fun PremiumUpgradeCard(
    userName: String = "Plantie",
    onCardClick: () -> Unit = {}, // Sự kiện khi bấm vào Card
    onUpgradeClick: () -> Unit = {} // Sự kiện khi bấm vào nút "Nâng cấp ngay"
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onCardClick() },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, Color(0xFFCAE0CD)),
        colors = CardDefaults.cardColors( // Thêm màu nền ở đây
            containerColor = Color(0xFFFCFFF8) // Màu nền của Card
        ),
    ) {
        Row (
            modifier = Modifier
                .padding(10.dp),
            verticalAlignment = Alignment.Top
        ) {
            // Biểu tượng ngôi sao
            Image(
                painter = painterResource(id = R.drawable.icon_premium), // Đường dẫn PNG
                contentDescription = "Premium Icon",
                modifier = Modifier.size(54.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            // Nội dung
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
                // Nút nâng cấp
                Row(
                    modifier = Modifier.fillMaxWidth(), // Đảm bảo Row chiếm toàn bộ chiều rộng
                    horizontalArrangement = Arrangement.End // Căn phải cho nội dung bên trong Row
                ) {
                    Text(
                        text = "Nâng cấp ngay",
                        color = Color(0xFF059710),
                        style = MaterialTheme.typography.labelLarge,
                        modifier = Modifier.padding(0.dp) // Đảm bảo không có padding cho text
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
    plantImageRes: Int
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp, horizontal = 8.dp),
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
            // Hình ảnh cây
            Image(
                painter = painterResource(id = plantImageRes),
                contentDescription = "Plant Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(80.dp)
                    .clip(RoundedCornerShape(4.dp))
            )

            Spacer(modifier = Modifier.width(8.dp))

            // Nội dung cây
            Column(
                //modifier = Modifier.weight(1f)
            ) {
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
                            .size(48.dp) // Kích thước hình tròn 36x36
                            .background(
                                color = Color(0xFFEBFEED), // Màu nền
                                shape = CircleShape // Định dạng hình tròn
                            )
                            .border(
                                width = 1.dp, // Độ dày outline
                                color = Color(0xFFCAE0CD), // Màu outline
                                shape = CircleShape // Outline cũng hình tròn
                            )
                            .padding(8.dp) ,
                        contentAlignment = Alignment.Center// Padding bên trong
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
                            text = "$timeAgo",
                            fontSize = 11.sp,
                            color = Color(0xFF005200),
                            fontWeight = FontWeight.Bold
                        )
                    }

                    Row (
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(3.dp)
                    ){
                        Text(
                            text = "$waterAmount",
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
                        .padding(horizontal = 8.dp), // Padding cho không gian ở 2 bên
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // Nút trái
                    Box(
                        modifier = Modifier
                            .size(40.dp) // Đường kính 40px
                            .clip(CircleShape) // Hình tròn
                            .border(1.dp, Color(0xFFCAE0CD), CircleShape) // Viền 1px màu #CAE0CD
                            .background(Color.White) // Màu nền ban đầu
                            .clickable(
                                onClick = {
                                    // Xử lý sự kiện click ở đây
                                },
                                indication = rememberRipple(
                                    bounded = true, // Hiệu ứng sóng bị giới hạn trong vùng hình tròn
                                    color = Color(0xFF059710).copy(alpha = 0.5f) // Màu sóng và độ mờ rõ hơn
                                ),
                                interactionSource = remember { MutableInteractionSource() } // Tạo nguồn tương tác
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_left), // Đổi với tài nguyên hình ảnh của bạn
                            contentDescription = "Left Button",
                            modifier = Modifier.size(12.dp) // Kích thước hình ảnh
                        )
                    }

                    // Khối chứa text (Đoạn Text "Thứ 4" và "21/08/2024")
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

                    // Nút phải
                    Box(
                        modifier = Modifier
                            .size(40.dp) // Đường kính 40px
                            .clip(CircleShape) // Hình tròn
                            .border(1.dp, Color(0xFFCAE0CD), CircleShape) // Viền 1px màu #CAE0CD
                            .background(Color.White) // Màu nền ban đầu
                            .clickable(
                                onClick = {
                                    // Xử lý sự kiện click ở đây
                                },
                                indication = rememberRipple(
                                    bounded = true, // Hiệu ứng sóng bị giới hạn trong vùng hình tròn
                                    color = Color(0xFF059710).copy(alpha = 0.5f) // Màu sóng và độ mờ rõ hơn
                                ),
                                interactionSource = remember { MutableInteractionSource() } // Tạo nguồn tương tác
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_arrow_right), // Đổi với tài nguyên hình ảnh của bạn
                            contentDescription = "Right Button",
                            modifier = Modifier.size(12.dp) // Kích thước hình ảnh
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
                    waterIconRes = R.drawable.icon_time,  // Bạn thay thế bằng icon của mình
                    plantImageRes = R.drawable.plant_image  // Thay thế với hình ảnh cây
                )
                TaskCard(
                    plantName = "Cây đuôi công",
                    plantStatus = "Trong nhà",
                    timeAgo = "5 phút trước",
                    waterAmount = "Tưới 500ml nước",
                    waterIconRes = R.drawable.icon_time,  // Bạn thay thế bằng icon của mình
                    plantImageRes = R.drawable.plant_image  // Thay thế với hình ảnh cây
                )
                TaskCard(
                    plantName = "Cây đuôi công",
                    plantStatus = "Trong nhà",
                    timeAgo = "5 phút trước",
                    waterAmount = "Tưới 500ml nước",
                    waterIconRes = R.drawable.icon_time,  // Bạn thay thế bằng icon của mình
                    plantImageRes = R.drawable.plant_image  // Thay thế với hình ảnh cây
                )
                TaskCard(
                    plantName = "Cây đuôi công",
                    plantStatus = "Trong nhà",
                    timeAgo = "5 phút trước",
                    waterAmount = "Tưới 500ml nước",
                    waterIconRes = R.drawable.icon_time,  // Bạn thay thế bằng icon của mình
                    plantImageRes = R.drawable.plant_image  // Thay thế với hình ảnh cây
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 116.dp) // Điều chỉnh padding trái/phải để chiều rộng của nút chiếm 1/4
                    .padding(top = 16.dp), // Khoảng cách giữa phần card và nút
                contentAlignment = Alignment.Center
            ) {
                // Sử dụng Box với Modifier.clickable để thay thế Button
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                        .border(1.dp, Color(0xFFCAE0CD), RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                        .clickable(
                            indication = rememberRipple(color = Color(0xFF4CAF50), bounded = true), // Tùy chỉnh màu ripple
                            interactionSource = remember { MutableInteractionSource() } // Quản lý tương tác
                        ) {
                            // Xử lý sự kiện khi nhấn
                            // Ví dụ: Mở rộng hoặc thực hiện hành động nào đó
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Mở rộng", // Chữ "Mở rộng"
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

