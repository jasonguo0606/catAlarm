package com.jason.catalarm.ui

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.Switch
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.jason.catalarm.R

class SettingItemView : ConstraintLayout {

//    private var binding : SettingItemBinding? = null
    private var mContext : Context? = null
    private var root : View? = null

    constructor(context: Context) : super(context) {
        mContext = context
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context) {
        mContext = context
        init(attrs, 0 )
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        root = LayoutInflater.from(mContext).inflate(R.layout.setting_item, this)

        val a = context.obtainStyledAttributes(
            attrs, R.styleable.SettingItem, defStyle, 0
        )
        // 设置content
        var content : String? = a.getString(R.styleable.SettingItem_setting_item_content)
        if (content != null) {
            setText(content)
        }
        // 设置icon
        var iconRes : Int = a.getResourceId(R.styleable.SettingItem_setting_item_icon, R.drawable.logo)
        setIcon(iconRes)
        // 设置样式，0为可点击，1为开关，其余为默认样式
        var type : Int = a.getInteger(R.styleable.SettingItem_setting_item_type, 0)
        setType(type)

        a.recycle()

        // 设置content
//        val title = resources.getText(a
//            .getResourceId(R.styleable.SettingItem_setting_item_content,
//                R.string.setting_group_item_plugin))
//        setText(title.toString())
//        // 设置icon
//        val iconRes = resources.getInteger(a.getResourceId(R.styleable.SettingItem_setting_item_icon, R.drawable.logo))
//        setIcon(iconRes)
//        // 设置样式，0为
//        val ccc = a.getResourceId(R.styleable.SettingItem_setting_item_type,0)
//        val type = resources.getInteger(a.getResourceId(R.styleable.SettingItem_setting_item_type,0))
//        setType(type)
//        a.recycle()



//        attrs?.let {
//            val typedArray = context.obtainStyledAttributes(it,
//                R.styleable.SettingItem, 0, 0)
//
//            // 设置content
//            val title = resources.getText(typedArray
//                .getResourceId(R.styleable.SettingItem_setting_item_content,
//                    R.string.setting_group_item_plugin))
//            setText(title.toString())
//            // 设置icon
//            val iconRes = resources.getInteger(typedArray.getResourceId(R.styleable.SettingItem_setting_item_icon, R.drawable.logo))
//            setIcon(iconRes)
//            // 设置样式，0为
//            val ccc = typedArray.getResourceId(R.styleable.SettingItem_setting_item_type,0)
//            Toast.makeText(mContext,ccc,3000).show()
//            val type = resources.getInteger(typedArray.getResourceId(R.styleable.SettingItem_setting_item_type,0))
//            setType(type)
//
//            typedArray.recycle()
//        }
    }

    private fun setText(content : String) {
        val textView = root!!.findViewById<TextView>(R.id.tv_setting_content)
        textView.text  = content
    }

    private fun setIcon(resId : Int) {
        val imageView =  root!!.findViewById<ImageView>(R.id.iv_setting_icon)
        imageView.setImageResource(resId)
    }

    private fun setType(type : Int) {
        val imageView = root!!.findViewById<ImageView>(R.id.iv_setting_arrow)
        val switch = root!!.findViewById<Switch>(R.id.swb_setting)
        if (type == 0) {
            imageView.visibility = VISIBLE
            switch.visibility = GONE
        } else if (type == 1) {
            imageView.visibility = GONE
            switch.visibility = VISIBLE
        } else {
            imageView.visibility = GONE
            switch.visibility = GONE
        }
    }

}