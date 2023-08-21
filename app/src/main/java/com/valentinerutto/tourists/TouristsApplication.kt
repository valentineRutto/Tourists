package com.valentinerutto.tourists

import android.app.Application
import com.valentinerutto.tourists.di.databaseModule
import com.valentinerutto.tourists.di.networkingModule
import com.valentinerutto.tourists.di.repositoryModule
import com.valentinerutto.tourists.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TouristsApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = listOf(networkingModule, databaseModule, repositoryModule, viewModelModule)

        startKoin {
            androidLogger()
            androidContext(this@TouristsApplication)
            modules(modules)
        }
    }
}