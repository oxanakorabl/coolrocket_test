package com.coolrocket.charttest.ui

import com.coolrocket.charttest.api.Api
import com.coolrocket.charttest.api.CountBody
import io.reactivex.schedulers.Schedulers
import me.dmdev.rxpm.PresentationModel
import timber.log.Timber

class DataPm(private val api: Api) : PresentationModel() {

    override fun onCreate() {
        super.onCreate()

        api.getPoints("1.1", CountBody(8))
            .subscribeOn(Schedulers.io())
            .subscribe({
                Timber.e("${it.response.result}  ${it.response.message}")

            }, { e ->
                Timber.e(e)
            })
            .untilDestroy()
    }

}