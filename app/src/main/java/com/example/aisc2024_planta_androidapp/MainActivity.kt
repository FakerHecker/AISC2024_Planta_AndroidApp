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
import com.example.aisc2024_planta_androidapp.screen.login.LoginScreen
import com.example.aisc2024_planta_androidapp.screen.main.MainScreen
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme
import com.example.aisc2024_planta_androidapp.screen.scan.ScanScreen
import com.example.aisc2024_planta_androidapp.screen.scan_result.diagnose.ScanResultDiagnoseScreen
import com.example.aisc2024_planta_androidapp.screen.scan_result.info.ScanResultInfoScreen

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
    Login, Scan, ScanResult, ScanDiagnose,
    HomeScreen, Garden
}

@Composable
fun AppMainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = AppRoute.HomeScreen.name,
        modifier = modifier
    ) {
        composable(AppRoute.Login.name) {
            LoginScreen(
                loginClicked = {navController.navigate(AppRoute.HomeScreen.name)},
            )
        }
        composable(AppRoute.HomeScreen.name) {
            MainScreen(onScan = {
                navController.navigate(AppRoute.Scan.name)
            })
        }
        composable(AppRoute.Scan.name) {
            ScanScreen(
                onScanClicked = { navController.navigate(AppRoute.ScanResult.name) },
                onDiagnoseClicked = { navController.navigate(AppRoute.ScanDiagnose.name) },
                onNavigateUp = { navController.navigateUp() }
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