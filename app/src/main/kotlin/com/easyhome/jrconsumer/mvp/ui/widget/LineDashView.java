package com.easyhome.jrconsumer.mvp.ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.easyhome.jrconsumer.R;

/**
 * Created by zhanghe on 2019/8/3.
 * 水平或者垂直虚线
 */

public class LineDashView extends View {

    private Paint mPaint;
    private int height;
    private int width;
    private Path mPath;
    private float orientation;

    public LineDashView(Context context) {
        this(context,null);
    }

    public LineDashView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LineDashView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final TypedArray a = context.obtainStyledAttributes(
                attrs, R.styleable.LineDashView, defStyleAttr,0);

        float dashGap = a.getDimension(R.styleable.LineDashView_dashGap, 0);
        float dashWidth = a.getDimension(R.styleable.LineDashView_dashWidth, 0);
        orientation = a.getInt(R.styleable.LineDashView_line_orientation, 0);
        ColorStateList colorStateList = a.getColorStateList(R.styleable.LineDashView_color);

        a.recycle();

        colorStateList = colorStateList != null ? colorStateList : ColorStateList.valueOf(0xFF000000);
        int lineColor = colorStateList.getColorForState(getDrawableState(), 0);

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(lineColor);
        mPaint.setStyle(Paint.Style.STROKE);

        DashPathEffect e = null;
        if (dashWidth > 0) {
            e = new DashPathEffect(new float[] { dashWidth, dashGap }, 0);
        }
        mPaint.setPathEffect(e);
        mPath = new Path();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        mPaint.setStrokeWidth(width);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (orientation == 0){//水平
            mPath.moveTo(0,0);
            mPath.lineTo(width,0);
        }else if (orientation == 1){//垂直
            mPath.moveTo(0,0);
            mPath.lineTo(0,height);
        }
        canvas.drawPath(mPath,mPaint);
    }
}