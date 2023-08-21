package com.valentinerutto.tourists.data.remote.model.newfeedlist


import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("name")
    val name: String,
    @SerializedName("profilepicture")
    val profilepicture: String,
    @SerializedName("userid")
    val userid: Int
)