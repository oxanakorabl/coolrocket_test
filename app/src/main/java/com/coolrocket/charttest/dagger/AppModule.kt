package com.coolrocket.charttest.dagger

import android.content.Context
import com.coolrocket.charttest.CoolApp
import com.coolrocket.charttest.Repository
import com.coolrocket.charttest.api.Api
import com.coolrocket.charttest.ui.ChartPm
import com.coolrocket.charttest.ui.DataPm
import com.coolrocket.charttest.ui.MainActivity
import com.coolrocket.charttest.Router
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = CoolApp.INSTANCE

    @Provides
    @Singleton
    fun provideRepository(api: Api): Repository = Repository(api)

    @Provides
    @Singleton
    fun provideRouter(): Router = Router()

}
