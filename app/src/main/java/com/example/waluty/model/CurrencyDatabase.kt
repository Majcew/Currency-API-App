package com.example.waluty.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CurrencyResponse::class],
          version = 1,
        exportSchema = false
)
abstract class CurrencyDatabase:RoomDatabase()
{
    abstract fun CurrencyDao():CurrencyDAO

    companion object {
        @Volatile private var instance:CurrencyDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: BuildDatabase(context).also {instance = it}
        }
        private fun BuildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
            CurrencyDatabase::class.java,
            "currencybase.db")
            .build()
    }
}