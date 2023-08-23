package com.valentinerutto.tourists.repository

import androidx.lifecycle.LiveData
import com.valentinerutto.tourists.data.local.TouristEntity
import com.valentinerutto.tourists.util.NetworkResult

interface TouristsRepository {
    suspend fun getTouristList(): NetworkResult<List<TouristEntity>>
    fun getSavedTourists(): LiveData<
            List<TouristEntity>>

}