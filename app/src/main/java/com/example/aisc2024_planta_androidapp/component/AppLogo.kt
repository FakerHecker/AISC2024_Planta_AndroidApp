package com.example.aisc2024_planta_androidapp.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontVariation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme

@Composable
@OptIn(ExperimentalTextApi::class)
fun AppLogo(
    modifier: Modifier = Modifier,
    size: Dp = 100.dp,
) {
    val scale = size / 100.dp
    // custom font specs for the text
    val bricolageGrotesque = remember { FontFamily(Font(
        R.font.bricolage_grotesque_variable,
        variationSettings = FontVariation.Settings(
            FontVariation.weight(800),
            FontVariation.opticalSizing(96.sp),
            FontVariation.width(100f)
        )
    )) }
    Box(modifier.size(100.dp * scale)) {
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Planta Logo",
            modifier = Modifier
                .size(60.dp * scale)
                .align(Alignment.TopCenter)
        )
        Text("Planta",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 35.27.sp * scale,
                lineHeight = 48.sp * scale,
                fontFamily = bricolageGrotesque,
                brush = Brush.verticalGradient(
                    listOf(Color(0xFF04CB01), colorScheme.primary),
                ),
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun LogoPreview() {
    AISC2024_Planta_AndroidAppTheme {
        AppLogo(size = 200.dp)
    }
}