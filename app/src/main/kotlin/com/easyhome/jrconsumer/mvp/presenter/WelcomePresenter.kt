package com.easyhome.jrconsumer.mvp.presenter

import android.app.Application
import com.easyhome.jrconsumer.app.ResponseErrorSubscriber
import com.easyhome.jrconsumer.app.utils.RxUtils
import com.easyhome.jrconsumer.di.beans.UserRealInfo

import com.jess.arms.integration.AppManager
import com.jess.arms.di.scope.ActivityScope
import com.jess.arms.mvp.BasePresenter
import com.jess.arms.http.imageloader.ImageLoader
import me.jessyan.rxerrorhandler.core.RxErrorHandler
import javax.inject.Inject

import com.easyhome.jrconsumer.mvp.contract.WelcomeContract


@ActivityScope
class WelcomePresenter
@Inject
constructor(model: WelcomeContract.Model, rootView: WelcomeContract.View) :
    BasePresenter<WelcomeContract.Model, WelcomeContract.View>(model, rootView) {
    @Inject
    lateinit var mErrorHandler: RxErrorHandler
    @Inject
    lateinit var mApplication: Application
    @Inject
    lateinit var mImageLoader: ImageLoader
    @Inject
    lateinit var mAppManager: AppManager

    fun getUserRealInfo(map: Map<String,String>, success: (it:UserRealInfo) -> Unit){
        mModel.getUserRealInfo(map).compose(RxUtils.applySchedulersToData(mRootView))
            .subscribe(object : ResponseErrorSubscriber<UserRealInfo>(mErrorHandler){
                override fun onNext(t: UserRealInfo) {
                    success(t)
                }
            })
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
