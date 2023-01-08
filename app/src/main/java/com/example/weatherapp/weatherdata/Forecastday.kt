package com.example.weatherapp.weatherdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Forecastday(
    val astro: Astro,
    val date: String,
    val day: Day,
    val hour: List<Hour>
):Parcelable