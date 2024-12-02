package com.example.aisc2024_planta_androidapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.aisc2024_planta_androidapp.R

@OptIn(ExperimentalTextApi::class)
val bricolageGrotesqueBold = FontFamily(Font(
    R.font.bricolage_grotesque_variable,
    variationSettings = FontVariation.Settings(
        FontVariation.weight(700),
        FontVariation.opticalSizing(57.sp)
    )
))
@OptIn(ExperimentalTextApi::class)
val bricolageGrotesqueDisplay = FontFamily(Font(
    R.font.bricolage_grotesque_variable,
    variationSettings = FontVariation.Settings(
        FontVariation.weight(800)
    )
))

// Set of Material typography styles to start with
val Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = bricolageGrotesqueDisplay,
        fontWeight = FontWeight.W800,
        fontSize = 57.sp,
        lineHeight = 64.sp,
    ),
    displayMedium = TextStyle(
        fontFamily = bricolageGrotesqueDisplay,
        fontWeight = FontWeight.W800,
        fontSize = 45.sp,
        lineHeight = 52.sp,
    ),
    displaySmall = TextStyle(
        fontFamily = bricolageGrotesqueDisplay,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        fontWeight = FontWeight.W800,
    ),

    headlineLarge = TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        fontWeight = FontWeight.W700,
    ),
    headlineMedium = TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 28.sp,
        lineHeight = 36.sp,
        fontWeight = FontWeight.W700,
    ),
    headlineSmall = TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        fontWeight = FontWeight.W700,
    ),

    titleLarge =  TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.W700,
    ),
    titleMedium =  TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.W700,
    ),
    titleSmall =  TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.W700,
    ),

    labelLarge =  TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.W700,
    ),
    labelMedium =  TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.W700,
    ),
    labelSmall =  TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.W700,
    ),


    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

