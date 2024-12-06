package com.example.aisc2024_planta_androidapp.screen.account

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
fun AccountScreen() {
    Surface {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState())
        ) {
            ProfileHeader()
            Spacer(modifier = Modifier.height(16.dp))
            StatsSection()
            Spacer(modifier = Modifier.height(16.dp))
            UtilitiesSection()
            Spacer(modifier = Modifier.height(16.dp))
            SettingsSection()
            Spacer(modifier = Modifier.weight(1f))
            LogoutButton()
        }
    }
}

@Composable
fun ProfileHeader() {
    Box {
        // Background Image
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp), // Adjust height for the cover
            painter = painterResource(id = R.drawable.cover_account), // Replace with actual resource
            contentDescription = null,
            contentScale = ContentScale.Crop
        )

        // Profile Content
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 150.dp), // Move content below the background
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Picture
            Image(
                painter = painterResource(id = R.drawable.container_profile), // Replace with actual profile image
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.White, CircleShape)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text("Plantie", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Black)
            Text("Thành phố Hồ Chí Minh", fontSize = 14.sp, color = Color.Gray)
        }

        // Top Overlay Text (Tài khoản) with Back Icon
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 56.dp), // Position the text
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowBack, // Back arrow icon
                contentDescription = "Back",
                tint = Color.White,
                modifier = Modifier
                    .size(24.dp)
                    .clickable { /* Handle back button action */ }
            )
            Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
            Text(
                text = "Tài khoản",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Image(
            painter = painterResource(id = R.drawable.ic_edit),
            contentDescription = "Edit Profile",
            modifier = Modifier
                .size(42.dp)
                .align(Alignment.TopEnd)
                .offset(x = (-16).dp, y = 216.dp)
                .clickable {  }
                // Add background color to see if it's rendering
        )
    }
}

@Composable
fun StatsSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        StatCard("Gói người dùng", "Free", "Xem đặc quyền >", R.drawable.member_card, null)
        {
            // Clickable
        }
        StatCard("Tích điểm", "1,200", "Tìm thêm điểm >", R.drawable.img_points, R.drawable.ic_point)
        {
            // Clickable
        }
    }
}

@Composable
fun StatCard(
    title: String,
    value: String,
    subtitle: String,
    backgroundImage: Int,
    iconRes: Int?,
    onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width((175.5f).dp) // Adjust width
            .height(90.dp)
            .clickable { onClick() }, // Adjust height
        shape = RoundedCornerShape(12.dp), // Rounded corners
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Background Image
            Image(
                painter = painterResource(id = backgroundImage), // Background image
                contentDescription = null,
                contentScale = ContentScale.Crop, // Crop to fit the box
                modifier = Modifier.fillMaxSize()
            )

            // Overlay Text
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp), // Padding inside the card
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                // Title
                Text(
                    text = title,
                    fontSize = 12.sp,
                    color = Color(0xFF4CAF50), // Green color for the title
                    fontWeight = FontWeight.Bold
                )

                // Value with Icon
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Value Text
                    Text(
                        text = value,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black // Text color for value
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    // Leaf Icon
                    iconRes?.let { painterResource(id = it) }?.let {
                        Icon(
                            painter = it, // Replace with your leaf icon
                            contentDescription = null,
                            tint = Color.Unspecified, // Original icon colors
                            modifier = Modifier
                                .size(24.dp) // Icon size
                                .padding(end = 4.dp) // Space between icon and text
                        )
                    }
                }

                // Subtext (e.g., "Xem đặc quyền")
                Text(
                    text = subtitle,
                    fontSize = 10.sp,
                    color = Color(0xFF4CAF50) // Green accent
                )
            }
        }
    }
}


@Composable
fun UtilitiesSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text("Tiện ích", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        FeatureItem("Vườn cây của tôi", "6 cây trồng", R.drawable.ic_plant)
        HorizontalDivider(modifier = Modifier.padding(vertical = 0.dp))
        FeatureItem("Danh sách yêu thích", "5 cây trồng", R.drawable.ic_favourite)
        HorizontalDivider(modifier = Modifier.padding(vertical = 0.dp))
        FeatureItem("Lịch sử chăm cây", "24 lượt chăm cây", R.drawable.ic_history)
    }
}

@Composable
fun SettingsSection() {
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text("Cài đặt", fontSize = 18.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        SettingItem("Cài đặt thông báo", R.drawable.ic_notifications)
        HorizontalDivider(modifier = Modifier.padding(vertical = 0.dp))
        SettingItem("Thông tin ứng dụng", R.drawable.ic_info)
        HorizontalDivider(modifier = Modifier.padding(vertical = 0.dp))
        SettingItem("Trung tâm trợ giúp", R.drawable.ic_help)
        HorizontalDivider(modifier = Modifier.padding(vertical = 0.dp))
        SettingItem("Quản lý tài khoản", R.drawable.ic_account)
    }
}

@Composable
fun LogoutButton() {
    Button(
        onClick = { /* Handle Logout */ },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)) // Green button
    ) {
        Text("Đăng xuất", color = Color.White, fontSize = 16.sp)
    }
}

@Composable
fun SettingItem(title: String, iconRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { /* Handle Click */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Feature Icon
        Image(
            painter = painterResource(id = iconRes), // Replace with your drawable resource
            contentDescription = title, // Accessibility description
            modifier = Modifier.size(36.dp) // Set the size of the image
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, fontSize = 16.sp, fontWeight = FontWeight.Medium)
    }
}

@Composable
fun FeatureItem(title: String, subtitle: String, iconRes: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { /* Handle Click */ },
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Feature Icon
        Image(
            painter = painterResource(id = iconRes), // Replace with your drawable resource
            contentDescription = title, // Accessibility description
            modifier = Modifier.size(36.dp) // Set the size of the image
        )

        Spacer(modifier = Modifier.width(16.dp)) // Space between icon and text

        Column {
            // Feature Title
            Text(
                text = title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )

            // Feature Subtitle
            Text(
                text = subtitle,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

