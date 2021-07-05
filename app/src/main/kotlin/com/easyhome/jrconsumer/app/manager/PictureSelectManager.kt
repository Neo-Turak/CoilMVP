package com.easyhome.jrconsumer.app.manager

import android.app.Activity
import androidx.fragment.app.Fragment
import com.easyhome.jrconsumer.util.runtimepermissions.PermissionsManager
import com.easyhome.jrconsumer.util.runtimepermissions.PermissionsResultAction
import com.luck.picture.lib.PictureSelector
import com.luck.picture.lib.config.PictureConfig
import com.luck.picture.lib.config.PictureMimeType
import com.luck.picture.lib.entity.LocalMedia
import es.dmoral.toasty.Toasty

/**
 * Created by EVE
 * Time 2018/8/22  下午4:57
 *
 * PictureSelectManager
 **/
object PictureSelectManager {

    /**
     * 带相机 Activity
     */
    fun selectPicture(activity: Activity, list: List<LocalMedia>?, maxSelectNum: Int = 9) {
        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, arrayOf(
            android.Manifest.permission.CAMERA,android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        ),object : PermissionsResultAction(){
            override fun onGranted() {
                return PictureSelector.create(activity)
                    .openGallery(PictureMimeType.ofImage())
                    .imageEngine(GlideEngine.createGlideEngine())
                    .selectionMode(PictureConfig.MULTIPLE) // 多选 or 单选
                    .maxSelectNum(maxSelectNum)
                    .isPreviewImage(true)   // 是否可预览图片 true or false
                    .cutOutQuality(50)     // 图片裁剪质量,默认无损
                    .imageSpanCount(4) // 每行个数
                    .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                    .isEnableCrop(false)   // 是否裁剪 true or false
                    .isCompress(true)// 是否压缩 true or false
                    .minimumCompressSize(1024) // 小于 100kb 的图片不压缩
                    .selectionData(list)
                    .forResult(PictureConfig.CHOOSE_REQUEST)
            }

            override fun onDenied(permission: String?) {
                Toasty.normal(activity,"获取权限失败，请在设置里授权！",Toasty.LENGTH_SHORT).show()
            }

        })
    }

    /**
     * 带相机 Activity 单选 用在头像
     */
    fun selectPictureS(activity: Activity) {
        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, arrayOf(
            android.Manifest.permission.CAMERA,android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        ),object : PermissionsResultAction(){
            override fun onGranted() {
                return PictureSelector.create(activity)
                    .openGallery(PictureMimeType.ofImage())
                    .imageEngine(GlideEngine.createGlideEngine())
                    .selectionMode(PictureConfig.SINGLE) // 多选 or 单选
                    .isPreviewImage(true) // 是否可预览图片 true or false
                    .cutOutQuality(50) // 图片裁剪质量,默认无损
                    .imageSpanCount(4) // 每行个数
                    .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                    .isEnableCrop(true)// 是否裁剪 true or false
                    .isCompress(true)// 是否压缩 true or false
                    .minimumCompressSize(1024) // 小于 100kb 的图片不压缩
                    .forResult(PictureConfig.CHOOSE_REQUEST)
            }

            override fun onDenied(permission: String?) {
                Toasty.normal(activity,"获取权限失败，请在设置里授权！",Toasty.LENGTH_SHORT).show()
            }
        })
    }

    /**
     * 视频
     */
    fun selectVideo(activity: Activity,list: List<LocalMedia>) {
        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, arrayOf(
            android.Manifest.permission.CAMERA,android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        ),object : PermissionsResultAction() {
            override fun onGranted() {
                return PictureSelector.create(activity)
                    .openGallery(PictureMimeType.ofVideo())
                    .isCompress(true)
                    .isPreviewVideo(true)// 是否可预览视频 true or false
                    .selectionMode(PictureConfig.MULTIPLE)
                    .cutOutQuality(50) // 图片裁剪质量,默认无损
                    .imageSpanCount(4) // 每行个数
                    .isOpenClickSound(true) // 是否开启点击声音
                    .recordVideoSecond(15)//视频秒数录制 默认 60s int
                    .videoQuality(1)// 视频录制质量 0 or 1 int
                    .selectionData(list)
                    .videoMaxSecond(15)
                    .forResult(PictureConfig.REQUEST_CAMERA)
            }
            override fun onDenied(permission: String?) {
                Toasty.normal(activity, "获取权限失败，请在设置里授权！", Toasty.LENGTH_SHORT).show()
            }
        })
    }


    /**
     * 语音
     */
    fun selectAudio(activity: Activity) {
        return PictureSelector.create(activity)
            .openGallery(PictureMimeType.ofAudio())
            .isCompress(true)
            .selectionMode(PictureConfig.SINGLE)//多选 or 单选 PictureConfig.MULTIPLE or PictureConfig.SINGLE
            .isEnablePreviewAudio(true) // 是否可播放音频 true or false
            .cutOutQuality(50) // 图片裁剪质量,默认无损
            .imageSpanCount(4) // 每行个数
            .isOpenClickSound(true)// 是否开启点击声音 true or false
            .recordVideoSecond(60)//视频秒数录制 默认 60s int
            .forResult(PictureConfig.CHOOSE_REQUEST)
    }

    /**
     * 带相机 Fragment
     */
    fun selectPicture(activity: Activity) {
        return PictureSelector.create(activity)
            .openGallery(PictureMimeType.ofImage())
            .imageEngine(GlideEngine.createGlideEngine())
            .isCompress(true)
            .selectionMode(PictureConfig.MULTIPLE) // 多选 or 单选
            .isPreviewImage(true) // 是否可预览图片 true or false
            .cutOutQuality(50) // 图片裁剪质量,默认无损
            .imageSpanCount(4) // 每行个数
            .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
            .isEnableCrop(false)// 是否裁剪 true or false
            .minimumCompressSize(1024) // 小于 100kb 的图片不压缩
            .forResult(PictureConfig.CHOOSE_REQUEST)
    }

    /**
     * 无相机 Fragment
     */
    fun selectPictureNO(activity: Activity) {
        PermissionsManager.getInstance().requestPermissionsIfNecessaryForResult(activity, arrayOf(
            android.Manifest.permission.CAMERA,
            android.Manifest.permission.READ_EXTERNAL_STORAGE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE
        ), object : PermissionsResultAction() {
            override fun onGranted() {
                return PictureSelector.create(activity)
                    .openGallery(PictureMimeType.ofImage())
                    .isCompress(true)
                    .imageEngine(GlideEngine.createGlideEngine())
                    .selectionMode(PictureConfig.SINGLE) // 多选 or 单选
                    .isPreviewImage(true) // 是否可预览图片 true or false
                    .cutOutQuality(50) // 图片裁剪质量,默认无损
                    .imageSpanCount(4) // 每行个数
                    .withAspectRatio(1, 1)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
                    .isEnableCrop(true)// 是否裁剪 true or false
                    .isCamera(false)
                    .minimumCompressSize(1024) // 小于 100kb 的图片不压缩
                    .forResult(PictureConfig.CHOOSE_REQUEST)
            }
            override fun onDenied(permission: String?) {
                Toasty.normal(activity, "获取权限失败，请在设置里授权！", Toasty.LENGTH_SHORT).show()
            }
        })
    }



    /**
     * 带相机 Fragment
     */
    fun selectPicture(fragment: Fragment) {
        return PictureSelector.create(fragment)
            .openGallery(PictureMimeType.ofImage())
            .imageEngine(GlideEngine.createGlideEngine())
            .isCompress(true)
            .selectionMode(PictureConfig.SINGLE) // 多选 or 单选
            .isPreviewImage(true) // 是否可预览图片 true or false
            .cutOutQuality(50) // 图片裁剪质量,默认无损
            .imageSpanCount(4) // 每行个数
            .withAspectRatio(3, 4)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
            .isEnableCrop(true)// 是否裁剪 true or false
            .minimumCompressSize(1024) // 小于 100kb 的图片不压缩
            .forResult(PictureConfig.CHOOSE_REQUEST)
    }

    /**
     * 无相机 Fragment
     */
    fun selectPictureNO(fragment: Fragment) {
        return PictureSelector.create(fragment)
            .openGallery(PictureMimeType.ofImage())
            .imageEngine(GlideEngine.createGlideEngine())
            .isCompress(true)
            .selectionMode(PictureConfig.SINGLE) // 多选 or 单选
            .isPreviewImage(true) // 是否可预览图片 true or false
            .cutOutQuality(50) // 图片裁剪质量,默认无损
            .imageSpanCount(4) // 每行个数
            .withAspectRatio(3, 4)// 裁剪比例 如16:9 3:2 3:4 1:1 可自定义
            .isEnableCrop(true)// 是否裁剪 true or false
            .isCamera(false)
            .minimumCompressSize(100) // 小于 100kb 的图片不压缩
            .forResult(PictureConfig.CHOOSE_REQUEST)
    }
}