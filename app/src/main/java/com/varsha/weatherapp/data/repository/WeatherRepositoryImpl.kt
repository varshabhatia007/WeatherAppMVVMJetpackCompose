package com.varsha.weatherapp.data.repository

import android.os.Build
import androidx.annotation.RequiresApi
import com.varsha.weatherapp.data.mapper.toWeatherInfo
import com.varsha.weatherapp.data.remote.WeatherApi
import com.varsha.weatherapp.domain.repository.WeatherRepository
import com.varsha.weatherapp.domain.util.Resource
import com.varsha.weatherapp.domain.weather.WeatherInfo
import javax.inject.Inject

class WeatherRepositoryImpl @Inject constructor(
    private val weatherApi: WeatherApi
) : WeatherRepository {

    @RequiresApi(Build.VERSION_CODES.O)
    override suspend fun getWeatherData(
        latitude: Double,
        longitude: Double
    ): Resource<WeatherInfo> {
        return try {
            Resource.Success(
                data = weatherApi.getWeatherData(
                    latitude = latitude,
                    longitude = longitude
                ).toWeatherInfo()
            )
        } catch (e: Exception) {
            e.printStackTrace()
            Resource.Error(e.message ?: "An unknown error occurred.")
        }
    }
}