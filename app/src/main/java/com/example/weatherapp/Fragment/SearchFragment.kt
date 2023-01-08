package com.example.weatherapp.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.room.RoomDatabase
import com.example.weatherapp.Adapter.SearchAdapter
import com.example.weatherapp.Adapter.clickonCard
import com.example.weatherapp.MVVM.*
import com.example.weatherapp.RoomDatabase.RoomEntity
import com.example.weatherapp.RoomDatabase.Roomdatabase
import com.example.weatherapp.databinding.FragmentSearchBinding
import com.example.weatherapp.weatherdata.Location
import com.example.weatherapp.weatherdata.WeatherData
import kotlinx.coroutines.*

class SearchFragment : Fragment(), clickonCard {

    private var _binding:FragmentSearchBinding?=null
    private val binding get() = _binding!!
    lateinit var SearchList:ArrayList<WeatherData>
    lateinit var mainViewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater,container,false)
        SearchList = ArrayList()

        binding.SearchRecycler.adapter = SearchAdapter(SearchList,this)
        binding.SearchRecycler.layoutManager = GridLayoutManager(context,2)
        var d = RetrofitHelper.getweatherinstance().create(WeatherInterface::class.java)
        var e = Roomdatabase.getdata(context?.applicationContext!!).getinterface()
        var r = WeatherRepository(d,e)
        mainViewModel = ViewModelProvider(this, MainViewModelFactory(r)).get(MainViewModel::class.java)
        loadata()
        searchdata()

        return binding.root
    }

    private fun loadata() {
        mainViewModel.live.observe(viewLifecycleOwner){
            SearchList.add(WeatherData(it.current,it.forecast,it.location))
            binding.SearchRecycler.adapter?.notifyDataSetChanged()
        }
    }

    private fun searchdata() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                GlobalScope.launch {
                mainViewModel.getWeatherData("aa4e97f2fa674589bac172341222712",p0!!,"10","yes")
                }

                Log.d("shu",SearchList.toString())
                Toast.makeText(context,p0!!+" "+"Searched",Toast.LENGTH_SHORT).show()
                return true
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                return true
            }

        })
    }




    override fun clicked(list: WeatherData) {
        val name = list.location.name
        GlobalScope.launch {
            mainViewModel.insertDataToRoom(RoomEntity(name,list))
        }
        Toast.makeText(context,"Entered",Toast.LENGTH_SHORT).show()
    }

}