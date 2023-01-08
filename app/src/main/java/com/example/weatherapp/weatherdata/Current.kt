package com.example.weatherapp.weatherdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Current(
    val air_quality: AirQuality,
    val cloud: Int,
    val condition: Condition,
    val humidity: Int,
    val is_day: Int,
    val last_updated: String,
    val precip_mm: Double,
    val pressure_mb: Double,
    val temp_c: Double,
    val temp_f: Double,
    val uv: Double,
    val wind_kph: Double,
    val wind_mph: Double
):Parcelable