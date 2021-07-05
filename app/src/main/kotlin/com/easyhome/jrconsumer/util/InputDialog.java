package com.easyhome.jrconsumer.util;

import android.app.Dialog;
import android.content.Context;
import androidx.annotation.NonNull;
import android.view.*;
import com.easyhome.jrconsumer.R;

/**
 * @创建人 lin
 * @创建时间 2020/7/29
 * @描述
 */
public class InputDialog extends Dialog {
    public Context mContext;
    public View mRootView;

    public InputDialog(@NonNull Context context) {
        super(context);
//        super(context, R.style.CustomDialog);
        init(context);
    }

    public void init(Context context) {
        mContext = context;
        mRootView = LayoutInflater.from(context).inflate(R.layout.dialog_input, null);
        setContentView(mRootView);
        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(params);
        window.setGravity(Gravity.BOTTOM);
    }

}
