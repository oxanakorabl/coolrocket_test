package com.coolrocket.charttest.ui

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.coolrocket.charttest.R
import com.coolrocket.charttest.dagger.ComponentHolder
import com.google.android.material.snackbar.Snackbar

class Router {
    fun showSnack(message: String) {
        val activity = ComponentHolder.appComponent.getActivity()
        val root: View = activity.findViewById(R.id.root)

        Snackbar.make(root, message, Snackbar.LENGTH_SHORT).show()
    }

    fun hideKeyboard() {
        val activity = ComponentHolder.appComponent.getActivity()
        val imm: InputMethodManager =
            activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        val view = activity.currentFocus ?: View(activity)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

}