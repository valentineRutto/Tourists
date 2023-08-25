package com.valentinerutto.tourists.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.valentinerutto.tourists.TouristsApplication
import com.valentinerutto.tourists.data.local.AppDatabase
import com.valentinerutto.tourists.data.local.dao.TouristDao
import com.valentinerutto.tourists.data.remote.ApiService
import com.valentinerutto.tourists.repository.TouristsRepository
import com.valentinerutto.tourists.ui.TouristsViewmodel
import com.valentinerutto.tourists.util.Constants
import com.valentinerutto.tourists.util.RetrofitClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
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

    single<RoomDatabase> {
        Room.databaseBuilder(androidContext(), AppDatabase::class.java, Constants.DB_NAME)
            .fallbackToDestructiveMigration().build()
    }
    single<TouristDao> { val database =get<AppDatabase>()
        database.touristDao() }
    single { TouristsRepository(get<ApiService>(), get<TouristDao>()) }

viewModel { TouristsViewmodel(get<TouristsRepository>()) }
}