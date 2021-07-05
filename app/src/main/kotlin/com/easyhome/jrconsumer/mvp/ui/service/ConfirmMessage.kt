package com.easyhome.jrconsumer.mvp.ui.service
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * @author Hugo
 * @time 4/1/2021
 * @Desciption TODO 文件描述
 * Think Twice，Code Once。
 */
@Parcelize
data class ConfirmMessage(
    var acceptCode: String? = null,
    val details:String?=null,
    val messageCode:String?=null,
    val messageType:String?=null,
    val proID:String?=null,
    val skipType:String?=null,
    val title:String?=null
):Parcelable
