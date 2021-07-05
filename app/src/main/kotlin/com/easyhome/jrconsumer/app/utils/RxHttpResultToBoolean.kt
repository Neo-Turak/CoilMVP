package com.easyhome.jrconsumer.app.utils

import com.easyhome.jrconsumer.mvp.extension.HttpResult
import io.reactivex.functions.Function


class RxHttpResultToBoolean<T> : Function<HttpResult<T>, Boolean> {
    override fun apply(t: HttpResult<T>): Boolean {
        return true
    }
}