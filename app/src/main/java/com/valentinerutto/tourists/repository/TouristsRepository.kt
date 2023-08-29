package com.valentinerutto.tourists.repository

import androidx.lifecycle.LiveData
import com.valentinerutto.tourists.data.TouristList
import com.valentinerutto.tourists.data.local.NewsFeedEntity
import com.valentinerutto.tourists.data.local.TouristEntity
import com.valentinerutto.tourists.data.local.dao.NewsFeedDao
import com.valentinerutto.tourists.data.local.dao.TouristDao
import com.valentinerutto.tourists.data.remote.ApiService
import com.valentinerutto.tourists.util.ErrorMessages.GENERAL_API_ERROR_MESSAGE
import com.valentinerutto.tourists.util.NetworkResult
import kotlinx.coroutines.delay
import java.net.UnknownHostException

class TouristsRepository(
    private val apiService: ApiService,
    private val touristDao: TouristDao,
    private val newsFeedDao: NewsFeedDao
) {
    suspend fun getTouristList(): NetworkResult<List<TouristEntity>> = try {

        val response = apiService.getTouristList(4)

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
                touristDao.insert(touristsData)
                NetworkResult.Success(touristsData)

            }

            else -> NetworkResult.APIError(GENERAL_API_ERROR_MESSAGE)
        }

    } catch (e: UnknownHostException) {
        NetworkResult.NoInternetError
    } catch (e: Exception) {
        NetworkResult.ServerError
    }

    suspend fun getNewsFeed(page: Int): NetworkResult<List<NewsFeedEntity>> = try {

        val response = apiService.getNewsFeed(page)

        when {
            response.isSuccessful -> {

                val newssData = response.body()!!.data.map {
                    NewsFeedEntity(
                        id = it.id,
                        commentCount = it.commentCount,
                        title = it.title,
                        description = it.description,
                        userName = it.user.name,
                        userPPic = it.user.profilepicture,
                    )
                }

                newsFeedDao.insert(newssData)
                NetworkResult.Success(newssData)
            }

            else -> NetworkResult.APIError(GENERAL_API_ERROR_MESSAGE)

        }


    } catch (e: UnknownHostException) {
        NetworkResult.NoInternetError
    } catch (e: Exception) {
        NetworkResult.ServerError
    }

    fun getSavedTourists(): LiveData<List<TouristEntity>> = touristDao.getTouristsList()
    fun getSavedNewsFeed(): LiveData<List<NewsFeedEntity>> = newsFeedDao.getnewsFeedList()
    suspend fun getItems(page: Int, pageSize: Int): Result<List<TouristList>> {
        val response = apiService.getTouristList(page)
        var totalpage = response.body()!!.totalPages
        var touristlist = response.body()!!.data.map {
            TouristList(id = it.id, name = it.touristName)
        }

        delay(2000L)
        val startingIndex = page * pageSize
        return if (startingIndex + pageSize <= totalpage) {
            Result.success(
                touristlist.slice(startingIndex until startingIndex + pageSize)
            )
        } else Result.success(emptyList())
    }


}