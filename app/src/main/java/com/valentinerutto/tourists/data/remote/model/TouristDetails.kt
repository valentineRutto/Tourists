package com.valentinerutto.tourists.data.remote.model


import com.google.gson.annotations.SerializedName

data class TouristDetails(
    @SerializedName("createdat")
    val createdat: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("tourist_email")
    val touristEmail: String,
    @SerializedName("tourist_location")
    val touristLocation: String,
    @SerializedName("tourist_name")
    val touristName: String
)