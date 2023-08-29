package com.valentinerutto.tourists.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsList")

data class NewsFeedEntity(
    @PrimaryKey val id: Int,
    val title: String,
    val description: String,
    val userName: String,
    val userPPic: String,
    val commentCount: Int
)