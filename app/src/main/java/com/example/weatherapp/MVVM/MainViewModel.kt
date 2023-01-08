package com.example.weatherapp.MVVM

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.RoomDatabase.RoomEntity
import com.example.weatherapp.weatherdata.WeatherData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainViewModel(val repo: WeatherRepository): ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.updateroomdatabase("aa4e97f2fa674589bac172341222712","delhi","10","yes")
        }
    }

    val live: LiveData<WeatherData>
        get() = repo.weatherReport


    suspend fun getWeatherData(key: String, q: String, days: String, aqi: String){
        repo.getweatherdata(key,q,days,aqi)
    }
// for room
    fun livefromRoom():LiveData<List<RoomEntity>>{
        return repo.livefromRoom()
    }

    suspend fun insertDataToRoom( r:RoomEntity){
        repo.insertDataToRoom(r)
    }

    // update the room database
    suspend fun updateroomdatabase(key: String, q: String, days: String, aqi: String){
        repo.updateroomdatabase(key,q,days,aqi)
    }
}