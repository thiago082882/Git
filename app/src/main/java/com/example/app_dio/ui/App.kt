package com.example.app_dio.ui

import android.app.Application
import com.example.app_dio.data.DataModule
import com.example.app_dio.domain.DomainModule
import com.example.app_dio.presentation.PresentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
        }

        DataModule.load()
        DomainModule.load()
        PresentationModule.load()
    }
}