package com.example.weatherapp.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.weatherapp.RoomDatabase.RoomDao
import com.example.weatherapp.RoomDatabase.RoomEntity
import com.example.weatherapp.weatherdata.WeatherData
import retrofit2.Response

class WeatherRepository(val weatherDao: WeatherInterface,val room:RoomDao) {

    val live = MutableLiveData<WeatherData>()

    val weatherReport: LiveData<WeatherData>
        get() = live
// only for take a value form api
    suspend fun getweatherdata(key: String, q: String, days: String, aqi: String) {
        var s = weatherDao.getdata(key, q, days, aqi)
        live.postValue(s.body())
    }
    // taking value but also update in roomdatabase

    suspend fun updateroomdatabase(key: String, q: String, days: String, aqi: String) {
        var s = weatherDao.getdata(key, q, days, aqi)
        var name = s.body()?.location?.name
        room.insertdata(RoomEntity(name!!, s.body()!!))
    }


    // form room

    fun livefromRoom():LiveData<List<RoomEntity>>{
        return room.getdata()
    }

   suspend fun insertDataToRoom( r:RoomEntity){
        room.insertdata(r)
    }
}