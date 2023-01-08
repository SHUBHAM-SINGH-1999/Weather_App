package com.example.weatherapp.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.weatherdata.Hour

class TodayAdapter(var list:List<Hour>):RecyclerView.Adapter<TodayAdapter.viewholder>() {
    class viewholder(itemView: View) :ViewHolder(itemView){
        val image = itemView.findViewById<ImageView>(R.id.image)
        val temp = itemView.findViewById<TextView>(R.id.temp)
        val text = itemView.findViewById<TextView>(R.id.text1)
        val data_time = itemView.findViewById<TextView>(R.id.date_time)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var inf = LayoutInflater.from(parent.context).inflate(R.layout.todays_item,parent,false)
        return viewholder(inf)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.temp.text = list[position].temp_c.toString()
        holder.text.text = list[position].condition.text
        holder.data_time.text = list[position].time
        var link = "https:"+list[position].condition.icon
        Glide.with(holder.itemView.context).load(link).into(holder.image)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}