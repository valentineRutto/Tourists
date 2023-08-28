package com.valentinerutto.tourists.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valentinerutto.tourists.data.local.NewsFeedEntity
import com.valentinerutto.tourists.data.local.TouristEntity
import com.valentinerutto.tourists.repository.TouristsRepository
import com.valentinerutto.tourists.util.NetworkResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class TouristsViewmodel(private val touristsRepository: TouristsRepository):ViewModel() {
    private val _tourists = MutableStateFlow<List<TouristEntity>>(emptyList())
    val tourists = _tourists

    private val _news = MutableStateFlow<List<NewsFeedEntity>>(emptyList())
    val news = _news

    fun getTourists() = viewModelScope.launch(Dispatchers.IO) {
        when (val result = touristsRepository.getTouristList()) {
            is NetworkResult.Success -> {
                _tourists.value = result.data
            }
            is NetworkResult.APIError -> "errorMessage.postValue(result.errorMessage)"
            is NetworkResult.NoInternetError -> "_noInternet.postValue(true)"
            is NetworkResult.ServerError -> ""
        }
    }
}