package com.valentinerutto.tourists.data.remote.model.touristlist


import com.google.gson.annotations.SerializedName

data class Data(
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