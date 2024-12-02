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
fun NewsItem(title: String) {

    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        modifier = Modifier
            .clickable(onClick = {})
            .width(220.dp)
            .clip(RoundedCornerShape(8.dp)),
        border = BorderStroke(
            1.dp, colorScheme.outline
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            //plant iamge
            Image(
                painter = painterResource(id = R.drawable.post_image),
                contentDescription = "Post Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.size(16.dp))
            //title & tag
            Column(
            ) {
                Text(
                    text = "Cách chăm sóc cây cảnh trong nhà",
                    style = typography.labelLarge,
                    fontWeight = FontWeight.Bold,
                    color = colorScheme.onSurfaceVariant
                )
                Spacer(modifier = Modifier.size(4.dp))
                Column(
                    verticalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    Text(
                        text = "Chăm sóc cây · Mẹo vặt",
                        style = typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                        color = colorScheme.onSurfaceVariant
                    )
                    Spacer(modifier = Modifier.size(4.dp))
                    Text(
                        text = "15/08/2024 · 3 phút đọc",
                        style = typography.bodySmall,
                        fontWeight = FontWeight.Normal,
                        color = colorScheme.onSurfaceVariant
                    )
                }
            }
            Spacer(modifier = Modifier.size(16.dp))
            //author
            Row {
                Image(
                    painter = painterResource(id = R.drawable.author_image),
                    contentDescription = "Tác giả",
                    modifier = Modifier.size(20.dp),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.size(4.dp))
                Box(modifier = Modifier.padding(top = 2.dp))
                {
                    Text(
                        text = "Planta",
                        style = typography.labelSmall,
                        fontWeight = FontWeight.Bold,
                        color = colorScheme.onSurfaceVariant
                    )
                }
            }
        }

    }
}