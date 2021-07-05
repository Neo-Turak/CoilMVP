package com.easyhome.jrconsumer.mvp.ui.widget;

import android.content.Context;
import androidx.core.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ScrollView;

public class CustomScrollView extends NestedScrollView {
    // 这个值控制可以把ScrollView包裹的控件拉出偏离顶部或底部的距离。
    private static final int MAX_OVER_SCROLL_Y = 48;
    private int newMaxOverScrollY;
    double ratio = 1d;

    public CustomScrollView(Context context) {
        super(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public CustomScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }



    private void init(Context context) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float density = metrics.density;
        newMaxOverScrollY = (int) (density * MAX_OVER_SCROLL_Y);
        //false:隐藏ScrollView的滚动条。
        this.setVerticalScrollBarEnabled(false);
        //不管装载的控件填充的数据是否满屏，都允许橡皮筋一样的弹性回弹。
        this.setOverScrollMode(ScrollView.OVER_SCROLL_ALWAYS);
    }

    @Override
    protected boolean overScrollBy(int deltaX, int deltaY, int scrollX,
                                   int scrollY, int scrollRangeX, int scrollRangeY,
                                   int maxOverScrollX, int maxOverScrollY, boolean isTouchEvent) {
        return super.overScrollBy(deltaX, (int) (deltaY * ratio), scrollX, scrollY,
                scrollRangeX, scrollRangeY, maxOverScrollX, newMaxOverScrollY,
                isTouchEvent);
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        // Not consumed means it wasn't handled because ScrollView
        // doesn't take over scrolling bounds into scroll range,
        // so we fling it ourselves to get it bounce back
        if (getOverScrollMode() == OVER_SCROLL_ALWAYS && !consumed) {
            fling((int) velocityY);
            return true;
        } else {
            return super.dispatchNestedFling(velocityX, velocityY, consumed);
        }
    }
}