package com.coolrocket.charttest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.coolrocket.charttest.R

class MainActivity : AppCompatActivity() {


    companion object {
        lateinit var INSTANCE: MainActivity
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        INSTANCE = this
        setContentView(R.layout.activity_main)

    }
}
