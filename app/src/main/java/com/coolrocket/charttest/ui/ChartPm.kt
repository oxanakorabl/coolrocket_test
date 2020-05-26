package com.coolrocket.charttest.ui

import com.coolrocket.charttest.Repository
import com.coolrocket.charttest.api.Point
import com.coolrocket.charttest.dagger.ComponentHolder
import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.state
import timber.log.Timber

class ChartPm : PresentationModel() {

    private val repository: Repository = ComponentHolder.appComponent.getRepository()

    val points = state<List<Point>>()

    override fun onCreate() {
        super.onCreate()
        Timber.e("ChartPm onCreate")

        repository.pointsSubject
            .subscribe(points.consumer)
            .untilDestroy()
    }

    override fun onBind() {
        super.onBind()
        Timber.e("onBind")
    }

    override fun onUnbind() {
        super.onUnbind()
        Timber.e("onUnbind")
    }
}