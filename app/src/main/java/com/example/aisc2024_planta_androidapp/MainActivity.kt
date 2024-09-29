package com.example.aisc2024_planta_androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme
import com.example.aisc2024_planta_androidapp.scan.ScanScreen
import com.example.aisc2024_planta_androidapp.scan_result.diagnose.ScanResultDiagnoseScreen
import com.example.aisc2024_planta_androidapp.scan_result.info.ScanResultInfoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            // Correct usage
            AISC2024_Planta_AndroidAppTheme {
                AppMainScreen()
            }
        }
    }
}

enum class AppRoute {
    Scan, ScanResult, ScanDiagnose
}

@Composable
fun AppMainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.Scan.name,
        modifier = modifier
    ) {
        composable(AppRoute.Scan.name) {
            ScanScreen(
                onScanClicked = { navController.navigate(AppRoute.ScanResult.name) },
                onDiagnoseClicked = { navController.navigate(AppRoute.ScanDiagnose.name) }
            )
        }
        composable(AppRoute.ScanResult.name) {
            ScanResultInfoScreen(
                onNavigateUp = { navController.navigateUp() }
            )
        }
        composable(AppRoute.ScanDiagnose.name) {
            ScanResultDiagnoseScreen(
                onNavigateUp = { navController.navigateUp() }
            )
        }
    }
}