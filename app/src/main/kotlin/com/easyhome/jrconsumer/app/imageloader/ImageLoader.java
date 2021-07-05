package com.easyhome.jrconsumer.app.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;

public class ImageLoader {

    private static final RequestOptions requestOptions=RequestOptions.diskCacheStrategyOf(DiskCacheStrategy.ALL);
   private static final DrawableCrossFadeFactory drawableCrossFadeFactory
            = new DrawableCrossFadeFactory.Builder(0).setCrossFadeEnabled(true).build();

    public static void load(Context context, String url, ImageView iv) {
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                //让Glide既缓存全尺寸图片，下次在任何ImageView中加载图片的时候，全尺寸的图片将从缓存中取出，重新调整大小，然后缓存
                .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
              //  .transform(new CircleTransform())
             //   .crossFade()
                .into(iv);
    }

    public static void load(Context context, String url, ImageView iv, int placeholder) {
        Glide.with(context)
                .load(url)
                .apply(requestOptions)
              //  .diskCacheStrategy(DiskCacheStrategy.ALL)//让Glide既缓存全尺寸图片，下次在任何ImageView中加载图片的时候，全尺寸的图片将从缓存中取出，重新调整大小，然后缓存
                .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
          //      .placeholder(placeholder)
                .into(iv);
    }

    public static void load(Context context, int resId, ImageView iv) {
        Glide.with(context)
                .load(resId)
                .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                .into(iv);
    }

    /**
     * 需要在子线程执行
     *
     * @param context
     * @param url
     * @return
     */
    public static Bitmap load(Context context, String url) {
        try {
            return Glide.with(context)
                    .asBitmap()
                    .load(url)
                    .apply(requestOptions)
                    .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void loadCircle(Context context, int resId, ImageView iv) {
       /* Glide.with(context)
                .load(resId)
               // .transition(new CircleTransform())
                .transition(DrawableTransitionOptions.with(drawableCrossFadeFactory))
                .transform(new CenterCrop(),new CircleTransform())
                .into(iv);*/
    }
}
