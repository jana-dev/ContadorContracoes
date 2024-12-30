/*
package com.janatavares.contadorcontracoes.data.local.entities

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import com.janatavares.contadorcontracoes.data.local.dao.ContractionDao
import com.janatavares.contadorcontracoes.data.model.Contraction

@Database(entities = [Contraction::class], version = 1)
abstract class ContractionDatabase : RoomDatabase(){
    abstract fun contractionDao(): ContractionDao

    companion object{
        @Volatile
        private var INSTANCE: ContractionDatabase? = null

        fun getDatabase(context: Context): ContractionDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    ContractionDatabase::class.java,
                    "contraction_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}*/
