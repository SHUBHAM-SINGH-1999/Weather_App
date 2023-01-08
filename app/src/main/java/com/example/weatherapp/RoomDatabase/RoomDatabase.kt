package com.example.weatherapp.RoomDatabase

import android.content.Context
import androidx.room.*

@Database(entities = [RoomEntity::class], version = 1)
@TypeConverters(Conv::class)
abstract class Roomdatabase: RoomDatabase()  {
    abstract fun getinterface():RoomDao

    companion object{
        var INSTANCE:Roomdatabase?=null

        fun getdata(context: Context):Roomdatabase{
            if(INSTANCE==null){
                INSTANCE = Room.databaseBuilder(context.applicationContext,Roomdatabase::class.java,"userdb").build()
            }
            return INSTANCE!!
        }
    }
}