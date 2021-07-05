package com.easyhome.jrconsumer.app;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.easyhome.jrconsumer.R;
import com.gyf.immersionbar.ImmersionBar;

import java.util.Objects;

import timber.log.Timber;

/*import com.gyf.barlibrary.ImmersionBar;
import com.gyf.barlibrary.KeyboardPatch;*/

/**
 * ================================================
 * 展示 {@link Application.ActivityLifecycleCallbacks} 的用法
 * <p>
 * Created by MVPArmsTemplate
 * <a href="mailto:jess.yan.effort@gmail.com">Contact me</a>
 * <a href="https://github.com/JessYanCoding">Follow me</a>
 * ================================================
 */
@SuppressWarnings("deprecation")
public class ActivityLifecycleCallbacksImpl implements Application.ActivityLifecycleCallbacks {

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        Timber.w(activity + " - onActivityCreated");
        // 所有子类都将继承这些相同的属性,请在设置界面之后设置
        if (!activity.toString().contains("com.yalantis.ucrop.UCropActivity")) {
            if (!activity.toString().contains("com.yalantis.ucrop.PictureMultiCuttingActivity")) {

                if (!activity.toString().contains("H5PayActivity")) {
                    ImmersionBar.with(activity)
                            .keyboardEnable(true,WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN)
                            .statusBarDarkFont(true, 0.8f)
                            //原理：如果当前设备支持状态栏字体变色，会设置状态栏字体为黑色，
                            // 如果当前设备不支持状态栏字体变色，会使当前状态栏加上透明度，否则不执行透明度
                            .init();
                }
            }
        }
    }

    @Override
    public void onActivityStarted(Activity activity) {
        //全局设置  如果页面有输入框防止软键盘覆盖输入框
     //   KeyboardPatch.patch(activity, activity.findViewById(android.R.id.content)).enable(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        Timber.w(activity + " - onActivityStarted");
        if (!activity.getIntent().getBooleanExtra("isInitToolbar", false)) {
            //由于加强框架的兼容性,故将 setContentView 放到 onActivityCreated 之后,onActivityStarted 之前执行
            //而 findViewById 必须在 Activity setContentView() 后才有效,所以将以下代码从之前的 onActivityCreated 中移动到 onActivityStarted 中执行
            activity.getIntent().putExtra("isInitToolbar", true);
            //这里全局给Activity设置toolbar和title,你想象力有多丰富,这里就有多强大,以前放到BaseActivity的操作都可以放到这里
            if (activity.findViewById(R.id.toolbar) != null) {
                if (activity instanceof AppCompatActivity) {
                    ((AppCompatActivity) activity).setSupportActionBar(activity.findViewById(R.id.toolbar));
                    Objects.requireNonNull(((AppCompatActivity) activity).getSupportActionBar()).setDisplayShowTitleEnabled(false);
                } else {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        activity.setActionBar(activity.findViewById(R.id.toolbar));
                        Objects.requireNonNull(activity.getActionBar()).setDisplayShowTitleEnabled(false);
                    }
                }
            }
        }
    }

    @Override
    public void onActivityResumed(Activity activity) {
    }

    @Override
    public void onActivityPaused(Activity activity) {
    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
//        Timber.w(activity + " - onActivityDestroyed");
        //横竖屏切换或配置改变时, Activity 会被重新创建实例, 但 Bundle 中的基础数据会被保存下来,移除该数据是为了保证重新创建的实例可以正常工作
        activity.getIntent().removeExtra("isInitToolbar");
        // 必须调用该方法，防止内存泄漏
   //     ImmersionBar.with(activity).destroy();
    }

}
