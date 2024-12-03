package com.example.aisc2024_planta_androidapp.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R

import androidx.compose.ui.focus.onFocusChanged

import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalSoftwareKeyboardController

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    onSearch: (String) -> Unit = {}
) {
    var query by remember { mutableStateOf(TextFieldValue("")) }
    val interactionSource = remember { MutableInteractionSource() }
    var isFocused by remember { mutableStateOf(false) }
    val controller = LocalSoftwareKeyboardController.current

    // Focus management: Keep focus after the search action
    val handleFocusChange: (Boolean) -> Unit = { focused ->
        if (query.text.isNotEmpty()) {
            isFocused = focused
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp),
        border = BorderStroke(1.dp, colorScheme.outline),
        colors = CardDefaults.cardColors(containerColor = colorScheme.surfaceContainerHigh),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_search),
                contentDescription = "Search Icon",
                modifier = Modifier
                    .size(32.dp)
                    .padding(start = 12.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))

            Box(
                modifier = Modifier
                    .weight(1f)
                    .height(32.dp)
                    .padding(start = 6.dp)
            ) {
                // Show placeholder if query is empty and field is not focused
                if (query.text.isEmpty() && !isFocused) {
                    Text(
                        text = "Tìm kiếm cây trồng, triệu chứng bệnh...",  // Placeholder text
                        style = MaterialTheme.typography.bodySmall,
                        color = colorScheme.onSurface,
                        modifier = Modifier.align(Alignment.CenterStart)
                    )
                }

                BasicTextField(
                    singleLine = true,
                    value = query,
                    onValueChange = { newQuery: TextFieldValue ->
                        query = newQuery
                        if (newQuery.text.isNotEmpty()) {
                            isFocused = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .onFocusChanged { focusState ->
                            handleFocusChange(focusState.isFocused)
                        }
                        .padding(top = 8.dp),
                    textStyle = typography.bodySmall,
                    interactionSource = interactionSource,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Search,
                        keyboardType = KeyboardType.Text
                    ),
                    keyboardActions = KeyboardActions(
                        onSearch = {
                            onSearch(query.text) // Call the onSearch callback when "Search" is triggered
                            controller?.hide()
                            isFocused = false
                        }
                    ),
                )
            }

            if (query.text.isNotEmpty()) {
                IconButton(onClick = {
                    query = TextFieldValue("") // Clear the search query
                }) {
                    Icon(Icons.Filled.Clear, contentDescription = "Clear", tint = Color.Gray)
                }
            }
        }
    }
}

@Preview
@Composable
fun SearchBarHomeScreen() {
    SearchBar()
}