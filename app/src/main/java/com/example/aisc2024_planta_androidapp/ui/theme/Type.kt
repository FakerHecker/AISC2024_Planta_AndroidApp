package com.example.aisc2024_planta_androidapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
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

val beVietnamProFamily = FontFamily(
    Font(R.font.be_vietnam_pro_regular),
    Font(R.font.be_vietnam_pro_black, FontWeight.Black),
    Font(R.font.be_vietnam_pro_extra_bold, FontWeight.ExtraBold),
    Font(R.font.be_vietnam_pro_bold, FontWeight.Bold),
    Font(R.font.be_vietnam_pro_semi_bold, FontWeight.SemiBold),
    Font(R.font.be_vietnam_pro_medium, FontWeight.Medium),
    Font(R.font.be_vietnam_pro_light, FontWeight.Light),
    Font(R.font.be_vietnam_pro_extra_light, FontWeight.ExtraLight),
    Font(R.font.be_vietnam_pro_thin, FontWeight.Thin),

    Font(R.font.be_vietnam_pro_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.be_vietnam_pro_black_italic, FontWeight.Black, FontStyle.Italic),
    Font(R.font.be_vietnam_pro_extra_bold_italic, FontWeight.ExtraBold, FontStyle.Italic),
    Font(R.font.be_vietnam_pro_bold_italic, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.be_vietnam_pro_semi_bold_italic, FontWeight.SemiBold, FontStyle.Italic),
    Font(R.font.be_vietnam_pro_medium_italic, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.be_vietnam_pro_light_italic, FontWeight.Light, FontStyle.Italic),
    Font(R.font.be_vietnam_pro_extra_light_italic, FontWeight.ExtraLight, FontStyle.Italic),
    Font(R.font.be_vietnam_pro_thin_italic, FontWeight.Thin, FontStyle.Italic),
)

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

    titleLarge = TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        fontWeight = FontWeight.W700,
    ),
    titleMedium = TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight.W700,
    ),
    titleSmall = TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.W700,
    ),

    labelLarge = TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.W700,
    ),
    labelMedium = TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.W700,
    ),
    labelSmall = TextStyle(
        fontFamily = bricolageGrotesqueBold,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.W700,
    ),

    bodyLarge = TextStyle(
        fontFamily = beVietnamProFamily,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        fontWeight = FontWeight.W400,
    ),
    bodyMedium = TextStyle(
        fontFamily = beVietnamProFamily,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.W400,
    ),
    bodySmall = TextStyle(
        fontFamily = beVietnamProFamily,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        fontWeight = FontWeight.W400,
    )
)

