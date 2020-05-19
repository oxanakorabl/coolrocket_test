package com.coolrocket.charttest.dagger

object ComponentHolder {

    val appComponent: AppComponent = DaggerAppComponent.builder()
        .appModule(AppModule())
        .networkModule(NetworkModule())
        .build()

}
