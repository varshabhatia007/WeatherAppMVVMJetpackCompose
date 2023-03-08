package com.varsha.weatherapp.domain.repository

import com.varsha.weatherapp.domain.util.Resource
import com.varsha.weatherapp.domain.weather.WeatherInfo

interface WeatherRepository {
    suspend fun getWeatherData(lat: Double, long: Double): Resource<WeatherInfo>
}