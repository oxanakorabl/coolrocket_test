package com.coolrocket.charttest.dagger

import android.content.Context
import com.coolrocket.charttest.Repository
import com.coolrocket.charttest.api.Api
import com.coolrocket.charttest.ui.ChartPm
import com.coolrocket.charttest.ui.DataPm
import com.coolrocket.charttest.ui.MainActivity
import com.coolrocket.charttest.Router
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NetworkModule::class])
interface AppComponent {

    fun getRouter(): Router

    fun getRepository(): Repository
}
