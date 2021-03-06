package com.binar.myphoto

import android.app.Application
import com.binar.myphoto.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                listOf(
                    networkModul,
                    photosDataSourceModule,
                    repositoryModule,
                    viewModelModule,
                    localModule,
                    favoriteDataSource
                )
            )
        }
    }
}