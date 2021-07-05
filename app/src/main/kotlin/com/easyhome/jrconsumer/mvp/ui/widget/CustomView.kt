package com.easyhome.jrconsumer.mvp.ui.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.View
import com.easyhome.jrconsumer.R
import kotlinx.coroutines.supervisorScope

class CustomView : View {
    var mPaint = Paint()

    constructor(context: Context) : super(context){

    }
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {

    }

    constructor(context: Context, attributeSet: AttributeSet, theme: Int) : super(
        context,
        attributeSet,
        theme
    ) {}

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        val dm = resources.displayMetrics
      val  screenWidth = dm.widthPixels // 屏幕宽（像素，如：480px）
      val  screenHeight = dm.heightPixels // 屏幕高（像素，如：800px）

        mPaint.isAntiAlias = true
        mPaint.color = Color.BLUE
        canvas!!.drawColor(Color.WHITE)
   //     canvas.drawCircle((screenWidth/2).toFloat(), (screenHeight/2).toFloat(), 10F, mPaint)
        mPaint.color=Color.GREEN
        mPaint.strokeWidth=5.0F
        canvas.drawLine(100F,100F,200F,200F,mPaint)
    //    canvas.drawBitmap(bitmap,(screenWidth/2).toFloat(),(screenHeight/2).toFloat(),mPaint)
        canvas.drawRoundRect(RectF(100F,250F,300F,400F),10F,10F,mPaint)
        postInvalidate()
    }

}