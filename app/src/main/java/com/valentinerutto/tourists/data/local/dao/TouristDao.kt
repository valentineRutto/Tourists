package com.valentinerutto.tourists.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.valentinerutto.tourists.data.local.TouristEntity

@Dao
interface TouristDao: BaseDao<TouristEntity> {
    @Query("SELECT * FROM touristList")
    suspend fun getTouristsList():List<TouristEntity>

}