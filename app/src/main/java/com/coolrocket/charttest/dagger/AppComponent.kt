package com.coolrocket.charttest.dagger

import android.content.Context
import com.coolrocket.charttest.api.Api
import com.coolrocket.charttest.ui.DataPm
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {
    fun getContext(): Context
    fun getApi(): Api

    fun geDataPm(): DataPm
}
