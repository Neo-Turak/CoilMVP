package com.easyhome.jrconsumer.mvp.ui.widget.popup;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.easyhome.jrconsumer.R;

import java.util.ArrayList;

public class PricePopUpView extends BasePopup<PricePopUpView> {

    private Button confirm, reset;
    private TextView price1, price2, price3, price4, price5, price6;

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;

        if (list.contains("0-100元/㎡")){
            price1.setTextColor(Color.parseColor("#0185FF"));
            price1.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("100-150元/㎡")){
            price2.setTextColor(Color.parseColor("#0185FF"));
            price2.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }

        if (list.contains("150-200元/㎡")){
            price3.setTextColor(Color.parseColor("#0185FF"));
            price3.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("200-300元/㎡")){
            price4.setTextColor(Color.parseColor("#0185FF"));
            price4.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("300-500元/㎡")){
            price5.setTextColor(Color.parseColor("#0185FF"));
            price5.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("500元/㎡以上")){
            price6.setTextColor(Color.parseColor("#0185FF"));
            price6.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
    }

    private ArrayList<String> list;

    public static PricePopUpView create(Context context, ArrayList<String> l) {
        return new PricePopUpView(context,l);
    }

    private PricePopUpView(Context context, ArrayList<String> l) {
        setContext(context);
        list= l;
    }

    @Override
    protected void initAttributes() {
        setContentView(R.layout.pick_price_view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.PopupAnimaFade)
                .setFocusAndOutsideEnable(true);
    }

    @Override
    protected void initViews(View view, PricePopUpView popup) {
        price1 = findViewById(R.id.price_1_tv);
        price2 = findViewById(R.id.price_2_tv);
        price3 = findViewById(R.id.price_3_tv);
        price4 = findViewById(R.id.price_4_tv);
        price5 = findViewById(R.id.price_5_tv);
        price6 = findViewById(R.id.price_6_tv);

        if (list.contains("0-100元/㎡")){
            price1.setTextColor(Color.parseColor("#0185FF"));
            price1.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("100-150元/㎡")){
            price2.setTextColor(Color.parseColor("#0185FF"));
            price2.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }

        if (list.contains("150-200元/㎡")){
            price3.setTextColor(Color.parseColor("#0185FF"));
            price3.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("200-300元/㎡")){
            price4.setTextColor(Color.parseColor("#0185FF"));
            price4.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("300-500元/㎡")){
            price5.setTextColor(Color.parseColor("#0185FF"));
            price5.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("500元/㎡以上")){
            price6.setTextColor(Color.parseColor("#0185FF"));
            price6.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }


        confirm=findViewById(R.id.confirm_btn);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            PricePopUpView.super.dismiss();
            }
        });
        reset=findViewById(R.id.reset_btn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                price1.setTextColor(Color.parseColor("#7E7E7E"));
                price1.setBackgroundColor(Color.parseColor("#FAFAFA"));
                price2.setTextColor(Color.parseColor("#7E7E7E"));
                price2.setBackgroundColor(Color.parseColor("#FAFAFA"));
                price3.setTextColor(Color.parseColor("#7E7E7E"));
                price3.setBackgroundColor(Color.parseColor("#FAFAFA"));
                price4.setTextColor(Color.parseColor("#7E7E7E"));
                price4.setBackgroundColor(Color.parseColor("#FAFAFA"));
                price5.setTextColor(Color.parseColor("#7E7E7E"));
                price5.setBackgroundColor(Color.parseColor("#FAFAFA"));
                price6.setTextColor(Color.parseColor("#7E7E7E"));
                price6.setBackgroundColor(Color.parseColor("#FAFAFA"));
                list.clear();
            }
        });

        price1.setOnClickListener(view1 -> {
            if (price1.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                list.add(price1.getText().toString());
                price1.setTextColor(Color.parseColor("#0185FF"));
                price1.setBackgroundColor(Color.parseColor("#E4F2FF"));
            } else {
                list.remove(price1.getText().toString());
                price1.setTextColor(Color.parseColor("#7E7E7E"));
                price1.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        });
        price2.setOnClickListener(view12 -> {
            if (price2.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                list.add(price2.getText().toString());
                price2.setTextColor(Color.parseColor("#0185FF"));
                price2.setBackgroundColor(Color.parseColor("#E4F2FF"));
            } else {
                list.remove(price2.getText().toString());
                price2.setTextColor(Color.parseColor("#7E7E7E"));
                price2.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        });
        price3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (price3.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                    list.add(price3.getText().toString());
                    price3.setTextColor(Color.parseColor("#0185FF"));
                    price3.setBackgroundColor(Color.parseColor("#E4F2FF"));
                } else {
                    list.remove(price3.getText().toString());
                    price3.setTextColor(Color.parseColor("#7E7E7E"));
                    price3.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }
            }
        });
        price4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (price4.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                    list.add(price4.getText().toString());
                    price4.setTextColor(Color.parseColor("#0185FF"));
                    price4.setBackgroundColor(Color.parseColor("#E4F2FF"));
                } else {
                    list.remove(price4.getText().toString());
                    price4.setTextColor(Color.parseColor("#7E7E7E"));
                    price4.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }
            }
        });
        price5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (price5.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                    list.add(price5.getText().toString());
                    price5.setTextColor(Color.parseColor("#0185FF"));
                    price5.setBackgroundColor(Color.parseColor("#E4F2FF"));
                } else {
                    list.remove(price5.getText().toString());
                    price5.setTextColor(Color.parseColor("#7E7E7E"));
                    price5.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }
            }
        });

        price6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (price6.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                    list.add(price6.getText().toString());
                    price6.setTextColor(Color.parseColor("#0185FF"));
                    price6.setBackgroundColor(Color.parseColor("#E4F2FF"));
                } else {
                    list.remove(price6.getText().toString());
                    price6.setTextColor(Color.parseColor("#7E7E7E"));
                    price6.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }
            }
        });
    }
}
