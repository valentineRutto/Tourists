package com.valentinerutto.tourists.data.local

import androidx.room.Entity

@Entity
data class NewsFeedEntity (val id:Int,val title:String,val description:String,val multimediaUrl:String,
                           val userName:String,
                           val userPPic:String,val commentCount:Int)