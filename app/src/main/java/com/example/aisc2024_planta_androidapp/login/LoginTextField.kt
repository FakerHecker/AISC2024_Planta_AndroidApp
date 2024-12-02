import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import com.example.aisc2024_planta_androidapp.ui.theme.primaryLight
import androidx.compose.material3.TextFieldDefaults

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    label: String,
    trailing: String,
    isPassword: Boolean = false
) {
    val borderColor = primaryLight // Green border color
    val backgroundColor = Color.White // Light green background color
    val textColor = Color.DarkGray.copy(0.6f)

    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .background(color = backgroundColor, shape = RoundedCornerShape(16.dp)), // Light green background
        value = "",
        onValueChange = { /* TODO */ },
        label = {
            Text(
                text = label,
                style = MaterialTheme.typography.labelMedium,
                color = textColor
            )
        },
       /* colors = TextFieldDefaults.outlinedTextFieldColors(
            unfocusedBorderColor = borderColor,
            focusedBorderColor = borderColor,
            containerColor = backgroundColor,
            focusedTextColor = textColor,
            unfocusedTextColor = textColor,
            cursorColor = textColor,
        ),*/
        shape = RoundedCornerShape(16.dp),
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { /* Toggle password visibility */ }) {
                    Icon(
                        imageVector = Icons.Default.Visibility,
                        contentDescription = "Toggle Password Visibility",
                        tint = textColor
                    )
                }
            } else {
                TextButton(onClick = { /* TODO */ }) {
                    Text(
                        text = trailing,
                        style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                        color = textColor
                    )
                }
            }
        },
        singleLine = true,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None
    )
}

