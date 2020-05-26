package com.coolrocket.charttest.ui

import com.coolrocket.charttest.api.Api
import io.reactivex.schedulers.Schedulers
import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.action
import me.dmdev.rxpm.state
import me.dmdev.rxpm.widget.inputControl
import timber.log.Timber

class DataPm(private val api: Api, private val router: Router) : PresentationModel() {

    val input = inputControl()
    val buttonEnabled = state(false) {
        input.text.observable.map { it.isNotBlank() }
    }
    val go = action<Unit>()

    override fun onCreate() {
        super.onCreate()

        go.observable
            .map { input.text }
            .switchMap {
                router.hideKeyboard()
                //TODO move to model
                api.getPoints("1.1", input.text.value.toInt())
                    .subscribeOn(Schedulers.io())
            }
            .subscribe({ response ->
                if (response.message.isNotEmpty()) {
                    Timber.e(response.message)
                    router.showSnack(response.message)
                } else {
                    Timber.e("yes")
                    //TODO save to repo
                    // router.openChart()
                }
            },
                { error ->
                    Timber.e(error)
                    error.message?.let {
                        router.showSnack(it)
                    }
                })
            .untilDestroy()

    }

}