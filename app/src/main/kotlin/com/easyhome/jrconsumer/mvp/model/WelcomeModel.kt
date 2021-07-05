package com.easyhome.jrconsumer.mvp.model

import android.app.Application
import com.easyhome.jrconsumer.api.service.JRService
import com.easyhome.jrconsumer.di.beans.UserRealInfo
import com.google.gson.Gson
import com.jess.arms.integration.IRepositoryManager
import com.jess.arms.mvp.BaseModel

import com.jess.arms.di.scope.ActivityScope
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.WelcomeContract
import com.easyhome.jrconsumer.mvp.extension.HttpResult
import io.reactivex.Observable


@ActivityScope
class WelcomeModel
@Inject
constructor(repositoryManager: IRepositoryManager) : BaseModel(repositoryManager), WelcomeContract.Model {
    @Inject
    lateinit var mGson: Gson;
    @Inject
    lateinit var mApplication: Application;
    override fun getUserRealInfo(map: Map<String,String>): Observable<HttpResult<UserRealInfo>> {
        return  mRepositoryManager.obtainRetrofitService(JRService::class.java).getUserRealInfo(map)
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
