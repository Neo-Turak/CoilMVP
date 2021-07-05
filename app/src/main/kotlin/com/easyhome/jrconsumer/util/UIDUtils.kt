package com.easyhome.jrconsumer.util

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.TelephonyManager
import androidx.core.app.ActivityCompat
import java.lang.StringBuilder

/**
 * @author Hugo
 * @time  5/8/2021
 * @Desciption TODO 文件描述
 * Think Twice，Code Once。
 */
class UIDUtils {
    /**
     * @param context
     * @return UUID
     *
     */
    fun PUID(context: Context):String{
        val deviceId=StringBuilder()
        val tm=context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            //如果版本是O
        if (ActivityCompat.checkSelfPermission(context,Manifest.permission.READ_PHONE_STATE)==PackageManager.PERMISSION_GRANTED){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            if (!tm.imei.isNullOrEmpty()) {
                deviceId.append("imei")
                deviceId.append(tm.imei)
                return deviceId.toString()
            }
        }else{
            if (!tm.deviceId.isNullOrEmpty()){
                deviceId.append("deviceId")
                deviceId.append(tm.deviceId)
                return deviceId.toString()
            }
        }
    }else{
        deviceId.append("sim")
        deviceId.append(tm.simSerialNumber)
        return deviceId.toString()
    }
       return ""
    }

  /*  fun GUUID(context:Context):String{
        context.
    }*/
}