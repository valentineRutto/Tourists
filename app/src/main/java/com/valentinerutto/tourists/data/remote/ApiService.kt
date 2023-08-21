package com.valentinerutto.tourists.data.remote

import com.valentinerutto.tourists.data.remote.model.newfeedlist.NewsFeedListResponse
import com.valentinerutto.tourists.data.remote.model.touristlist.TouristsListResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/Tourist")
    suspend fun getTouristList(@Query("page") page:Int): Response<TouristsListResponse>
    @GET("/Feed/GetNewsFeed")
    suspend fun getNewsFeed(): Response<NewsFeedListResponse>
    @GET("/Tourist/{id}")
    suspend fun getTouristDetails(@Path("id") id : Int): Response<TouristsListResponse>
}