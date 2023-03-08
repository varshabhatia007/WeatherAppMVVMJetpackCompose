package com.varsha.weatherapp.presentation

import com.varsha.weatherapp.domain.weather.WeatherInfo

data class WeatherState(
    val isLoading: Boolean = false,
    val weatherInfo: WeatherInfo? = null,
    val error: String? = null
)
