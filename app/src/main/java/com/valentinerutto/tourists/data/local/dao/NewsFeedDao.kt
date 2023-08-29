package com.valentinerutto.tourists.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.valentinerutto.tourists.data.local.NewsFeedEntity

@Dao
interface NewsFeedDao : BaseDao<NewsFeedEntity> {
    @Query("SELECT * FROM newsList")
    suspend fun getnewsFeedList(): List<NewsFeedEntity>
}