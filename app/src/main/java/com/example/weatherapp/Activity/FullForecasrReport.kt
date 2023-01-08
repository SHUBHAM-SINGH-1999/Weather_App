package com.example.weatherapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.weatherapp.Adapter.NextforcastAdapter
import com.example.weatherapp.Adapter.TodayAdapter
import com.example.weatherapp.MVVM.*
import com.example.weatherapp.R
import com.example.weatherapp.RoomDatabase.RoomEntity
import com.example.weatherapp.RoomDatabase.Roomdatabase
import com.example.weatherapp.databinding.ActivityFullForecasrReportBinding
import com.example.weatherapp.weatherdata.Forecastday
import com.example.weatherapp.weatherdata.Hour
import com.example.weatherapp.weatherdata.WeatherData

class FullForecasrReport : AppCompatActivity() {
    lateinit var binding:ActivityFullForecasrReportBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_full_forecasr_report)

       var s = intent.getParcelableExtra<WeatherData>("shu")
       binding.date.text = s?.forecast!!.forecastday[0].date

        var list:List<Hour> = s.forecast.forecastday[0].hour

        binding.todayRecycler.adapter = TodayAdapter(list)
        binding.todayRecycler.layoutManager = LinearLayoutManager(this,HORIZONTAL,false)

        var l:List<Forecastday> = s.forecast.forecastday

        binding.SearchRecycler.adapter = NextforcastAdapter(l)
        binding.SearchRecycler.layoutManager = LinearLayoutManager(this)
    }
}