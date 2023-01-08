package com.example.weatherapp.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.MVVM.*
import com.example.weatherapp.R
import com.example.weatherapp.RoomDatabase.RoomEntity
import com.example.weatherapp.RoomDatabase.Roomdatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class Splash_Activity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        var d = RetrofitHelper.getweatherinstance().create(WeatherInterface::class.java)
        var e = Roomdatabase.getdata(applicationContext).getinterface()
        var r = WeatherRepository(d,e)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(r)).get(MainViewModel::class.java)


        Handler().postDelayed({
            mainViewModel.livefromRoom().observe(this){
                it.forEach {
                  var name = it.id
                  GlobalScope.launch {
                      mainViewModel.updateroomdatabase("aa4e97f2fa674589bac172341222712",name,"10","yes")
                  }
                }
            }
            startActivity(Intent(this,MainActivity()::class.java))
            finish()
        },2000)
    }
}