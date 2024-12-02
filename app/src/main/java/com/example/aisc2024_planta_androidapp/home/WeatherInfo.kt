package com.example.aisc2024_planta_androidapp.home

import android.annotation.SuppressLint
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
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.aisc2024_planta_androidapp.AppRoute
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.login.LoginScreen
import com.example.aisc2024_planta_androidapp.scan.ScanScreen
import com.example.aisc2024_planta_androidapp.scan_result.diagnose.ScanResultDiagnoseScreen
import com.example.aisc2024_planta_androidapp.scan_result.info.ScanResultInfoScreen

@Composable
fun WeatherInfo() {

    val temperature = "34°"

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(252.dp),
        colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainerHigh),
        border = BorderStroke(1.dp, colorScheme.outline)
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(start = 16.dp)
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
                        Text(
                            text = "Thành phố Hồ Chí Minh",
                            style = MaterialTheme.typography.labelSmall,
                            color = colorScheme.onSurfaceVariant,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.clickable {

                            }
                        )
                    }
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = temperature,
                        style = MaterialTheme.typography.headlineLarge,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurfaceVariant,
                    )
                    Text(
                        text = "Nắng đẹp",
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurfaceVariant,
                    )

                    // Grid-like structure for weather details
                }

                // Right side: Weather image
                Image(
                    modifier = Modifier
                        .padding(top = 8.dp, end = 16.dp)
                        .size(120.dp),
                    painter = painterResource(id = R.drawable.sunny_image), // Replace with your image resource
                    contentDescription = "Weather Icon",
                )
            }
            Spacer(modifier = Modifier.size(8.dp))
            // Statistics
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
            ) {
                // First Row
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    WeatherDetailItem(
                        iconRes = R.drawable.icon_sun,
                        label = "Chỉ số UV",
                        value = "Trung bình",
                        color = Color(0xFFFFCE0A)
                    )
                    WeatherDetailItem(
                        iconRes = R.drawable.icon_wind,
                        label = "Tốc độ gió",
                        value = "16km/h",
                        color = Color(0xFF8F19F0)
                    )
                }
                Spacer(modifier = Modifier.size(16.dp))
                // Second Row
                Row(
                    modifier = Modifier.fillMaxWidth().padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    WeatherDetailItem(
                        iconRes = R.drawable.icon_water,
                        label = "Độ ẩm",
                        value = "58%",
                        color = Color(0xFF0BD51C)
                    )
                    WeatherDetailItem(
                        iconRes = R.drawable.icon_rain,
                        label = "Khả năng mưa",
                        value = "14%",
                        color = Color(0xFF3E497A)
                    )
                }
            }
        }

    }
}