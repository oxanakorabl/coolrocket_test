package com.coolrocket.charttest

import com.coolrocket.charttest.api.Api
import com.coolrocket.charttest.api.Point
import com.coolrocket.charttest.api.Response
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject

class Repository(private val api: Api) {

    val pointsSubject = BehaviorSubject.createDefault(mutableListOf<Point>())

    fun getApiPoints(count: Int): Observable<Response> = api.getPoints("1.1", count)
        .subscribeOn(Schedulers.io())

    fun storePoints(list: List<Point>) {
        val points = mutableListOf<Point>()
        points.addAll(list)
        points.sortBy { it.x }
        pointsSubject.onNext(points)
    }

}