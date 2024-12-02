package com.example.aisc2024_planta_androidapp.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenTopBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
            Text("Chào Plantie 🍀")
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = {}) {
                Image(
                    painterResource(R.drawable.container_profile),
                    contentDescription = "User profile",
                    modifier = Modifier.size(40.dp)
                )
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(painterResource(R.drawable.ic_bell), "Thông báo")
            }
            IconButton(onClick = {}) {
                Icon(painterResource(R.drawable.ic_chat_bubble), "Tin nhắn")
            }
        }
    )
}