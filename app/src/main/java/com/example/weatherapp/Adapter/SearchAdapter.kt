package com.example.weatherapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.weatherapp.Dataclass.Searchdata
import com.example.weatherapp.R
import com.example.weatherapp.weatherdata.WeatherData

class SearchAdapter(val list:ArrayList<WeatherData>,val clickonCard: clickonCard):RecyclerView.Adapter<SearchAdapter.viewholder>() {

    class viewholder(itemView: View):ViewHolder(itemView){
        var text = itemView.findViewById<TextView>(R.id.searchtext)
        var image = itemView.findViewById<ImageView>(R.id.searchimage)
        var location = itemView.findViewById<TextView>(R.id.searchlocation)
        var temp = itemView.findViewById<TextView>(R.id.searchtemp)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var inf = LayoutInflater.from(parent.context).inflate(R.layout.search_items,parent,false)
        val tap = viewholder(inf)
        inf.setOnClickListener {
            clickonCard.clicked(list[tap.adapterPosition])
        }
        return tap
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.location.text = list[position].location.name
        holder.text.text = list[position].current.condition.text
        holder.temp.text = list[position].current.temp_c.toString()
        val link = "https:"+list[position].current.condition.icon
        Glide.with(holder.itemView.context).load(link).into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}

interface clickonCard{
    fun clicked(list:WeatherData)
}