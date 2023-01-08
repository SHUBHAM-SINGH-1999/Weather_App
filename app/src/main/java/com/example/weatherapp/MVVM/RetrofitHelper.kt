package com.example.weatherapp.MVVM

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val base_url="https://api.weatherapi.com/v1/"

    fun getweatherinstance():Retrofit{
        return Retrofit.Builder().baseUrl(base_url).addConverterFactory(GsonConverterFactory.create()).build()
    }
}