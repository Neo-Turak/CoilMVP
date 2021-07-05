package com.easyhome.jrconsumer.mvp.ui.widget;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

import com.easyhome.jrconsumer.R;
import com.easyhome.jrconsumer.mvp.ui.widget.popup.BasePopup;

public class LoadingPopupView extends BasePopup<LoadingPopupView> {


    public static LoadingPopupView initView(Context context){
        return new LoadingPopupView(context);
    }

    private LoadingPopupView(Context context){
        setContext(context);
    }


    @Override
    protected void initAttributes() {
        setContentView(R.layout.layout_loading,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.PopupAnimaFade)
                .setFocusAndOutsideEnable(true);
    }

    @Override
    protected void initViews(View view, LoadingPopupView popup) {

    }
}
