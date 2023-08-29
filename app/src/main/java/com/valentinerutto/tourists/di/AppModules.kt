package com.valentinerutto.tourists.di

import com.valentinerutto.tourists.TouristsApplication
import com.valentinerutto.tourists.data.local.AppDatabase
import com.valentinerutto.tourists.data.remote.ApiService
import com.valentinerutto.tourists.repository.TouristsRepository
import com.valentinerutto.tourists.ui.TouristsViewmodel
import com.valentinerutto.tourists.util.Constants
import com.valentinerutto.tourists.util.RetrofitClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.Scope
import org.koin.dsl.module
import retrofit2.Retrofit


val appModules = module {

    single { TouristsApplication.INSTANCE }

    single<ApiService> {
        (get() as Retrofit).create(
            ApiService::class.java
        )
    }

    single { RetrofitClient.createOkClient() }

    single {
        RetrofitClient.createRetrofit(Constants.BASE_URL, get())
    }

    single { AppDatabase.getDatabase(context = androidContext()) }

    single { TouristsRepository(get(), touristDao = database().touristDao(), newsFeedDao = database().newsFeedDao()) }

    viewModel { TouristsViewmodel(get()) }
}

fun Scope.database() = get<AppDatabase>()
