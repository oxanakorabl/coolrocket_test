package com.coolrocket.charttest.ui

import com.coolrocket.charttest.api.Api
import io.reactivex.schedulers.Schedulers
import me.dmdev.rxpm.PresentationModel
import timber.log.Timber

class DataPm(private val api: Api, private val router: Router) : PresentationModel() {

    override fun onCreate() {
        super.onCreate()

        api.getPoints("1.1", 8)
            .subscribeOn(Schedulers.io())
            .subscribe({


                if (it.message.isNotEmpty()) {
                    Timber.e("${it.result} ${it.message}")
                    router.showSnack(it.message)
                }
            }, { e ->
                Timber.e(e)
                router.showSnack(e.message!!)
            })
            .untilDestroy()
    }

}