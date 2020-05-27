package com.coolrocket.charttest.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coolrocket.charttest.R
import com.coolrocket.charttest.api.Point
import com.coolrocket.charttest.inflate
import kotlinx.android.synthetic.main.item_point.view.*


class TableAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_HEADER = 0
        private const val TYPE_ITEM = 1
    }

    var items: List<Point>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        if (viewType == TYPE_HEADER) {
            HeaderViewHolder(parent.inflate(R.layout.item_point_header))
        } else {
            ViewHolder(parent.inflate(R.layout.item_point))
        }

    override fun getItemCount() = if (items == null) 1 else items!!.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ViewHolder -> holder.bind(getItem(position), position)
        }
    }

    override fun getItemViewType(position: Int) = if (position == 0) TYPE_HEADER else TYPE_ITEM

    private fun getItem(position: Int) = items!![position - 1]

}

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Point, position: Int) {
        with(itemView) {
            item_point_position.text = position.toString()
            item_point_x.text = item.x.toString()
            item_point_y.text = item.y.toString()
        }
    }

}
