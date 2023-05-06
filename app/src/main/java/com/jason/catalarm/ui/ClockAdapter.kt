package com.jason.catalarm.ui

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ClockAdapter : RecyclerView.Adapter<ClockAdapter.ClockViewHoler>() {

    class ClockViewHoler(itemView : ClockItemView) : RecyclerView.ViewHolder(itemView) {
        var flag = itemView.clockFlag
        var time = itemView.clockTime
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClockViewHoler {
        val itemView = ClockItemView(parent.context)
        return ClockViewHoler(itemView)
    }

    override fun getItemCount(): Int {
        return 5
    }

    override fun onBindViewHolder(holder: ClockViewHoler, position: Int) {
        holder.flag.text = "一次"
        holder.time.text = "17：40"
    }
}