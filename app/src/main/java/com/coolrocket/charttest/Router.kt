package com.coolrocket.charttest

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.navigation.findNavController
import com.coolrocket.charttest.dagger.ComponentHolder
import com.google.android.material.snackbar.Snackbar

class Router {

    fun showSnack(message: String) {
        val activity = CoolApp.ACTIVITY_INSTANCE
        val root: View = activity.findViewById(R.id.root)
        Snackbar.make(root, message, Snackbar.LENGTH_SHORT).show()
    }

    fun hideKeyboard() {
        val activity = CoolApp.ACTIVITY_INSTANCE
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view = activity.currentFocus ?: View(activity)
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun openChart() {
        val activity = CoolApp.ACTIVITY_INSTANCE
        val navController = activity.findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.action_dataFragment_to_chartFragment)
    }

}