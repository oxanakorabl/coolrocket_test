package com.coolrocket.charttest.api

import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface Api {

    @POST("mobws/json/pointsList")
    fun getPoints(@Header("version") version: String = "1.1", @Body body: PointBody): Observable<Any>

}