package com.valentinerutto.tourists.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "touristList")
data class TouristEntity (@PrimaryKey
                        val  id:Int,
                          val name:String,val email:String,val location:String,

)