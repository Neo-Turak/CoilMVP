package com.easyhome.jrconsumer.mvp.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import com.easyhome.jrconsumer.api.service.InputWindowListener


/**
 * @author Hugo
 * @time  4/26/2021
 * @Desciption 这个布局可以监听键盘的弹出和隐藏事件
 * Think Twice，Code Once。
 */
class IMMListenerRelativeLayout : RelativeLayout {
    private var listener: InputWindowListener? = null

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {}
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    ) {
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        if (oldh > h) {
            listener!!.show()
        } else {
            listener!!.hidden()
        }
    }

    fun setListener(listener: InputWindowListener?) {
        this.listener = listener
    }
}