package com.coolrocket.charttest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.coolrocket.charttest.R
import com.coolrocket.charttest.dagger.ComponentHolder
import com.jakewharton.rxbinding3.view.clicks
import kotlinx.android.synthetic.main.fragment_data.*
import me.dmdev.rxpm.base.PmFragment
import me.dmdev.rxpm.bindTo
import me.dmdev.rxpm.widget.bindTo


class DataFragment : PmFragment<DataPm>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onBindPresentationModel(pm: DataPm) {
        pm.input.bindTo(data_fragment_enter_count)
        data_fragment_button.clicks().bindTo(pm.go)
        pm.buttonEnabled bindTo data_fragment_button::setEnabled

    }

    override fun providePresentationModel() = DataPm()

}
