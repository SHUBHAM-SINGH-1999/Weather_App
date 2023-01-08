package com.example.weatherapp.RoomDatabase

import androidx.room.TypeConverter
import com.example.weatherapp.weatherdata.Current
import com.example.weatherapp.weatherdata.Location
import com.example.weatherapp.weatherdata.WeatherData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class Conv {
    @TypeConverter
    fun fromCountryLangList(countryLang: WeatherData?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type: Type = object : TypeToken< WeatherData>() {}.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toCountryLangList(countryLangString: String?): WeatherData? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type =
            object : TypeToken<WeatherData>() {}.type
        return gson.fromJson<WeatherData>(countryLangString, type)
    }
}