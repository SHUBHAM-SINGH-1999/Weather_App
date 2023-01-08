package com.example.weatherapp.MVVM




import com.example.weatherapp.weatherdata.WeatherData
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherInterface {

    @GET("forecast.json")
    suspend fun getdata(@Query("key")key:String,@Query("q")q:String,@Query("days")days:String,@Query("aqi")aqi:String): Response<WeatherData>
}