package com.easyhome.jrconsumer.app.bean

import java.io.Serializable

data class MessageData(
    val id: Int, // 1
    val acceptID: Int, // 2
    val acceptRole: Int, // 3
    val acceptType: Int, // 0
    val details: String, // 店长 张三 将您解绑
    val getTime: String, // 2019-09-29 08:10:47
    val isDel: Int, // 0
    var isRead: String,
    val logTime: String, // 2019-09-29 08:10:47
    val proID: String, // 123456789
    val sendRole: Int, // 1
    val sendStaffID: Int, // 1
    val skipType: String,
    val sysCode: String, // 1
    val sysCodeID: Int, // 23
    val temID: String,
    val title: String, // 解绑消息
    val uuid: String,
    val messageCode: String,
    val messageType: String,
    val params: Comd,
    val erpId: String,
    val contractId: String,
    val orderId:String
) : Serializable {

    data class Comd(val comCode: String) : Serializable

}