package com.example.aisc2024_planta_androidapp.ui.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val ColorScheme.focusedTextFieldText
    @Composable
    get() = Color.Black

val ColorScheme.unfocusedTextFieldText
    @Composable
    get() = Color.White.copy(0.6f)

val ColorScheme.textFieldContainer
    @Composable
    get() = Color.Black.copy(0.2f)