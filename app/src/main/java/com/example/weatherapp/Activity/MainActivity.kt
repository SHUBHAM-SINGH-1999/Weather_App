package com.example.weatherapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.weatherapp.*
import com.example.weatherapp.Fragment.HomeFragement
import com.example.weatherapp.Fragment.SearchFragment
import com.example.weatherapp.MVVM.*
import com.example.weatherapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.container,HomeFragement()).commit()


        bottomnavigation()
    }

    private fun bottomnavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener{
        when(it.itemId){
            (R.id.search) -> {supportFragmentManager.beginTransaction().replace(R.id.container,SearchFragment()).commit()
            true}
            (R.id.home) -> {supportFragmentManager.beginTransaction().replace(R.id.container,HomeFragement()).commit()
                true}
        else->true
        }
        }
    }
}


//       var key=  "aa4e97f2fa674589bac172341222712"
//       var  q = "Agra"
//       var days=10
//       var aqi = "yes"
//       var alerts = "no"