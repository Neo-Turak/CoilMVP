package com.easyhome.jrconsumer.app.utils

import com.easyhome.jrconsumer.mvp.extension.HttpResult
import io.reactivex.functions.Function

/**
 * Created by 宗传
 * Time 2018/8/31  上午11:16
 *
 * RxHttpResult
 **/
class RxHttpResult<T> : Function<HttpResult<T>, T> {
    override fun apply(t: HttpResult<T>): T? {
        return t.data
    }
}