package com.coolrocket.charttest.ui

import com.coolrocket.charttest.Repository
import com.coolrocket.charttest.api.Point
import com.coolrocket.charttest.dagger.ComponentHolder
import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.state
import timber.log.Timber

class ChartPm(private val repository: Repository) : PresentationModel() {

    val points = state<List<Point>>()

    override fun onCreate() {
        super.onCreate()

        repository.pointsSubject
            .subscribe(points.consumer)
            .untilDestroy()
    }
}