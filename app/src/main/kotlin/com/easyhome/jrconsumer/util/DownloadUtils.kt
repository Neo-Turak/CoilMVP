package com.easyhome.jrconsumer.util

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Environment
import android.os.Handler
import android.os.Message
import com.easyhome.jrconsumer.app.DownloadException
import com.easyhome.jrconsumer.app.ResponseErrorSubscriber
import com.easyhome.jrconsumer.app.extension.downloadFile
import com.easyhome.jrconsumer.app.utils.RxUtils
import com.easyhome.jrconsumer.mvp.ui.service.DownloadService
import com.jess.arms.utils.ArmsUtils
import com.jess.arms.utils.PermissionUtil
import com.tbruyelle.rxpermissions2.RxPermissions
import okhttp3.ResponseBody
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream

/**
 *@创建人 lin
 *@创建时间 2019/12/4
 *@描述
 */
class DownloadUtils {

    private lateinit var mInputSteam: InputStream
    private lateinit var mOutputStream: OutputStream
    fun down(activity: Activity, name: String, url: String, handler: Handler) {
        PermissionUtil.externalStorage(object : PermissionUtil.RequestPermission {
            override fun onRequestPermissionSuccess() {


                object : Thread() {
                    override fun run() {
                        //需要在子线程中处理的逻辑
                        val galleryPath =
                            Environment.getExternalStorageDirectory().path + File.separator + Environment.DIRECTORY_DCIM + File.separator + "Camera" + File.separator
                        val appComment = ArmsUtils.obtainAppComponentFromContext(activity)
                        appComment.repositoryManager().obtainRetrofitService(DownloadService::class.java)
                            .download(url)
                            .subscribe(object : ResponseErrorSubscriber<ResponseBody>(appComment.rxErrorHandler()) {
                                override fun onNext(t: ResponseBody) {
                                    //保存文件到sd卡
                                    println("11-------xxx---------------------ooo")
                                    try {
                                        val filePath = galleryPath
                                        val dir = File(filePath)
                                        if (!dir.exists()) {
                                            dir.mkdirs()
                                        }

                                        val file = File(filePath, name)
                                        val byteArray = ByteArray(2048)
                                        mInputSteam = t.byteStream()
                                        mOutputStream = FileOutputStream(file)
                                        while (true) {
                                            val read = mInputSteam.read(byteArray)
                                            if (read == -1) break
                                            mOutputStream.write(byteArray, 0, read)
                                        }
                                        mOutputStream.flush()
                                        val intent = Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE)
                                        val uri = Uri.fromFile(file)
                                        intent.data = uri
                                        activity.sendBroadcast(intent)//这个广播的目的就是更新图库，发了这个广播进入相册就可以找到你保存的图片了！，记得要传你更新的file哦
                                        println("${filePath}----------------------------下载完成")
                                        // ToastUtil.showShort(activity, "下载完成")
                                        val msg = Message.obtain()
                                        msg.obj = "下载完成"
                                        handler.sendMessage(msg)
                                    } catch (e: Exception) {
                                        Timber.e(e)
                                        throw DownloadException(e.toString())
                                    }
                                }

                            })
                    }
                }.start()

            }

            override fun onRequestPermissionFailure(permissions: MutableList<String>?) {
                val msg = Message.obtain()
                msg.obj = "请求被拒绝"
                handler.sendMessage(msg)
            }

            override fun onRequestPermissionFailureWithAskNeverAgain(permissions: MutableList<String>?) {

                val msg = Message.obtain()
                msg.obj = "请求被拒绝, 如需要继续请进入设置页面打开该权限"
                handler.sendMessage(msg)
            }

        }, RxPermissions(activity))




        PermissionUtil.externalStorage(object : PermissionUtil.RequestPermission {
            override fun onRequestPermissionSuccess() {

            }

            override fun onRequestPermissionFailure(permissions: MutableList<String>?) {

            }

            override fun onRequestPermissionFailureWithAskNeverAgain(permissions: MutableList<String>?) {


            }

        }, RxPermissions(activity))

    }

}