package com.example.aisc2024_planta_androidapp.login
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import com.example.aisc2024_planta_androidapp.R
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material3.TextButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.example.aisc2024_planta_androidapp.ui.theme.focusedTextFieldText
import com.example.aisc2024_planta_androidapp.ui.theme.textFieldContainer
import com.example.aisc2024_planta_androidapp.ui.theme.unfocusedTextFieldText


@Composable
fun LoginTextField(
    modifier: Modifier = Modifier,
    label: String,
    trailing: String
) {
    val uiColor = Color.Black.copy(0.8f)
    OutlinedTextField(
        modifier = modifier,
        value = "",
        onValueChange = {/*TODO*/},
        label = {Text(
            text = label,
            style = MaterialTheme.typography.labelMedium,
            color = uiColor
        )},
        colors = TextFieldDefaults.colors(
            unfocusedPlaceholderColor = MaterialTheme.colorScheme.unfocusedTextFieldText,
            focusedPlaceholderColor = MaterialTheme.colorScheme.focusedTextFieldText,
            unfocusedContainerColor = MaterialTheme.colorScheme.textFieldContainer,
            focusedTextColor = MaterialTheme.colorScheme.textFieldContainer
        ),
        shape = RoundedCornerShape(16.dp),
        trailingIcon = {
            TextButton(onClick = {/*TODO*/}) {
                Text(
                    text = trailing,
                    style = MaterialTheme.typography.labelMedium.copy(fontWeight = FontWeight.Medium),
                    color = uiColor
                )
            }
        },
        singleLine = false
    )
}

