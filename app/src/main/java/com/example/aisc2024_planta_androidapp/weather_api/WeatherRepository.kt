package com.example.aisc2024_planta_androidapp.weather_api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WeatherRepository {
    private val api: WeatherApiService

    init {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.weatherapi.com/v1/") // Correct base URL
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient.build())
            .build()

        api = retrofit.create(WeatherApiService::class.java)
    }

    suspend fun getWeather(city: String, apiKey: String): Response<WeatherApiResponse> {
        // Pass city and apiKey to the API interface method
        return api.getCurrentWeather(apiKey, city)
    }
}