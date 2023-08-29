package com.valentinerutto.tourists.data.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.valentinerutto.tourists.data.local.NewsFeedEntity

@Dao
interface NewsFeedDao : BaseDao<NewsFeedEntity> {
    @Query("SELECT * FROM newsList")
    fun getnewsFeedList(): LiveData<List<NewsFeedEntity>>
}