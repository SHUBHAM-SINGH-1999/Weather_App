package com.example.weatherapp.Fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import com.example.weatherapp.Activity.FullForecasrReport
import com.example.weatherapp.Adapter.HomeAdapter
import com.example.weatherapp.Adapter.clicked
import com.example.weatherapp.MVVM.*
import com.example.weatherapp.RoomDatabase.RoomEntity
import com.example.weatherapp.RoomDatabase.Roomdatabase
import com.example.weatherapp.databinding.FragmentHomeFragementBinding
import com.example.weatherapp.weatherdata.WeatherData
import com.google.gson.Gson


class HomeFragement : Fragment(), clicked {

    private var _binding: FragmentHomeFragementBinding?=null
    private val binding get() = _binding!!
    lateinit var mainViewModel:MainViewModel
    lateinit var homelist:List<RoomEntity>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeFragementBinding.inflate(inflater,container,false)
        homelist = mutableListOf()

        binding.homeRecycler.adapter = HomeAdapter(homelist,this)
        binding.homeRecycler.layoutManager  = LinearLayoutManager(context,HORIZONTAL,false)

        var d = RetrofitHelper.getweatherinstance().create(WeatherInterface::class.java)
        var e = Roomdatabase.getdata(context?.applicationContext!!).getinterface()
        var r = WeatherRepository(d,e)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(r)).get(MainViewModel::class.java)

        mainViewModel.livefromRoom().observe(viewLifecycleOwner){
            homelist = it
            binding.homeRecycler.adapter = HomeAdapter(homelist,this)
        }

        return binding.root
    }

    override fun clickonreport(it: WeatherData) {
        var intent = Intent(context,FullForecasrReport()::class.java)
        intent.putExtra("shu",it)
        startActivity(intent)
    }

}