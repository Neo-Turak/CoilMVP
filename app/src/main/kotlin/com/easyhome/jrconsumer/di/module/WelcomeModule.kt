package com.easyhome.jrconsumer.di.module

import com.jess.arms.di.scope.ActivityScope

import dagger.Module
import dagger.Provides

import com.easyhome.jrconsumer.mvp.contract.WelcomeContract
import com.easyhome.jrconsumer.mvp.model.WelcomeModel


@Module
//构建WelcomeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
class WelcomeModule(private val view: WelcomeContract.View) {
    @ActivityScope
    @Provides
    fun provideWelcomeView(): WelcomeContract.View {
        return this.view
    }

    @ActivityScope
    @Provides
    fun provideWelcomeModel(model: WelcomeModel): WelcomeContract.Model {
        return model
    }
}
