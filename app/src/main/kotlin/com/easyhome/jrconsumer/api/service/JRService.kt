package com.easyhome.jrconsumer.api.service

import com.easyhome.jrconsumer.api.Api
import com.easyhome.jrconsumer.di.beans.UserRealInfo
import com.easyhome.jrconsumer.mvp.extension.HttpResult
import com.easyhome.jrconsumer.mvp.extension.LoginInfo

import io.reactivex.Observable
import okhttp3.RequestBody
import retrofit2.http.*


interface JRService {

    @POST("${Api.GET_USER_REAL_INFO}")
    fun getUserRealInfo(@QueryMap map: Map<String, String>):Observable<HttpResult<UserRealInfo>>
}

