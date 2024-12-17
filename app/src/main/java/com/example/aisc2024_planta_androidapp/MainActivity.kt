package com.example.aisc2024_planta_androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.aisc2024_planta_androidapp.screen.account.AccountScreen
import com.example.aisc2024_planta_androidapp.screen.auth.login.LoginScreen
import com.example.aisc2024_planta_androidapp.screen.main.MainScreen
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme
import com.example.aisc2024_planta_androidapp.screen.scan.ScanScreen
import com.example.aisc2024_planta_androidapp.screen.scan_result.diagnose.ScanResultDiagnoseScreen
import com.example.aisc2024_planta_androidapp.screen.scan_result.info.ScanResultInfoScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
    HomeScreen, Garden,
    Account
}

@Composable
fun AppMainScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    // to make the transition fade to/from this color, not from white always
    val bgColor = if (isSystemInDarkTheme()) {
        Color.Black
    } else {
        Color.White
    }
    NavHost(
        navController = navController,
        startDestination = AppRoute.Login.name,
        enterTransition = { slideInHorizontally(initialOffsetX = { fullWidth -> fullWidth }) + fadeIn() },
        popEnterTransition = { slideInHorizontally(initialOffsetX = { fullWidth -> -fullWidth }) + fadeIn() },
        exitTransition = { slideOutHorizontally(targetOffsetX = { fullWidth -> -fullWidth }) + fadeOut() },
        popExitTransition = { slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth }) + fadeOut() },
        modifier = modifier.background(color = bgColor)
    ) {
        composable(AppRoute.Login.name) {
            LoginScreen(
                onLogin = {navController.navigate(AppRoute.HomeScreen.name)},
            )
        }
        composable(AppRoute.HomeScreen.name) {
            MainScreen(
                onScan = { navController.navigate(AppRoute.Scan.name) },
                onNavigateToProfile = { navController.navigate(AppRoute.Account.name) }
            )
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
        composable(AppRoute.Account.name) {
            AccountScreen()
        }
    }
}