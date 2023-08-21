package com.valentinerutto.tourists.repository

import androidx.lifecycle.LiveData
import com.valentinerutto.tourists.data.local.TouristEntity
import com.valentinerutto.tourists.data.local.dao.TouristDao
import com.valentinerutto.tourists.data.remote.ApiService
import com.valentinerutto.tourists.util.ErrorMessages.GENERAL_API_ERROR_MESSAGE
import com.valentinerutto.tourists.util.NetworkResult
import timber.log.Timber
import java.net.UnknownHostException

class TouristsRepositoryImpl(
    private val apiService: ApiService,
    private val touristDao: TouristDao
) {

    suspend fun getTouristList(): NetworkResult<List<TouristEntity>> = try {
        val response = apiService.getTouristList(2)
        when {
            response.isSuccessful -> {

                val touristsData = response.body()!!.data.map {
                    TouristEntity(
                        id = it.id,
                        name = it.touristName,
                        email = it.touristEmail,
                        location = it.touristLocation
                    )
                }
                saveAllTourists(touristsData)
                NetworkResult.Success(touristsData)

            }

            else -> NetworkResult.APIError(GENERAL_API_ERROR_MESSAGE)
        }

    } catch (e: UnknownHostException) {
        NetworkResult.NoInternetError
    } catch (e: Exception) {
        NetworkResult.ServerError
    }

    private suspend fun saveAllTourists(tourists: List<TouristEntity>) {
        val response = touristDao.saveAllTourists(tourists)
        return when {
            response.isEmpty() -> {
                saveAllTourists(tourists)
            }

            else -> {
                Timber.e("All tourists saved")
            }
        }
    }

    fun getSavedTourists(): LiveData<List<TouristEntity>> = touristDao.getTouristsList()
}