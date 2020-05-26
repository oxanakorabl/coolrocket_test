package com.coolrocket.charttest.ui

import com.coolrocket.charttest.Repository
import com.coolrocket.charttest.Router
import com.coolrocket.charttest.api.Response
import com.coolrocket.charttest.dagger.ComponentHolder
import me.dmdev.rxpm.PresentationModel
import me.dmdev.rxpm.action
import me.dmdev.rxpm.state
import me.dmdev.rxpm.widget.inputControl
import timber.log.Timber

class DataPm : PresentationModel() {

    private val repository: Repository = ComponentHolder.appComponent.getRepository()
    private val router: Router = ComponentHolder.appComponent.getRouter()

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
                repository.getApiPoints(input.text.value.toInt())
            }
            .subscribe({ handleResponse(it) }, { displayError(it) })
            .untilDestroy()
    }

    private fun handleResponse(response: Response) {
        if (response.message.isNotEmpty()) {
            router.showSnack(response.getDecodedMessage())
        } else {
            response.points?.let {
                repository.storePoints(response.points)
            }
            router.openChart()
        }
    }

    private fun displayError(error: Throwable) {
        Timber.e(error)
        error.message?.let { router.showSnack(it) }
    }
}