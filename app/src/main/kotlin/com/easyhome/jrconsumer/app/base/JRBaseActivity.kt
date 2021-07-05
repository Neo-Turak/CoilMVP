package com.easyhome.jrconsumer.app.base

import android.content.*
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AlertDialog
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import androidx.viewbinding.ViewBinding
import com.easyhome.jrconsumer.R
import com.easyhome.jrconsumer.app.bean.MessageData
import com.easyhome.jrconsumer.app.extension.singleClick
import com.easyhome.jrconsumer.app.extension.strToInt
import com.easyhome.jrconsumer.app.manager.UserInfoManager
import com.easyhome.jrconsumer.app.receiver.NetWorkChangReceiver
import com.jess.arms.base.BaseActivity
import com.jess.arms.mvp.IPresenter
import org.jetbrains.anko.matchParent


/**
 * Time 2018/9/3  下午3:11
 *
 * JRBaseActivity
 */
abstract class JRBaseActivity<P : IPresenter,VB:ViewBinding> : BaseActivity<P,VB>(),
    IView {
    private var isRegistered = false
    private var netWorkChangReceiver: NetWorkChangReceiver? = null
    private var localRecevier: LocalRecevier? = null
    lateinit var mLocalBroadcastManager: LocalBroadcastManager

    lateinit var netErrorLayout: View
    override fun onCreate(savedInstanceState: Bundle?) {
        // 顺序不可变 需在调用super之前置为false 不需要BaseActivity来创建布局
        super.onCreate(savedInstanceState)
  //      netErrorLayout = LayoutInflater.from(this).inflate(R.layout.layout_net_error, null)
        netErrorLayout.singleClick {
            netErrorLayout.visibility = View.GONE
            initData(savedInstanceState)
        }
            setContentView(initView(savedInstanceState))
            addContentView(netErrorLayout, FrameLayout.LayoutParams(matchParent, matchParent))
        netErrorLayout.visibility = View.GONE

        initData(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()

        netWorkChangReceiver = NetWorkChangReceiver()
        /*netWorkChangReceiver!!.setCallBack() { msg ->
            if (DeviceUtils.getVersionCode(this).toString() in msg.androidVesionMsg?.forceUpdateVersions?: arrayListOf()) {
                //如果在强制更新列表，则直接执行 强制更新
                DialogUtils.showUpDataDialog(this, msg.androidVesionMsg.updateDescription, msg.androidVesionMsg.apkUrl, View.GONE)
            } else if (DeviceUtils.getVersionCode(this) <= msg.androidVesionMsg.minVersion.strToInt()) {//当前版本不高于最小版本，需要强制更新
                DialogUtils.showUpDataDialog(this, msg.androidVesionMsg.updateDescription, msg.androidVesionMsg.apkUrl, View.GONE)
            } else if (DeviceUtils.getVersionCode(this) < msg.androidVesionMsg.nowVersion.strToInt()) {//当前版本小于最新版本 建议更新
                DialogUtils.showUpDataDialog(this, msg.androidVesionMsg.updateDescription, msg.androidVesionMsg.apkUrl)
            }
        }*/

        val filter = IntentFilter()
        filter.addAction(WifiManager.WIFI_STATE_CHANGED_ACTION)
        filter.addAction(WifiManager.NETWORK_STATE_CHANGED_ACTION)
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION)
        registerReceiver(netWorkChangReceiver, filter)
        isRegistered = true


        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        localRecevier = LocalRecevier();                                                     //实例化广播接收器 MyReceiver()
        val localFilter = IntentFilter("com.easyhome.serve.action");          //动态配置广播接收器action
        mLocalBroadcastManager.registerReceiver(localRecevier!!, localFilter);
    }

    override fun onPause() {
        super.onPause()
        //解绑
        if (isRegistered) {
            unregisterReceiver(netWorkChangReceiver)
        }
        if (localRecevier != null) {
            mLocalBroadcastManager.unregisterReceiver(localRecevier!!)
        }
    }

    override fun showNetError() {
        netErrorLayout.visibility = View.VISIBLE
    }

    open fun activityResult(requestCode: Int, resultCode: Int, data: Intent?) {}
    //    /**
//     * 设置状态栏颜色
//     *
//     * @param color
//     */
//    fun setStatusBarColor(@ColorInt color: Int) {
//        setStatusBarColor(color, StatusBarUtil.DEFAULT_STATUS_BAR_ALPHA)
//    }
//
//    /**
//     * 设置状态栏颜色
//     *
//     * @param color
//     * @param statusBarAlpha 透明度
//     */
//    fun setStatusBarColor(@ColorInt color: Int, @IntRange(from = 0, to = 255) statusBarAlpha: Int) {
//        StatusBarUtil.setColorForSwipeBack(this, color, statusBarAlpha)
//    }
    var mBuilder: AlertDialog.Builder? = null
    var mDialog: AlertDialog? = null
    fun hintDialog(msgd: MessageData) {
        if (mBuilder == null) {
            mBuilder = AlertDialog.Builder(this)
            mBuilder!!.setTitle(msgd.title)
            mBuilder!!.setMessage(msgd.details)
            //设置确认按钮
            mBuilder!!.setNegativeButton("确定") { _, _ ->

                when (msgd.messageType.strToInt()) {

                    0 -> {
                        println("xiaox----------${msgd.messageType}")

             //           val inte = Intent(this@JRBaseActivity, MessageInfoActivity::class.java)
                    }

                    1 -> {
              //          startActivity<ComplainActivity>("comCode" to msgd.comCode)
                        isRead(
                            mapOf(
                                "token" to UserInfoManager.getInstance().userToken,
                                "messageCode" to msgd.messageCode,
                                "accountType" to "0",
                                "userId" to UserInfoManager.getInstance().userId
                            )
                        )
                    }
                    2 -> {
                        setLive(mapOf("proID" to msgd.proID, "isLive" to "1"))
                        isRead(
                            mapOf(
                                "token" to UserInfoManager.getInstance().userToken,
                                "messageCode" to msgd.messageCode,
                                "accountType" to "0",
                                "userId" to UserInfoManager.getInstance().userId
                            )
                        )
                    }
                    3 -> {

                        proDesignConfirm(
                            mapOf(
                                "token" to UserInfoManager.getInstance().userToken,
                                "userId" to UserInfoManager.getInstance().userId,
                                "proID" to msgd.proID,
                                "erpID" to msgd.erpId
                            )
                        )

                    }
                }

                mDialog!!.dismiss()
                mBuilder = null
            }
            //设置取消按钮
            mBuilder!!.setPositiveButton("取消") { dialogInterface, i ->
                if (msgd.messageType.strToInt() == 2) {
                    setLive(mapOf("proID" to msgd.proID, "isLive" to "0"))
                }
                mDialog!!.dismiss()
                mBuilder = null
            }
        }

        if (mDialog == null) {

            mDialog = mBuilder!!.create()
            //需要把对话框的类型设为TYPE_SYSTEM_ALERT，否则对话框无法在广播接收器里弹出
            mDialog!!.setCancelable(false)
            mDialog!!.setCanceledOnTouchOutside(false)
        }

        if (!mDialog!!.isShowing) {
            mDialog!!.show()
        }/*else{
            builder.setMessage("你有多条新消息")
        }*/
    }

    inner class LocalRecevier : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            hintDialog(p1!!.getSerializableExtra("data") as MessageData)
        }
    }

    fun setLive(map: Map<String, String>) {
/*        val appComment = ArmsUtils.obtainAppComponentFromContext(applicationContext)
        appComment.repositoryManager().obtainRetrofitService(JRService::class.java)
            .setLive(map)
            .compose(RxUtils.applySchedulersToBoolean(this))
            .subscribe(object : ResponseErrorSubscriber<Any>(appComment.rxErrorHandler()) {
                override fun onNext(any: Any) {

                }
            })*/
    }

    fun isRead(map: Map<String, String>) {
/*        val appComment = ArmsUtils.obtainAppComponentFromContext(applicationContext)
        appComment.repositoryManager().obtainRetrofitService(JRService::class.java)
            .modifyRead(map.getRequestBody())
            .compose(RxUtils.applySchedulersToBoolean(this))
            .subscribe(object : ResponseErrorSubscriber<Any>(appComment.rxErrorHandler()) {
                override fun onNext(any: Any) {

                }
            })*/
    }

    fun proDesignConfirm(map: Map<String, String>) {
 /*       val appComment = ArmsUtils.obtainAppComponentFromContext(applicationContext)
        appComment.repositoryManager().obtainRetrofitService(JRService::class.java)
            .proDesignConfirm(map)
            .compose(RxUtils.applySchedulersToBoolean(this))
            .subscribe(object : ResponseErrorSubscriber<Any>(appComment.rxErrorHandler()) {
                override fun onNext(any: Any) {

                }
            })*/
    }

    fun setNoData(visibility: Int) {

    }

    fun setTitleTheme(theme: Int) {

        /*when (theme) {

            THEME_WHITE -> {
                tvPageTitle.textColor = Color.parseColor("#040404")
                tvPageRight.textColor = Color.parseColor("#040404")
                ivPageBack.setImageResource(R.mipmap.tab_register_return)
                baseTitle.setBackgroundColor(resources.getColor(R.color.white))
            }

            THEME_BLUE -> {
                tvPageTitle.textColor = resources.getColor(R.color.white)
                tvPageRight.textColor = resources.getColor(R.color.white)
                ivPageBack.setImageResource(R.mipmap.tab_register_return_white)
                baseTitle.setBackgroundColor(resources.getColor(R.color.color366))
            }

        }*/


    }

}