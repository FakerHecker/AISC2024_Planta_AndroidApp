package com.example.aisc2024_planta_androidapp.screen.account.upgrade

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.screen.account.upgrade.component.UpgradePackCard
import com.example.aisc2024_planta_androidapp.screen.account.upgrade.component.UpgradePackType
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpgradePremiumScreen(onBack: () -> Unit) {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        topBar = { TopAppBar(
            title = { Text("Nâng cấp tài khoản") },
            navigationIcon = { IconButton(onClick = onBack) {
                Icon(Icons.AutoMirrored.Filled.ArrowBack, "Back")
            }},
            scrollBehavior = scrollBehavior
        ) },
        containerColor = colorScheme.surface
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .nestedScroll(scrollBehavior.nestedScrollConnection)
        ) {
            item { Spacer(Modifier.height(8.dp)) }
            items(UpgradePackType.entries) {
                UpgradePackCard(it, it == UpgradePackType.Free)
                Spacer(Modifier.height(16.dp))
            }
            item { Spacer(Modifier.height(22.dp)) }
        }
    }
}

@Preview
@Composable
private fun Prev() {
    AISC2024_Planta_AndroidAppTheme {
        UpgradePremiumScreen({})
    }
}