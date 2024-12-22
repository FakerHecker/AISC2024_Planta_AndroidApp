package com.example.aisc2024_planta_androidapp.screen.main

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultShadowColor
import androidx.compose.ui.graphics.vector.DefaultTintColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.aisc2024_planta_androidapp.R // Thay thế bằng R của bạn
import com.example.aisc2024_planta_androidapp.screen.main.component.BottomNavigationBar
import com.example.aisc2024_planta_androidapp.screen.main.component.MainScreenTopBar
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient
import com.example.aisc2024_planta_androidapp.ui.theme.surfaceLight
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onScan: () -> Unit,
    onNavigateToProfile: () -> Unit,
    onNavigateUpgrade: () -> Unit,
    onNavigateToPlantInfo: () -> Unit,
    navController: NavHostController = rememberNavController()
) {
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior()
    var titleBarText by rememberSaveable { mutableStateOf("Chào Plantie 🍀") }
    Scaffold(
        topBar = {
            MainScreenTopBar(
                title = titleBarText,
                scrollBehavior = scrollBehavior,
                onNavigateToProfile = onNavigateToProfile
            )
        },
        bottomBar = {
            BottomNavigationBar(
                navController = navController,
                onScan = onScan
            )
        },
        floatingActionButton = {
            onClickIconAdd()
        },
    ) { innerPadding ->
        MainScreenNavHost(
            navController,
            scrollBehavior.nestedScrollConnection,
            onNavigateToPlantInfo,
            onNavigateUpgrade,
            onTitleChange = { titleBarText = it },
            modifier = Modifier.padding(innerPadding)
        )
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
