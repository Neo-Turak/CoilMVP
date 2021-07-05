package com.easyhome.jrconsumer.mvp.extension

data class ListBean(
    var name: String,
    var isSelect: Boolean,
    var ls: List<ListBean>
)