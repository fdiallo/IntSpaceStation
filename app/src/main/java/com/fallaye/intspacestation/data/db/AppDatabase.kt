/*
package com.fallaye.intspacestation.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.fallaye.intspacestation.data.db.entities.Response


@Database(
    entities = [Response::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase(){

    abstract fun getISSPosition() : ISSPositionDao



    private fun buildBatabase(context : Context){
        Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "ISSDatabase.db"
        ).build()
    }

}*/
