package com.easyhome.jrconsumer.util;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;

import java.util.Hashtable;
import java.util.Random;

/**
 * @创建人 lin
 * @创建时间 2019/11/12
 * @描述
 */
public class MUtil {

    /**
     * 产生4位随机数(0000-9999)
     * @return 4位随机数
     */
    public static String getFourRandom(){
        Random random = new Random();
        String fourRandom = random.nextInt(100000) + "";
        int randLength = fourRandom.length();
        if(randLength<5){
            for(int i=1; i<=5-randLength; i++){
                fourRandom = "0" + fourRandom ;
            }
        }
        return fourRandom;
    }



    public static Bitmap createVideoThumbnail(String filePath,int kind){
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try {
            if (filePath.startsWith("http://")
                    || filePath.startsWith("https://")
                    || filePath.startsWith("widevine://")) {
                retriever.setDataSource(filePath,new Hashtable<String,String>());
            }else {
                retriever.setDataSource(filePath);
            }
            bitmap =retriever.getFrameAtTime(-1);
        } catch (IllegalArgumentException ex) {
            // Assume this is a corrupt video file
            ex.printStackTrace();
        } catch (RuntimeException ex) {
            // Assume this is a corrupt video file.
            ex.printStackTrace();
        } finally {
            try {
                retriever.release();
            } catch (RuntimeException ex) {
                // Ignore failures while cleaning up.
                ex.printStackTrace();
            }
        }

        if (bitmap==null)return null;

        if (kind== MediaStore.Images.Thumbnails.MINI_KIND) {
            // Scale down the bitmap if it's too large.
            int width= bitmap.getWidth();
            int height= bitmap.getHeight();
            int max =Math.max(width, height);
            if(max >512) {
                float scale=512f / max;
                int w =Math.round(scale * width);
                int h =Math.round(scale * height);
                bitmap = Bitmap.createScaledBitmap(bitmap,w, h, true);
            }
        } else if (kind== MediaStore.Images.Thumbnails.MICRO_KIND) {
            bitmap = ThumbnailUtils.extractThumbnail(bitmap,
                    96,
                    96,
                    ThumbnailUtils.OPTIONS_RECYCLE_INPUT);
        }
        return bitmap;
    }

}
