package com.valentinerutto.tourists.data.remote.model.newfeedlist


import com.google.gson.annotations.SerializedName

data class MultiMedia(
    @SerializedName("createat")
    val createat: String,
    @SerializedName("description")
    val description: Any,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("title")
    val title: Any,
    @SerializedName("url")
    val url: String
)