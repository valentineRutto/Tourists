package com.valentinerutto.tourists.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.valentinerutto.tourists.data.local.dao.NewsFeedDao
import com.valentinerutto.tourists.data.local.dao.TouristDao
import com.valentinerutto.tourists.util.Constants
import kotlinx.coroutines.CoroutineScope

@Database(exportSchema = false, version = 1, entities = [TouristEntity::class,NewsFeedEntity::class])
abstract class AppDatabase: RoomDatabase() {
    abstract fun touristDao(): TouristDao
    abstract fun newsFeedDao(): NewsFeedDao



companion object {
    @Volatile
    private var INSTANCE: AppDatabase? = null

    fun getDatabase(context: Context): AppDatabase {
        // if the INSTANCE is not null, then return it,
        // if it is, then create the database
        return INSTANCE ?: synchronized(this) {
            val instance =
                Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    Constants.DB_NAME
                )
                    // Wipes and rebuilds instead of migrating if no M¬igration object.
                    .fallbackToDestructiveMigration()
                    .build()
            INSTANCE = instance
            // return instance
            instance
        }
    }
}}
