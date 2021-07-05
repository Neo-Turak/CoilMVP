package com.easyhome.jrconsumer.app.base;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.integration.AppManager;
import com.easyhome.jrconsumer.app.utils.PageLoadingUtils;


public interface IView extends com.jess.arms.mvp.IView {

    BaseActivity getMyself();

    @Override
    default void showLoading() {
        if (AppManager.getAppManager().getTopActivity().equals(getMyself())) {
            PageLoadingUtils.INSTANCE.showLoading(getMyself());
        }
    }

    @Override
    default void hideLoading() {
        PageLoadingUtils.INSTANCE.dismissLoading();
    }

    void showNetError();
}
