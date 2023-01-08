package com.example.weatherapp.RoomDatabase


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapp.weatherdata.Current
import com.example.weatherapp.weatherdata.Location
import com.example.weatherapp.weatherdata.WeatherData
import kotlinx.android.parcel.Parcelize
//import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(tableName = "roomlist")
data class RoomEntity(
    @PrimaryKey(autoGenerate = false)
    val id:String,
    val data: WeatherData
)
