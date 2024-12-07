package com.example.aisc2024_planta_androidapp.screen.auth.component

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme

@Composable
fun SignInWithGoogleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedButton(
        modifier = modifier.fillMaxWidth(),
        onClick = onClick,
    ) {
        Icon(
            painterResource(R.drawable.icon_google_g), null,
            tint = Color.Unspecified,
            modifier = Modifier.size(18.dp)
        )
        Spacer(Modifier.width(8.dp))
        Text("Đăng nhập với Google")
    }
}

@Preview(showBackground = true)
@Composable
private fun Prev() {
    AISC2024_Planta_AndroidAppTheme {
        SignInWithGoogleButton({}, Modifier.padding(16.dp))
    }
}