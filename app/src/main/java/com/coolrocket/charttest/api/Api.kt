package com.coolrocket.charttest.api

import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {

    @FormUrlEncoded
    @POST("mobws/json/pointsList")
    fun getPoints(
        @Query("version") version: String,
        @Field("count") count: Int
    ): Observable<Response>

}