package com.easyhome.jrconsumer.mvp.extension

import java.io.IOException

class HttpResultException : IOException {
    var errorInfo: ErrorInfo? = null

    constructor(errorInfo: ErrorInfo?) {
        this.errorInfo = errorInfo
    }

    constructor(detailMessage: String?) : super(detailMessage) {}
}