package com.coolrocket.charttest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coolrocket.charttest.CoolApp
import com.coolrocket.charttest.R
import com.coolrocket.charttest.Router
import com.coolrocket.charttest.dagger.ComponentHolder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoolApp.ACTIVITY_INSTANCE = this
        setContentView(R.layout.activity_main)
    }
}
