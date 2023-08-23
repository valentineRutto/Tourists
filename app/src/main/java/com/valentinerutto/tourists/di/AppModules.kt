package com.valentinerutto.tourists.di

import androidx.room.Room
import com.valentinerutto.tourists.TouristsApplication
import com.valentinerutto.tourists.data.local.AppDatabase
import com.valentinerutto.tourists.data.remote.ApiService
import com.valentinerutto.tourists.repository.TouristsRepository
import com.valentinerutto.tourists.repository.TouristsRepositoryImpl
import com.valentinerutto.tourists.ui.TouristsViewmodel
import com.valentinerutto.tourists.util.Constants
import com.valentinerutto.tourists.util.RetrofitClient
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit


//val networkingModule = module {
//    single<ApiService> { get<Retrofit>().create() }
//    single {
//        val interceptor = HttpLoggingInterceptor()
//        interceptor.level = when (BuildConfig.BUILD_TYPE) {
//            "release" -> HttpLoggingInterceptor.Level.NONE
//            else -> HttpLoggingInterceptor.Level.BODY
//        }
//        OkHttpClient.Builder()
//            .addInterceptor(interceptor)
//            .connectTimeout(15, TimeUnit.SECONDS)
//            .readTimeout(15, TimeUnit.SECONDS)
//            .build()
//    }
//
//    single {
//        val gson = GsonBuilder()
//            .serializeNulls()
//            .create()
//
//        Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create(gson))
//            .client(get())
//            .build()
//    }
//}
//val databaseModule = module {
//    single {
//        Room.databaseBuilder(
//            androidContext(),
//            AppDatabase::class.java,
//            Constants.DB_NAME
//        ).build()
//    }
//
//single { get<AppDatabase>().touristDao() }
//
//}
//
//val repositoryModule = module {
//    single{TouristsRepositoryImpl(get(),get())}
//}

//val viewModelModule = module {
//    viewModel { TouristsViewmodel(get()) }
//}
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

    single {
        Room.databaseBuilder(
            androidContext(),
            AppDatabase::class.java, Constants.DB_NAME
        ).build()
    }

    single { get<AppDatabase>().touristDao() }
    single<TouristsRepository> { TouristsRepositoryImpl(apiService = get(), touristDao =  get()) }

    viewModel { TouristsViewmodel(touristsRepository = get()) }
}