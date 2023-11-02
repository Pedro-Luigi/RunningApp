package com.meu.runningapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        //This enables debug logging with the TIMBER library.
        Timber.plant(Timber.DebugTree())
    }

}