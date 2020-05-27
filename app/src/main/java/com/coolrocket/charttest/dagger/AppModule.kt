package com.coolrocket.charttest.dagger

import com.coolrocket.charttest.Repository
import com.coolrocket.charttest.Router
import com.coolrocket.charttest.api.Api
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideRepository(api: Api): Repository = Repository(api)

    @Provides
    @Singleton
    fun provideRouter(): Router = Router()

}
