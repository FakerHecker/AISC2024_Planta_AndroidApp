package com.example.aisc2024_planta_androidapp.screen.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.outlined.Visibility
import androidx.compose.material.icons.outlined.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme
import com.example.aisc2024_planta_androidapp.ui.theme.onPrimaryLight
import com.example.aisc2024_planta_androidapp.ui.theme.primaryGradient
import com.example.aisc2024_planta_androidapp.ui.theme.primaryLight

@Preview
@Composable
private fun LoginPreview() {
    AISC2024_Planta_AndroidAppTheme {
        LoginScreen {}
    }
}

@Composable
fun LoginScreen(
    loginClicked: () -> Unit
) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Background Image
        Image(
            modifier = Modifier.fillMaxSize(),
            painter = painterResource(R.drawable.login_background),
            contentDescription = null,
            contentScale = ContentScale.FillBounds
        )

        // White Box for Login Form
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomEnd)
                .background(colorScheme.surface, RoundedCornerShape(16.dp))
                .selectableGroup()
                .padding(horizontal = 16.dp)
                .padding(top = 24.dp),
        ) {
            // Logo
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Planta Logo",
                modifier = Modifier
                    .size(100.dp)
                    .align(Alignment.CenterHorizontally)
            )

            // Login Form Components
            Text(
                text = "Đăng nhập",
                style = typography.headlineSmall.copy(
                    brush = colorScheme.primaryGradient
                ),
                modifier = Modifier.padding(vertical = 16.dp),
                color = primaryLight
            )
            var username by remember { mutableStateOf("") }
            TextField(
                value = username,
                supportingText = { Text("123") },
                onValueChange = { username = it },
                label = { Text("Email hoặc số điện thoại") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
            )
            var showPassword by remember { mutableStateOf(false) }
            // TODO: refactor to component
            var password by remember { mutableStateOf("") }
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Mật khẩu") },
                trailingIcon = {
                    IconButton(onClick = {showPassword = !showPassword}) {
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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    var rememberLogin by remember { mutableStateOf(false) }
                    Checkbox(
                        modifier = Modifier.offset(x = (-12).dp),
                        checked = rememberLogin,
                        onCheckedChange = { rememberLogin = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = primaryLight,
                            uncheckedColor = Color.Gray
                        )
                    )
                    Text(
                        modifier = Modifier.offset(x = (-16).dp),
                        text = "Duy trì đăng nhập",
                        color = Color.Black,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal
                    )
                }
                Text(
                    text = "Quên mật khẩu?",
                    color = primaryLight,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                onClick = {loginClicked()},
                colors = ButtonDefaults.buttonColors(
                    containerColor = primaryLight,
                    contentColor = onPrimaryLight
                ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = "Đăng nhập",
                    style = typography.labelMedium.copy(fontWeight = FontWeight.Medium))
            }
            Spacer(modifier = Modifier.height(10.dp))
            // Add "Đăng nhập với Google" Button
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White.copy(0.6f),
                    contentColor = Color.Black
                ),
                border = BorderStroke(width = 1.dp, Color.LightGray)
            )
            {
                Text(
                    text = "Đăng nhập với Google",
                    style = typography.labelMedium.copy(fontWeight = FontWeight.Medium))
            }
            // Add "Bạn chưa có tài khoản? Đăng ký" Text
            Row(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Bạn chưa có tài khoản? ",
                    style = typography.bodyMedium,
                )
                Text(
                    text = "Đăng ký",
                    style = typography.bodyMedium.copy(
                        fontWeight = FontWeight.Bold
                    ),
                )
            }
        }
    }
}

@Composable
fun SignUpPrompt(
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {

}
