package com.easyhome.jrconsumer.app.manager;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import com.easyhome.jrconsumer.mvp.extension.LoginInfo;
import com.jess.arms.integration.AppManager;
import com.jess.arms.integration.cache.Cache;
import com.jess.arms.utils.ArmsUtils;
import com.jess.arms.utils.DeviceUtils;
import com.easyhome.jrconsumer.api.Api;
import com.easyhome.jrconsumer.app.utils.SettingHelper;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 用户信息管理类
 **/
public class UserInfoManager {

    private static final String KEY_USER_INFO = "KEY_USER_INFO_CONSUMER";

    private static volatile UserInfoManager instance;
    private boolean isLogin = false;

    private UserInfoManager() {
    }

    public static UserInfoManager getInstance() {
        if (instance == null) {
            synchronized (UserInfoManager.class) {
                if (instance == null) {
                    instance = new UserInfoManager();
                }
            }
        }
        return instance;
    }

    /**
     * 获取设备唯一标识
     */
    public String getUUID() {
        Cache<String, Object> cache = ArmsUtils.obtainAppComponentFromContext(AppManager.getAppManager().getApplication()).extras();
        Object uuidOfCache = cache.get(Api.KEY_UUID);
        if (uuidOfCache != null) {
            return uuidOfCache.toString();
        }

        String uuidOfData = SettingHelper.getInstance().getString(Api.KEY_UUID, null);
        if (uuidOfData != null) {
            cache.put(Api.KEY_UUID, uuidOfData);
            return uuidOfData;
        }

        String uuid = DeviceUtils.getUniquePsuedoID(AppManager.getAppManager().getApplication());
        cache.put(Api.KEY_UUID, uuid);
        SettingHelper.getInstance().saveString(Api.KEY_UUID, uuid);
        return uuid;
    }

    /**
     * @return String
     * @Title: getIpAddress
     * @Description: 获取设备ip地址
     */
    public String getIpAddress() {
        try {
            for (Enumeration<NetworkInterface> enNetI = NetworkInterface.getNetworkInterfaces(); enNetI
                    .hasMoreElements(); ) {
                NetworkInterface netI = enNetI.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = netI.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (inetAddress instanceof Inet4Address && !inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 保存用户信息
     */
    public void saveUserInfo(LoginInfo userInfo) {
        if (userInfo == null) {
            return;
        }
        ArmsUtils.obtainAppComponentFromContext(AppManager.getAppManager().getApplication()).extras().put(KEY_USER_INFO, userInfo);
        SettingHelper.getInstance().saveObj(KEY_USER_INFO, userInfo);
    }

    /**
     * 清理用户数据
     */
    public void cleanUserInfo() {
        Cache<String, Object> cache = ArmsUtils.obtainAppComponentFromContext(AppManager.getAppManager().getApplication()).extras();
        if (cache.get(KEY_USER_INFO) != null) {
            cache.remove(KEY_USER_INFO);
        }
        SettingHelper.getInstance().saveObj(KEY_USER_INFO, null);
    }

    /**
     * 获取用户信息
     */
    public LoginInfo getUserInfo() {
        Cache<String, Object> cache = ArmsUtils.obtainAppComponentFromContext(AppManager.getAppManager().getApplication()).extras();
        Object userInfoCache = cache.get(KEY_USER_INFO);
        if (userInfoCache != null && userInfoCache instanceof LoginInfo) {
            return (LoginInfo) userInfoCache;
        }

        LoginInfo userInfo = SettingHelper.getInstance().getObj(KEY_USER_INFO, LoginInfo.class);
        if (userInfo != null) {
            cache.put(KEY_USER_INFO, userInfo);
            return userInfo;
        }

        return null;
    }

    /**
     * 检验用户是否登录
     *
     * @return
     */
    public boolean checkLogin() {
        return getUserInfo() != null && getUserToken() != null;
    }

    /**
     * 检验用户是否登录
     *
     * @return
     */
    public boolean isLogin() {
        return isLogin;
    }

    /**
     * 检验用户是否登录
     *
     * @return
     */
    public boolean setLogin(boolean b) {
        return isLogin = b;
    }

    /**
     * 获取用户Token
     */
    public String getUserToken() {
        if (getUserInfo() != null) {
            return getUserInfo().getToken();
        } else {
            return "";
        }
    }

    /**
     * 获取用户ID
     */
    public String getUserId() {
        if (getUserInfo() != null) {
            return getUserInfo().getUserId();
        } else {
            return "";
        }
    }

    /**
     * 获取53访客ID
     *
     * @return
     */
    public String getGuestId() {
        if (getUserInfo() != null) {
            return getUserInfo().getGuestId();
        } else {
            return "";
        }
    }

    /**
     * 用户头像
     */
    /*public String getHeadPortraits() {
        if (getUserInfo() != null) {
            return getUserInfo().getHeadPortraits();
        } else {
            return "";
        }
    }*/


    /*public String getConsumerId() {
        if (getUserInfo() != null) {
            return getUserInfo().getConsumerId();
        } else {
            return "";
        }
    }*/

    /**
     * 获取用户手机号
     */
   /* public String getUserPhone() {
        if (getUserInfo() != null) {
            return getUserInfo().getPhone();
        } else {
            return "";
        }
    }*/

    /**
     * 获取渠道号
     *
     * @return
     */
    public String getChannel(Context ctx) {
        String resultData = null;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        resultData = applicationInfo.metaData.getString("UMENG_CHANNEL");
                    }
                }

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return resultData;
    }

}
