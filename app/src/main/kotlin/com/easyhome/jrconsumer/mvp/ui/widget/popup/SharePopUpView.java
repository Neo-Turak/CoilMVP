package com.easyhome.jrconsumer.mvp.ui.widget.popup;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.easyhome.jrconsumer.R;

import java.util.Map;

import timber.log.Timber;


public class SharePopUpView extends BasePopup<SharePopUpView> {

    private LinearLayout wechat, wechat_moment,url;
    private Context mContext;
    private Map<String,String> map;

    private SharePopUpView(Context context,Map<String,String> map){
       setContext(context);
       this.mContext=context;
       this.map=map;
    }

  public  static SharePopUpView create(Context c,Map<String,String> m){
        return  new SharePopUpView(c,m);
    }


    @Override
    protected void initAttributes() {
        setContentView(R.layout.share_layout_2,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.PopupAnimaFade)
                .setFocusAndOutsideEnable(true);
    }

    @Override
    protected void initViews(View view, SharePopUpView popup) {
            wechat =findViewById(R.id.wechat_ll);
            wechat_moment =findViewById(R.id.wechat_moment_ll);
            url=findViewById(R.id.copy_url_ll);

            url.setOnClickListener(v -> {
                ClipboardManager manager= (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData data;
                data=ClipData.newUri(mContext.getContentResolver(),null, Uri.parse(map.get("url")));
                Timber.e("连接->"+map.get("url"));
                manager.setPrimaryClip(data);
                Toast.makeText(mContext,"链接已复制",Toast.LENGTH_SHORT).show();
                SharePopUpView.super.dismiss();
            });

    }
}
