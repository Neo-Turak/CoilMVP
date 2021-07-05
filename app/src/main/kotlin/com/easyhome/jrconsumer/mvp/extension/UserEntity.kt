package com.easyhome.jrconsumer.mvp.extension

import me.yokeyword.indexablerv.IndexableEntity

/**
 * Created by YoKey on 16/10/8.
 */
class UserEntity(var nick: String, var mobile: String) : IndexableEntity {
    var avatar: String? = null
    override fun getFieldIndexBy(): String {
        return nick
    }

    override fun setFieldIndexBy(indexField: String) {
        nick = indexField
    }

    override fun setFieldPinyinIndexBy(pinyin: String) {
        // 需要用到拼音时(比如:搜索), 可增添pinyin字段 this.pinyin  = pinyin
        // 见 CityEntity
    }
}