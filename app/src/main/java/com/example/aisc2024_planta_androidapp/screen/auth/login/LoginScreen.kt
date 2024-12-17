package com.example.aisc2024_planta_androidapp.screen.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.component.AppLogo
import com.example.aisc2024_planta_androidapp.component.GradientButton
import com.example.aisc2024_planta_androidapp.component.effect.StatusBarColorEffect
import com.example.aisc2024_planta_androidapp.screen.auth.component.SignInWithGoogleButton
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient

@PreviewLightDark
@Composable
private fun LoginPreview() {
    AISC2024_Planta_AndroidAppTheme {
        LoginScreen {}
    }
}

@Composable
fun LoginScreen(
    onLogin: () -> Unit
) {
    StatusBarColorEffect(toDark = true)
    Surface { Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.login_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        // White Box for Login Form
        Column(modifier = Modifier
            .fillMaxWidth()
            .align(Alignment.BottomEnd)
            .background(
                colorScheme.surface, RoundedCornerShape(
                    topStart = 16.dp,
                    topEnd = 16.dp
                )
            )
            .selectableGroup()
            .padding(horizontal = 16.dp)
            .padding(top = 24.dp),
        ) {
            AppLogo(Modifier.align(Alignment.CenterHorizontally))

            // Title
            Text(
                text = "Đăng nhập",
                style = typography.headlineSmall.copy(
                    brush = colorScheme.primaryGradient
                ),
                modifier = Modifier.padding(vertical = 16.dp),
            )

            // Text fields
            // TODO: move to viewmodel
            var invalidCreds by remember { mutableStateOf(false) }
            var username by remember { mutableStateOf("") }
            val supportingText =
                if (invalidCreds) "Thông tin đăng nhập sai hoặc không tồn tại"
                else ""
            // User name
            TextField(
                value = username,
                singleLine = true,
                supportingText = { Text(supportingText) },
                isError = invalidCreds,
                onValueChange = { username = it; invalidCreds = false },
                label = { Text("Email hoặc số điện thoại") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 20.dp)
            )

            // TODO: refactor to component
            var password by remember { mutableStateOf("") }
            PasswordField(
                password = password,
                onPasswordChange = {password = it},
                isError = invalidCreds
            )

            Row(
                modifier = Modifier.fillMaxWidth().padding(top = 4.dp, bottom = 40.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.offset((-14).dp)
                ) {
                    var rememberLogin by remember { mutableStateOf(false) }
                    Checkbox(
                        checked = rememberLogin,
                        onCheckedChange = { rememberLogin = it },
                        colors = CheckboxDefaults.colors(
                            uncheckedColor = Color.Gray
                        )
                    )
                    Text("Duy trì đăng nhập")
                }
                TextButton(
                    onClick = {},
                    modifier = Modifier.offset(x = 12.dp)
                ) { Text("Quên mật khẩu?") }
            }
            GradientButton (
                gradient = colorScheme.primaryGradient,
                modifier = Modifier.fillMaxWidth(),
                onClick = { onLogin() }, // TODO: move to viewmodel
            ) {
                Text("Đăng nhập")
            }
            Spacer(modifier = Modifier.height(10.dp))
            // Sign in with google
            SignInWithGoogleButton(onClick = {})
            // sign up option
            Row(
                modifier = Modifier
                    .padding(top = 40.dp, bottom = 22.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bạn chưa có tài khoản? ",
                    style = typography.bodyMedium,
                )
                TextButton(
                    onClick = {},
                    modifier = Modifier.offset((-4).dp)
                ) {
                    Text("Đăng ký")
                }
            }
        }
    } }
}

@Composable
private fun PasswordField(
    password: String,
    onPasswordChange: (String) -> Unit,
    isError: Boolean
) {
    var showPassword by remember { mutableStateOf(false) }
    TextField(
        value = password,
        isError = isError,
        singleLine = true,
        onValueChange = onPasswordChange,
        label = { Text("Mật khẩu") },
        trailingIcon = {
            IconButton(onClick = { showPassword = !showPassword }) {
                val icon =
                    if (showPassword) Icons.Outlined.VisibilityOff
                    else Icons.Outlined.Visibility
                Icon(icon, "Show/hide password")
            }
        },
        visualTransformation =
            if (showPassword) VisualTransformation.None
            else PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth()
    )
}