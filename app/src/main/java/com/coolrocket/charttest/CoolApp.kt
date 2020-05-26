package com.coolrocket.charttest

import android.app.Application
import com.coolrocket.charttest.ui.MainActivity
import timber.log.Timber
import javax.net.ssl.SSLContext

class CoolApp : Application() {

    companion object {
        lateinit var INSTANCE: CoolApp
        lateinit var ACTIVITY_INSTANCE: MainActivity
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this

        Timber.plant(Timber.DebugTree())
    }

}