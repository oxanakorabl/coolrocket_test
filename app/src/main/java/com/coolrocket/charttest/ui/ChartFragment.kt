package com.coolrocket.charttest.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.coolrocket.charttest.R
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.fragment_chart.*
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


        val entries = ArrayList<Entry>()


        entries.add(Entry(1f, 10f))
        entries.add(Entry(2f, 2f))
        entries.add(Entry(3f, 7f))
        entries.add(Entry(4f, 20f))
        entries.add(Entry(5f, 16f))


        val dataSet = LineDataSet(entries, "Points")
        dataSet.setDrawValues(false)
        dataSet.setDrawFilled(false)
        dataSet.setDrawCircleHole(false)
        dataSet.lineWidth = 3f
        dataSet.setCircleColor(Color.RED)
        dataSet.mode = LineDataSet.Mode.HORIZONTAL_BEZIER


        lineChart.xAxis.labelRotationAngle = 0f

        lineChart.data = LineData(dataSet)
        lineChart.axisRight.isEnabled = false
        lineChart.setTouchEnabled(true)
        lineChart.setPinchZoom(true)


        lineChart.description = null

        lineChart.legendRenderer


    }

    override fun providePresentationModel() = ChartPm()


}
