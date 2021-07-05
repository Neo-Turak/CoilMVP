package com.easyhome.jrconsumer.mvp.extension

import com.google.gson.annotations.SerializedName


data class EditAddressContractModel(
    @SerializedName("code") var code: String, // 110119
    @SerializedName("name") var name: String // 延庆区
)