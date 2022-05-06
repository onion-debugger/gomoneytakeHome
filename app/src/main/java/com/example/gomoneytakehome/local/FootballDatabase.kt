package com.example.gomoneytakehome.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gomoneytakehome.local.dao.CompetitionDao

@Database(entities = [], version = 1, exportSchema = false)
abstract class FootballDatabase : RoomDatabase(){

    abstract val competitionDao: CompetitionDao

    companion object {
        @Volatile
        private var INSTANCE: FootballDatabase? = null

        fun getInstance(context: Context) : FootballDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        FootballDatabase::class.java,
                        "football_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}