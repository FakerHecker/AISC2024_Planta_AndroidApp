package com.example.aisc2024_planta_androidapp.screen.main.home.component.weather

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aisc2024_planta_androidapp.weather_api.WeatherApiResponse
import com.example.aisc2024_planta_androidapp.weather_api.WeatherApiService
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class WeatherViewModel : ViewModel() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.weatherapi.com/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(WeatherApiService::class.java)

    var weatherResponse by mutableStateOf<WeatherApiResponse?>(null)
        private set

    var isLoading by mutableStateOf(false)
        private set

    var error by mutableStateOf<String?>(null)
        private set

    fun getWeather(city: String, apiKey: String) {
        isLoading = true
        error = null
        viewModelScope.launch {
            try {
                // Use the forecast.json endpoint to get hourly and daily forecast
                val response = service.getForecast(apiKey, city, 1) // 1 day of forecast
                if (response.isSuccessful) {
                    weatherResponse = response.body()
                } else {
                    error = "Error: ${response.code()}"
                }
            } catch (e: Exception) {
                error = "Exception: ${e.message}"
                Log.e("WeatherViewModel", "Error fetching weather", e)
            } finally {
                isLoading = false
            }
        }
    }

    fun getCurrentHourChanceOfRain(): Int? {
        val currentEpoch = System.currentTimeMillis() / 1000
        return weatherResponse?.forecast?.forecastday?.get(0)?.hour?.find { hour ->
            hour.time_epoch >= currentEpoch
        }?.chance_of_rain
    }

    fun getDailyChanceOfRain(): Int? {
        return weatherResponse?.forecast?.forecastday?.get(0)?.day?.daily_chance_of_rain
    }
}