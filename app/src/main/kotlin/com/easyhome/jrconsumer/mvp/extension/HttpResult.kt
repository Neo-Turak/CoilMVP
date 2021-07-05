package com.easyhome.jrconsumer.mvp.extension

import java.io.Serializable

class HttpResult<T> : Serializable {
    /**
     * 业务code码
     */
    var code = 0

    /**
     * 错误信息描述
     */
    var message: String? = null

    /**
     * 返回数据的时间
     */
    var timestamp: String? = null

    /**
     * 业务数据
     */
    var data: T? = null
        private set

    /**
     * 版本信息
     */
    var versionMsg: VersionMsgBean? = null
    fun setData(data: T) {
        this.data = data
    }

    class VersionMsgBean {
        /**
         * 更新地址
         */
        var appAddress: String? = null

        /**
         * 更新信息描述
         */
        var updateMsg: String? = null

        /**
         * 是否更新,0，无更新，1建议更新，2强制更新
         */
        var updateState = 0
    }

    /**
     * 请求是否成功
     */
    val isSuccess: Boolean
        get() = code == 200

    /**
     * 外部请求中出现
     */
    val isSucce: Boolean
        get() = code == 0 && data.toString().contains("isp")
}