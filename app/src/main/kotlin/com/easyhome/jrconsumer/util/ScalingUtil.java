package com.easyhome.jrconsumer.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;

/**
 * @创建人 lin
 * @创建时间 2020/11/9
 * @描述 图片缩放工具类
 */
public class ScalingUtil {

    public static Bitmap resizeImage(Bitmap bitmap,float density){ //按照比例   1 - 0.1
        Bitmap bitmapOrg=bitmap;
        int width = bitmapOrg.getWidth();
        int height = bitmapOrg.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(density, density);
        bitmapOrg = Bitmap.createBitmap(bitmapOrg, 0, 0, width,height, matrix, true);
        return bitmapOrg;
    }



    public static Bitmap resizeImage(Bitmap bitmap, int w, int h) { //制定尺寸缩放
        Bitmap BitmapOrg = bitmap;
        float scaleWidth = 0, scaleHeight = 0;
        int width = BitmapOrg.getWidth();
        int height = BitmapOrg.getHeight();
        if (w == 1 || w == -1) {
            scaleWidth = w;
        } else {
            scaleWidth = ((float) w) / width;
        }


        if (h == 1 || h == -1) {
            scaleHeight = h;
        } else {
            scaleHeight = ((float) h) / height;
        }
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        BitmapOrg = Bitmap.createBitmap(BitmapOrg, 0, 0, width,
                height, matrix, true);
        return BitmapOrg;
    }
}
