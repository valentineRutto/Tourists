package com.valentinerutto.tourists.data.remote.model.newfeedlist


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("commentCount")
    val commentCount: Int,
    @SerializedName("createdat")
    val createdat: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("location")
    val location: String,
    @SerializedName("multiMedia")
    val multiMedia: List<MultiMedia>,
    @SerializedName("title")
    val title: String,
    @SerializedName("user")
    val user: User
)