package com.coolrocket.charttest.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.coolrocket.charttest.R
import com.coolrocket.charttest.api.Point
import com.coolrocket.charttest.dagger.ComponentHolder
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.fragment_chart.*
import me.dmdev.rxpm.base.PmFragment
import me.dmdev.rxpm.bindTo

class ChartFragment : PmFragment<ChartPm>() {

    private val tableAdapter = TableAdapter()

    override fun providePresentationModel() = ChartPm(ComponentHolder.appComponent.getRepository())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_chart, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(chart_fragment_recycler) {
            layoutManager = LinearLayoutManager(view.context)
            setHasFixedSize(true)
            adapter = tableAdapter
        }
        with(chart_fragment_chart) {
            xAxis.labelRotationAngle = 0f
            axisRight.isEnabled = false
            setTouchEnabled(true)
            setPinchZoom(true)
            description = null
            legendRenderer
        }
    }

    override fun onBindPresentationModel(pm: ChartPm) {
        pm.points bindTo {
            tableAdapter.items = it
            setChart(it)
        }
    }

    private fun setChart(points: List<Point>) {
        val entries = points.map { Entry(it.x, it.y) }

        val dataSet = LineDataSet(entries, "Points")
        with(dataSet) {
            setDrawValues(false)
            setDrawFilled(false)
            setDrawCircleHole(false)
            lineWidth = 3f
            setCircleColor(Color.RED)
            mode = LineDataSet.Mode.HORIZONTAL_BEZIER
        }

        chart_fragment_chart.data = LineData(dataSet)
        chart_fragment_chart.invalidate()
    }

}
