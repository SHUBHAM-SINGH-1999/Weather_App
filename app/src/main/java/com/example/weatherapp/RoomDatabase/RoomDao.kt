package com.example.weatherapp.RoomDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.weatherapp.weatherdata.WeatherData

@Dao
interface RoomDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertdata(roomentity:RoomEntity)


    @Query("SELECT * FROM roomlist")
    fun getdata():LiveData<List<RoomEntity>>
}