package com.example.weatherapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.HORIZONTAL
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.RoomDatabase.RoomEntity
import com.example.weatherapp.weatherdata.WeatherData

class HomeAdapter(val list:List<RoomEntity>,val listner:clicked):RecyclerView.Adapter<HomeAdapter.viewholder>() {
    class viewholder(itemView: View):ViewHolder(itemView){
         var cityname = itemView.findViewById<TextView>(R.id.cityname)
         var citydate = itemView.findViewById<TextView>(R.id.citydate)
        var mainimage = itemView.findViewById<ImageView>(R.id.mainImage)
        var temp = itemView.findViewById<TextView>(R.id.layout_temp)
        var humidity = itemView.findViewById<TextView>(R.id.layout_humidity)
        var wind = itemView.findViewById<TextView>(R.id.layout_wind)
        var homeRecyclerView = itemView.findViewById<RecyclerView>(R.id.homeRecyclerView)
        var fullForcastReport = itemView.findViewById<TextView>(R.id.full_report)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var n = LayoutInflater.from(parent.context).inflate(R.layout.homefragment_items,parent,false)
        var v = viewholder(n)
        v.fullForcastReport.setOnClickListener {
            listner.clickonreport(list[v.adapterPosition].data)
        }
        return v
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.cityname.text = list[position].id
        holder.citydate.text = list[position].data.location.localtime
        val t = list[position].data.current.temp_c.toString()+"°"
        holder.temp.text =t
        val w = list[position].data.current.wind_kph.toString()+"km/h"
        holder.wind.text = w
        val h = list[position].data.current.humidity.toString()+"%"
        holder.humidity.text = h
        var link = "https:"+list[position].data.current.condition.icon
        Glide.with(holder.itemView.context).load(link).into(holder.mainimage)

        holder.homeRecyclerView.adapter = TodayAdapter(list[position].data.forecast.forecastday[0].hour)
        holder.homeRecyclerView.layoutManager = GridLayoutManager(holder.itemView.context,2)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

interface clicked{
    fun clickonreport(it:WeatherData)
}