package com.coolrocket.charttest.api

import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @POST("mobws/json/pointsList")
    fun getPoints(@Query("version") version: String, @Body body: CountBody): Observable<BaseResponse<Result>>

}