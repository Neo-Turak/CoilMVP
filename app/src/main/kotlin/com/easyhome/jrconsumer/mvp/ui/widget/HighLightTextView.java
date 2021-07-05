package com.easyhome.jrconsumer.mvp.ui.widget;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;

import androidx.core.text.HtmlCompat;

import com.easyhome.jrconsumer.R;
import com.easyhome.jrconsumer.mvp.ui.widget.ruler.utils.DisplayUtils;

/**
 * @author Hugo
 * @time 2021年3月9日09:48:34
 */
public class HighLightTextView extends androidx.appcompat.widget.AppCompatTextView {

  private static  final String Tag=HighLightTextView.class.getSimpleName();
  private String h_text;
  private int h_color;
  private String normal_text;
  private int normal_color;
  private int size;
  private TextPaint mPaint;
  private Rect mBound;
  private StaticLayout layout;

  public HighLightTextView(Context context){
        super(context);
    }

    public HighLightTextView(Context context, AttributeSet attrs){
      super(context,attrs);
      TypedArray ta=context.obtainStyledAttributes(attrs, R.styleable.HighLightTextView);
        h_text=ta.getString(R.styleable.HighLightTextView_highlight_text);
       h_color=ta.getColor(R.styleable.HighLightTextView_highlight_color,Color.RED);
       normal_text=ta.getString(R.styleable.HighLightTextView_android_text);
       normal_color=ta.getColor(R.styleable.HighLightTextView_android_textColor,Color.WHITE);
       size=ta.getDimensionPixelSize(R.styleable.HighLightTextView_android_textSize, DisplayUtils.dip2px(14F));
       mPaint=new TextPaint();
       mPaint.setTextSize(size);
       mBound=new Rect();
       mPaint.getTextBounds(h_text+normal_text,0,(h_text+normal_text).length(),mBound);
      Spanned last=HtmlCompat.fromHtml("<font color='"+h_color+"'>"+h_text+"</font>"+normal_text,HtmlCompat.FROM_HTML_MODE_COMPACT);

      layout=new StaticLayout(last,mPaint, getWidth(), Layout.Alignment.ALIGN_CENTER,1,0,false);
       ta.recycle();
    }

    public HighLightTextView(Context context, AttributeSet attrs, int defStyle){
      super(context,attrs,defStyle);
    }

    @Override
    protected  void  onDraw(Canvas canvas){
      layout.draw(canvas);
      canvas.save();
      canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);


    }
}
