package com.example.weatherapp.weatherdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Astro(
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
):Parcelable