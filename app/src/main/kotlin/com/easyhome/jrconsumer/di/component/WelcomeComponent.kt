package com.easyhome.jrconsumer.di.component

import dagger.Component
import com.jess.arms.di.component.AppComponent

import com.easyhome.jrconsumer.di.module.WelcomeModule

import com.jess.arms.di.scope.ActivityScope
import com.easyhome.jrconsumer.mvp.ui.activity.WelcomeActivity

@ActivityScope
@Component(modules = [WelcomeModule::class], dependencies = [AppComponent::class])
interface WelcomeComponent {
    fun inject(activity: WelcomeActivity)
}
