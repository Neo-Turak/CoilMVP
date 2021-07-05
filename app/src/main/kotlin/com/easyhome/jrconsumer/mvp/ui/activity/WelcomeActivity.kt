package com.easyhome.jrconsumer.mvp.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.databinding.ActivityWelcomeBinding
import com.easyhome.jrconsumer.di.component.DaggerWelcomeComponent
import com.easyhome.jrconsumer.di.module.WelcomeModule
import com.easyhome.jrconsumer.mvp.contract.WelcomeContract
import com.easyhome.jrconsumer.mvp.presenter.WelcomePresenter
import com.jess.arms.base.BaseActivity
import com.jess.arms.di.component.AppComponent
import com.jess.arms.utils.ArmsUtils
import timber.log.Timber

/**
 * 欢迎页
 *
 */
class WelcomeActivity : BaseActivity<WelcomePresenter,ActivityWelcomeBinding>(), WelcomeContract.View {

    override fun setupActivityComponent(appComponent: AppComponent) {
            DaggerWelcomeComponent //如找不到该类,请编译一下项目
            .builder()
            .appComponent(appComponent)
            .welcomeModule(WelcomeModule(this))
            .build()
            .inject(this)
    }

    override fun initView(savedInstanceState: Bundle?): Int {
        return R.layout.activity_welcome
    }


    override fun setContentView(view: View) {
        super.setContentView(binding!!.root)
    }

    override fun initData(savedInstanceState: Bundle?) {
        binding!!.textView.text="你好"

        mPresenter!!.getUserRealInfo(
            mapOf(
                "userId" to "100"
            )
        ){
            Timber.e(it.toString())
        }
    }

    override fun showMessage(message: String) {
        ArmsUtils.snackbarText(message)
    }

    override fun launchActivity(intent: Intent) {
        ArmsUtils.startActivity(intent)
    }



    override fun killMyself() {
        finish()
    }
}
