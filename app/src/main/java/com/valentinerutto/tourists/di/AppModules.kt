package com.valentinerutto.tourists.di

import androidx.room.Room
import com.google.gson.GsonBuilder
import com.valentinerutto.tourists.data.local.AppDatabase
import com.valentinerutto.tourists.data.remote.ApiService
import com.valentinerutto.tourists.repository.TouristsRepositoryImpl
import com.valentinerutto.tourists.ui.TouristsViewmodel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.BuildConfig
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit

private const val BASE_URL =
    "http://restapi.adequateshop.com/api/"

val networkingModule = module {
    single<ApiService> { get<Retrofit>().create() }
    single {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = when (BuildConfig.BUILD_TYPE) {
            "release" -> HttpLoggingInterceptor.Level.NONE
            else -> HttpLoggingInterceptor.Level.BODY
        }
        OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    single {
        val gson = GsonBuilder()
            .serializeNulls()
            .create()

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(get())
            .build()
    }
}
val databaseModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java,
            "tourists_database"
        ).build()
    }

single { get<AppDatabase>().touristDao() }
}

val repositoryModule = module {
    single{TouristsRepositoryImpl(get(),get())}
}
val viewModelModule = module {
    viewModel { TouristsViewmodel(get()) }
}