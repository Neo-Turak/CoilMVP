package com.easyhome.jrconsumer.mvp.contract

import com.easyhome.jrconsumer.di.beans.UserRealInfo
import com.easyhome.jrconsumer.mvp.extension.HttpResult
import com.jess.arms.mvp.IView
import com.jess.arms.mvp.IModel
import io.reactivex.Observable


interface WelcomeContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View : IView

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model : IModel{
        fun getUserRealInfo(map: Map<String,String>) : Observable<HttpResult<UserRealInfo>>
    }

}
