package com.coolrocket.charttest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coolrocket.charttest.R
import me.dmdev.rxpm.base.PmFragment

/**
 * A simple [Fragment] subclass.
 */
class ChartFragment : PmFragment<ChartPm>() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chart, container, false)
    }

    override fun onBindPresentationModel(pm: ChartPm) {
    }

    override fun providePresentationModel() = ChartPm()

}
