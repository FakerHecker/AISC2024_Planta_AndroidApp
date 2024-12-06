package com.example.aisc2024_planta_androidapp.screen.scan_result.info

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.screen.scan_result.info.component.ResultInfoCard
import com.example.aisc2024_planta_androidapp.ui.composable.ProductCard
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanResultInfoScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { TopAppBar(
            title = { Text("Kết quả") },
            navigationIcon = { IconButton(onClick = onNavigateUp) {
                Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
            }},
        ) },
        containerColor = colorScheme.surface,
        modifier = modifier
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
        ) {
            item(span = { GridItemSpan(maxCurrentLineSpan) }) {
                Column {
                    ResultInfoCard(Modifier.fillMaxWidth())
                    Spacer(Modifier.height(40.dp))
                    Text("Kết quả tương tự", style = typography.titleMedium)
                }
            }
            items(List(4) {0}) {
                ProductCard()
            }
        }
    }
}

@Preview
@Composable
private fun InfoPreview() {
    AISC2024_Planta_AndroidAppTheme {
        ScanResultInfoScreen({})
    }
}