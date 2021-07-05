package com.easyhome.jrconsumer.app.converter

import com.easyhome.jrconsumer.app.HttpResultException
import com.easyhome.jrconsumer.mvp.extension.ErrorInfo
import com.easyhome.jrconsumer.mvp.extension.HttpResult
import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Converter
import java.io.IOException
import java.lang.reflect.Type

class GsonResponseBodyConverter<T>(private val gson: Gson, private val type: Type) :
    Converter<ResponseBody, T> {
    @Throws(IOException::class)
    override fun convert(value: ResponseBody): T {
        val response = value.string()
        val httpResult = gson.fromJson(response, HttpResult::class.java)
        return if (httpResult.isSuccess) {
            gson.fromJson(response, type)
        } else {
            if (httpResult.isSucce) { //判断外网IP地址
                gson.fromJson(response, type)
            } else throw HttpResultException(
                ErrorInfo(
                    httpResult.code,
                    httpResult.message
                )
            )
        }
    }
}