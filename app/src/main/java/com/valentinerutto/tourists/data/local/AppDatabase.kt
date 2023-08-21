package com.valentinerutto.tourists.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.AutoMigrationSpec
import com.valentinerutto.tourists.data.local.dao.TouristDao

@Database(exportSchema = true, version = 1, entities = [TouristEntity::class])
abstract class AppDatabase: RoomDatabase() {
    abstract fun touristDao(): TouristDao
    class MyAutomigration: AutoMigrationSpec{}
}