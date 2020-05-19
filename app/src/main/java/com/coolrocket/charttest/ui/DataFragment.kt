package com.coolrocket.charttest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.coolrocket.charttest.R
import com.coolrocket.charttest.dagger.ComponentHolder
import me.dmdev.rxpm.base.PmFragment


class DataFragment : PmFragment<DataPm>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onBindPresentationModel(pm: DataPm) {

    }

    override fun providePresentationModel() = ComponentHolder.appComponent.geDataPm()

}
