package com.example.weatherapp.weatherdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val country: String,
    val localtime: String,
    val name: String,
    val region: String,
    val tz_id: String
):Parcelable