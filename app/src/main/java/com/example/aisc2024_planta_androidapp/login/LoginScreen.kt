package com.example.aisc2024_planta_androidapp.login
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
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.aisc2024_planta_androidapp.R
import com.example.aisc2024_planta_androidapp.ui.theme.onPrimaryLight
import com.example.aisc2024_planta_androidapp.ui.theme.primaryLight

@Composable
fun LoginScreen(
    loginClicked: () -> Unit
) {
    Surface {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background Image
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.login_background),
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )

            // White Box for Login Form
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.7f)
                    .align(Alignment.BottomEnd)
                    .background(Color.White, shape = RoundedCornerShape(16.dp))
                    .selectableGroup()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                ) {
                    // Logo
                    Image(
                        painter = painterResource(id = R.drawable.logo),
                        contentDescription = "Planta Logo",
                        modifier = Modifier
                            .size(80.dp)
                            .align(Alignment.CenterHorizontally)
                    )

                    // Login Form Components
                    Text(
                        text = "Đăng nhập",
                        style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold, fontSize = 24.sp),
                        modifier = Modifier.padding(vertical = 4.dp),
                        color = primaryLight
                    )
                    LoginTextField(label = "Email hoặc số điện thoại", trailing = "", modifier = Modifier.fillMaxWidth())
                    LoginTextField(label = "Mật khẩu", trailing = "", modifier = Modifier.fillMaxWidth())
                    // Add Checkbox for "Duy trì đăng nhập"
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
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))
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
                            style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium))
                    }
                    // Add "Bạn chưa có tài khoản? Đăng ký" Text
                    SignUpPrompt(onSignUpClick = { /*TODO*/ }, modifier = Modifier.padding(top = 16.dp))
                }
            }
        }
    }
}

@Composable
fun SignUpPrompt(
    onSignUpClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Bạn chưa có tài khoản? ",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
        Text(
            text = "Đăng ký",
            style = MaterialTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.Bold
            ),
            color = primaryLight,
            modifier = Modifier.clickable { onSignUpClick() }
        )
    }
}








