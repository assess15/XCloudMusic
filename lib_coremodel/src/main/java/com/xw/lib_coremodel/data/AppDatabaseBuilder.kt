package com.xw.lib_coremodel.data

import android.content.Context
import androidx.room.Room
import com.xw.lib_coremodel.utils.DATABASE_NAME

object AppDatabaseBuilder {

    @Volatile
    private var instance: AppDatabase? = null

    fun getInstance(context: Context): AppDatabase {
        return instance ?: synchronized(this) {
            instance ?: buildDatabase(context).also { instance = it }
        }
    }

    private fun buildDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }

}