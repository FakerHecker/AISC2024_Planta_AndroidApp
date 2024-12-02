package com.example.aisc2024_planta_androidapp.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.aisc2024_planta_androidapp.AppRoute
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient
import com.example.aisc2024_planta_androidapp.util.addGradient

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    onScan: () -> Unit,
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.Scan,
        BottomNavItem.Garden
    )

    NavigationBar {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val selected = currentRoute == item.route
            NavigationBarItem(
                icon = {
                    // Special styling for the middle button
                    if (item == BottomNavItem.Scan) {
                        Box(
                            modifier = Modifier
                                .size(48.dp)
                                .background(colorScheme.primaryGradient, CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                painter = painterResource(item.icon),
                                tint = colorScheme.onPrimary,
                                contentDescription = item.title,
                            )
                        }
                        return@NavigationBarItem
                    }
                    val iconModifier =
                        if (!selected) Modifier
                        else Modifier.addGradient(colorScheme.primaryGradient)
                    Icon(
                        // TODO: add filled and outlined variants for selected state
                        painter = painterResource(item.icon),
                        contentDescription = item.title,
                        modifier = iconModifier.size(24.dp),
                        tint = if (selected) colorScheme.primary else colorScheme.onSurfaceVariant
                    )
                },
                label = {
                    if (item != BottomNavItem.Scan) {
                        Text(
                            text = item.title,
                            color = if (selected) colorScheme.primary else colorScheme.onSurfaceVariant
                        )
                    }
                },
                onClick = {
                    if (selected) return@NavigationBarItem
                    when (item) {
                        BottomNavItem.Home -> navController.navigate(AppRoute.HomeScreen.name) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                        BottomNavItem.Scan -> onScan()
                        BottomNavItem.Garden -> navController.navigate(AppRoute.Garden.name) {
                            popUpTo(navController.graph.startDestinationId) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                selected = false,
                alwaysShowLabel = item != BottomNavItem.Scan // Hide the label for the middle button
            )
        }
    }
}