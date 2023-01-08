package com.example.weatherapp.weatherdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hour(
    val cloud: Int,
    val condition: Condition,
    val humidity: Int,
    val is_day: Int,
    val precip_mm: Double,
    val pressure_mb: Double,
    val temp_c: Double,
    val temp_f: Double,
    val time: String,
    val vis_km: Double,
    val wind_kph: Double,
): Parcelable