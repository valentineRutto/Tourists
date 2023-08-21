package com.valentinerutto.tourists.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.valentinerutto.tourists.data.local.TouristEntity

@Dao
interface TouristDao: BaseDao<TouristEntity> {
    @Query("SELECT * FROM touristList")
     fun getTouristsList():LiveData<List<TouristEntity>>
    @Insert()
    suspend fun saveAllTourists(touristsList:List<TouristEntity>):List<TouristEntity>
}