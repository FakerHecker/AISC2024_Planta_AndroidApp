package com.example.aisc2024_planta_androidapp.scan_result.diagnose

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScanResultDiagnoseScreen(
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = { TopAppBar(
            title = { Text("Kết quả") },
            navigationIcon = { IconButton(onClick = onNavigateUp) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            } },
        ) },
        containerColor = colorScheme.surface,
        modifier = modifier
    ) { innerPadding ->
        ResultDiagnoseCard(
            Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp)
                .verticalScroll(rememberScrollState())
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun ScanResultDiagnoseScreenPreview() {
    AISC2024_Planta_AndroidAppTheme {
        ScanResultDiagnoseScreen({})
    }
}