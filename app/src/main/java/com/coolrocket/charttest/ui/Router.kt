package com.coolrocket.charttest.ui

import android.view.View
import com.coolrocket.charttest.R
import com.coolrocket.charttest.dagger.ComponentHolder
import com.google.android.material.snackbar.Snackbar

class Router {
    fun showSnack(message: String) {
        val activity = ComponentHolder.appComponent.getActivity()
        val root: View = activity.findViewById(R.id.root)

        Snackbar.make(root, message, Snackbar.LENGTH_SHORT).show()
    }

}