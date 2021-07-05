package com.jess.arms.http.imageloader.coil

import android.content.Context

interface CoilImageLoaderStrategy<T:CoilConfig> {
    /**
     * 加载图片
     *
     * @param ctx
     * @param config
     */
    fun loadImage(ctx: Context, config: T)

    /**
     * 停止加载
     *
     * @param ctx
     * @param config
     */
    fun clear(ctx: Context, config: T)

}