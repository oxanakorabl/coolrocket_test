package com.coolrocket.charttest.dagger

import android.content.Context
import com.coolrocket.charttest.api.Api
import com.coolrocket.charttest.ui.DataPm
import com.coolrocket.charttest.ui.MainActivity
import com.coolrocket.charttest.ui.Router
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun getContext(): Context

    fun getActivity(): MainActivity

    fun getRouter(): Router

    fun getApi(): Api

    fun geDataPm(): DataPm
}
