package com.example.aisc2024_planta_androidapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.aisc2024_planta_androidapp.ui.theme.AISC2024_Planta_AndroidAppTheme
import com.example.aisc2024_planta_androidapp.login.LoginScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent{
            // Correct usage
            AISC2024_Planta_AndroidAppTheme {
                LoginScreen()
            }
        }
    }


}

