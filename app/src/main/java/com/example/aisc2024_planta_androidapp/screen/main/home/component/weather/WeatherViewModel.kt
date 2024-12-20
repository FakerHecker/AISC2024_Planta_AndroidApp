package com.example.aisc2024_planta_androidapp.screen.main.home.component.weather

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisc2024_planta_androidapp.weather_api.WeatherApiResponse
import com.example.aisc2024_planta_androidapp.weather_api.WeatherRepository
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val repository = WeatherRepository()
    var weatherResponse by mutableStateOf<WeatherApiResponse?>(null)
        private set
    var isLoading by mutableStateOf(false)
        private set
    var error by mutableStateOf<String?>(null)
        private set

    fun getWeather(city: String, apiKey: String) {
        isLoading = true
        error = null // Reset error on new request
        viewModelScope.launch {
            try {
                weatherResponse = repository.getWeather(city, apiKey)
            } catch (e: Exception) {
                error = e.message
            } finally {
                isLoading = false
            }
        }
    }
}