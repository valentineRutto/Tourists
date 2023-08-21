package com.valentinerutto.tourists.data.remote.model.touristlist
import com.google.gson.annotations.SerializedName

data class TouristsListResponse(
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