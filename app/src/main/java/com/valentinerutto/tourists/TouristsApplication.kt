package com.valentinerutto.tourists

import android.app.Application
import com.valentinerutto.tourists.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class TouristsApplication: Application() {
    companion object {
        lateinit var INSTANCE: TouristsApplication
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        startKoin {
            androidLogger(level = Level.DEBUG)
            androidContext(this@TouristsApplication)
            modules(appModules)
        }
    }
}