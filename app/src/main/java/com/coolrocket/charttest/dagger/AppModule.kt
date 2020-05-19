package com.coolrocket.charttest.dagger

import android.content.Context
import com.coolrocket.charttest.CoolApp
import com.coolrocket.charttest.api.Api
import com.coolrocket.charttest.ui.DataPm
import com.coolrocket.charttest.ui.MainActivity
import com.coolrocket.charttest.ui.Router
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
    fun provideActivity(): MainActivity = MainActivity.INSTANCE

    @Provides
    @Singleton
    fun provideDataPm(api: Api, router: Router): DataPm = DataPm(api, router)

    @Provides
    @Singleton
    fun provideRouter(): Router = Router()

}
