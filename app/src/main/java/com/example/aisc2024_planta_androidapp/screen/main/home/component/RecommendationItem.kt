package com.example.aisc2024_planta_androidapp.screen.main.home.component

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedIconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient
import kotlinx.coroutines.delay

@Composable
fun RecommendationItem(
    name: String,
    category: String,
    duration: String,
    imageModel: Any?,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    var showSuccessDialog by remember { mutableStateOf(false) } // State for success dialog

    OutlinedCard(
        onClick = {},
        colors = CardDefaults.outlinedCardColors().copy(
            containerColor = colorScheme.surfaceContainerHigh
        ),
        shape = RoundedCornerShape(8.dp),
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            AsyncImage(
                model = imageModel,
                contentDescription = "Recommend Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.Crop
            )
            Column {
                Text(
                    text = name,
                    style = typography.labelLarge,
                    color = colorScheme.onSurfaceVariant
                )
                Text(
                    text = category,
                    style = typography.bodySmall,
                    color = colorScheme.onSurfaceVariant
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = duration,
                    style = typography.titleMedium.copy(
                        brush = colorScheme.primaryGradient
                    )
                )
                OutlinedIconButton(
                    onClick = {
                        showDialog = true
                    },
                    border = BorderStroke(1.dp, colorScheme.outline)
                ) {
                    Icon(
                        painter = painterResource(R.drawable.icon_plant_outlined),
                        contentDescription = "Recommend Icon",
                        tint = colorScheme.primary
                    )
                }
            }
        }
    }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            icon = {
                Icon(painterResource(R.drawable.logo), contentDescription = null)
            },
            title = {
                Text(text = "Thêm cây")
            },
            text = {
                Text(text = "Bạn có muốn thêm cây này vào vườn?")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                        showSuccessDialog = true // Show success dialog
                    }
                ) {
                    Text("Thêm")
                }
            },
            dismissButton = {
                TextButton(
                    onClick = {
                        showDialog = false
                    }
                ) {
                    Text("Hủy")
                }
            }
        )
    }

    // Success Dialog
    if (showSuccessDialog) {
        AlertDialog(
            onDismissRequest = { showSuccessDialog = false },
            title = {
                Text(text = "Thành công")
            },
            text = {
                Text(text = "Bạn đã thêm cây vào vườn thành công!")
            },
            confirmButton = {
                TextButton(
                    onClick = {
                        showSuccessDialog = false
                    }
                ) {
                    Text("OK")
                }
            }
        )
    }
}