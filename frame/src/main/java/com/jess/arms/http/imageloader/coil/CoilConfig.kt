package com.jess.arms.http.imageloader.coil

import android.widget.ImageView

open class CoilConfig {
    var url: String? = null
        protected set
    var imageView: ImageView? = null
        protected set
    var placeholder //占位符
            = 0
        protected set
    var errorPic //错误占位符
            = 0
        protected set
}