package com.example.weatherapp.weatherdata

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Condition(
    val code: Int,
    val icon: String,
    val text: String
):Parcelable