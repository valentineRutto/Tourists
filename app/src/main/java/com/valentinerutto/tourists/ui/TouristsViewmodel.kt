package com.valentinerutto.tourists.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.valentinerutto.tourists.data.TouristList
import com.valentinerutto.tourists.data.local.NewsFeedEntity
import com.valentinerutto.tourists.data.local.TouristEntity
import com.valentinerutto.tourists.repository.TouristsRepository
import com.valentinerutto.tourists.util.DefaultPaginator
import com.valentinerutto.tourists.util.ErrorMessages.SERVICE_UNAVAILABLE_ERROR_MESSAGE
import com.valentinerutto.tourists.util.NetworkResult
import com.valentinerutto.tourists.util.SingleLiveEVent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.core.KoinApplication.Companion.init

const val PAGE_SIZE = 10

class TouristsViewmodel(private val touristsRepository: TouristsRepository) : ViewModel() {
    private val _tourists = MutableStateFlow<List<TouristEntity>>(emptyList())
    val tourists = _tourists

    private val _news = MutableStateFlow<List<NewsFeedEntity>>(emptyList())
    val news = _news

    private val _errorMessage = SingleLiveEVent<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _noInternet = SingleLiveEVent<Boolean>()
    val noInternet: LiveData<Boolean> get() = _noInternet

    val newsResult: MutableState<List<NewsFeedEntity>> = mutableStateOf(ArrayList())

    // Pagination starts at '1' (-1 = exhausted)
    val page = mutableStateOf(1)

    fun newGetFeed() {
        viewModelScope.launch(Dispatchers.IO) {

            when (val result = touristsRepository.getNewsFeed(4)) {
                is NetworkResult.Success -> {
                    _news.value = result.data
                }
                is NetworkResult.APIError -> _errorMessage.postValue(result.errorMessage)
                is NetworkResult.NoInternetError -> _noInternet.postValue(true)
                is NetworkResult.ServerError -> _errorMessage.postValue(
                    SERVICE_UNAVAILABLE_ERROR_MESSAGE
                )
            }

        }
    }

    fun getSavedTourists()=
        touristsRepository.getSavedTourists()
    fun getSavedNews()=
        touristsRepository.getSavedNewsFeed()


    fun getTourists() = viewModelScope.launch(Dispatchers.IO) {
        when (val result = touristsRepository.getTouristList()) {
            is NetworkResult.Success -> {
                _tourists.value = result.data
            }
            is NetworkResult.APIError -> _errorMessage.postValue(result.errorMessage)
            is NetworkResult.NoInternetError -> _noInternet.postValue(true)
            is NetworkResult.ServerError -> _errorMessage.postValue(
                SERVICE_UNAVAILABLE_ERROR_MESSAGE
            )
        }
    }

    var state by mutableStateOf(ScreenState())
    private val paginator = DefaultPaginator(initialKey = state.page,
        onLoadUpdated = { state = state.copy(isLoading = it) },
        onRequest = { nextPage ->
            touristsRepository.getItems(nextPage, 10)
        },
        getNextKey = { state.page + 1 },
        onError = {
            state = state.copy(error = it?.localizedMessage)
        },
        onSuccess = { items, newKey ->
            state = state.copy(
                items = state.items + items, page = newKey, endReached = items.isEmpty()
            )
        })

    init {
        // loadNextItems()
    }

    fun loadNextItems() {
        viewModelScope.launch {
            paginator.loadNextItems()
        }
    }

}

data class ScreenState(
    val isLoading: Boolean = false,
    val items: List<TouristList> = emptyList(),
    val error: String? = null,
    val endReached: Boolean = false,
    val page: Int = 1
)