package com.example.aisc2024_planta_androidapp.home

import com.example.aisc2024_planta_androidapp.R

sealed class BottomNavItem(val title: String, val icon: Int, val route: String) {
    data object Home : BottomNavItem("Trang chủ", R.drawable.ic_home, "home")
    data object Scan : BottomNavItem("", R.drawable.ic_scan, "scan")
    data object Garden : BottomNavItem("Vườn cây", R.drawable.icon_plant_outlined, "garden")
}