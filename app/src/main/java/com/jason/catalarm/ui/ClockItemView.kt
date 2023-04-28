package com.jason.catalarm.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.jason.catalarm.R

/**
 * TODO: document your custom view class.
 */
class ClockItemView : ConstraintLayout {

    private var mContext : Context? = null

    public lateinit var clockFlag : TextView
    public lateinit var clockTime : TextView

    constructor(context: Context) : super(context) {
        mContext = context
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mContext = context
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        mContext = context
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        val a = context.obtainStyledAttributes(
            attrs, R.styleable.ClockItemView, defStyle, 0
        )
        val inflater = inflate(mContext,R.layout.clock_item_view,this)
        clockFlag = inflater.findViewById(R.id.tv_clock_flag)
        clockTime = inflater.findViewById(R.id.tv_clock_time)

        a.recycle()
    }


}