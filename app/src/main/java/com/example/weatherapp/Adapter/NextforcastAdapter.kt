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
import com.example.weatherapp.weatherdata.Forecastday
import de.hdodenhof.circleimageview.CircleImageView

class NextforcastAdapter(var list:List<Forecastday>):RecyclerView.Adapter<NextforcastAdapter.viewholder>() {
    class viewholder(itemView: View):ViewHolder(itemView){
        val date = itemView.findViewById<TextView>(R.id.forcast_Date)
        val temp = itemView.findViewById<TextView>(R.id.forcast_temp)
        val text = itemView.findViewById<TextView>(R.id.forcast_text)
        val image = itemView.findViewById<CircleImageView>(R.id.forcast_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewholder {
        var inf = LayoutInflater.from(parent.context).inflate(R.layout.forecast_items,parent,false)
        return viewholder(inf)
    }

    override fun onBindViewHolder(holder: viewholder, position: Int) {
        holder.date.text = list[position].date
        holder.text.text = list[position].day.condition.text
        holder.temp.text = list[position].day.avgtemp_c.toString()
        var i = "https:"+list[position].day.condition.icon
        Glide.with(holder.itemView.context).load(i).into(holder.image)
    }

    override fun getItemCount(): Int {
       return list.size
    }
}