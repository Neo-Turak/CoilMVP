package com.easyhome.jrconsumer.mvp.ui.adapter

import android.graphics.Color
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import org.jetbrains.anko.textColor

class DemoAdapter:BaseQuickAdapter<String, BaseViewHolder> {

    constructor(data: List<String>):super(0)

    override fun convert(helper: BaseViewHolder, item: String) {

    }

    override fun onCreateDefViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val linearLayout=LinearLayout(context)
        linearLayout.layoutParams=ViewGroup.LayoutParams(-2,-1)
        val mT=TextView(context)
        mT.textColor= Color.BLUE
        mT.layoutParams=LinearLayout.LayoutParams(-2,-1)
        linearLayout.addView(mT)
        return BaseViewHolder(linearLayout)
    }

}