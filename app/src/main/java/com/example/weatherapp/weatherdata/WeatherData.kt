package com.example.weatherapp.weatherdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Parcelize
data class WeatherData(
    val current: Current,
    val forecast: Forecast,
    val location: Location
):Parcelable

