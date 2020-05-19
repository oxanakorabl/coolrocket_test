package com.coolrocket.charttest

import android.app.Application
import timber.log.Timber
import javax.net.ssl.SSLContext

class CoolApp : Application() {

    companion object {
        lateinit var INSTANCE: CoolApp
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        Timber.plant(Timber.DebugTree())
    }

}