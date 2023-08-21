package com.valentinerutto.tourists.data.remote.model.newfeedlist


import com.google.gson.annotations.SerializedName

data class NewsFeedListResponse(
    @SerializedName("data")
    val `data`: List<Data>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("totalrecord")
    val totalrecord: Int
)