package com.easyhome.jrconsumer.mvp.ui.widget.popup;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.easyhome.jrconsumer.R;

import java.util.ArrayList;

public class AreaPopUpView extends BasePopup<AreaPopUpView> {

    private Button confirm, reset;
    private TextView area1, area2, area3, area4, area5, area6, area7;

    public ArrayList<String> getList() {
        return list;
    }

    public void setList(ArrayList<String> list) {
        this.list = list;
        if (list.contains("60㎡以下")) {
            area1.setTextColor(Color.parseColor("#0185FF"));
            area1.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
         if (list.contains("60-90㎡")) {
             area2.setTextColor(Color.parseColor("#0185FF"));
             area2.setBackgroundColor(Color.parseColor("#E4F2FF"));
         }
         if (list.contains("90-120㎡")) {
             area3.setTextColor(Color.parseColor("#0185FF"));
             area3.setBackgroundColor(Color.parseColor("#E4F2FF"));
         }
         if (list.contains("120-150㎡")) {
             area4.setTextColor(Color.parseColor("#0185FF"));
             area4.setBackgroundColor(Color.parseColor("#E4F2FF"));
         }
         if (list.contains("150-180㎡")) {
             area5.setTextColor(Color.parseColor("#0185FF"));
             area5.setBackgroundColor(Color.parseColor("#E4F2FF"));
         }
        if (list.contains("180-200㎡")) {
            area6.setTextColor(Color.parseColor("#0185FF"));
            area6.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("200㎡以上")) {
            area7.setTextColor(Color.parseColor("#0185FF"));
            area7.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
    }

    private ArrayList<String> list;

    public static AreaPopUpView create(Context context,ArrayList<String> l) {
        return new AreaPopUpView(context,l);
    }

    private AreaPopUpView(Context context, ArrayList<String> l) {
        setContext(context);
        list= l;
    }

    @Override
    protected void initAttributes() {
        setContentView(R.layout.pick_area_view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.PopupAnimaFade)
                .setFocusAndOutsideEnable(true);
    }

    @Override
    protected void initViews(View view, AreaPopUpView popup) {
        area1 = findViewById(R.id.area_1_tv);
        area2 = findViewById(R.id.area_2_tv);
        area3 = findViewById(R.id.area_3_tv);
        area4 = findViewById(R.id.area_4_tv);
        area5 = findViewById(R.id.area_5_tv);
        area6 = findViewById(R.id.area_6_tv);
        area7 = findViewById(R.id.area_7_tv);

        if (list.contains("60㎡以下")){
            area1.setTextColor(Color.parseColor("#0185FF"));
            area1.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("60-90㎡")){
            area2.setTextColor(Color.parseColor("#0185FF"));
            area2.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }

        if (list.contains("90-120㎡")){
            area3.setTextColor(Color.parseColor("#0185FF"));
            area3.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("120-150㎡")){
            area4.setTextColor(Color.parseColor("#0185FF"));
            area4.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("150-180㎡")){
            area5.setTextColor(Color.parseColor("#0185FF"));
            area5.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("180-200㎡")){
            area6.setTextColor(Color.parseColor("#0185FF"));
            area6.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }
        if (list.contains("200㎡以上")){
            area7.setTextColor(Color.parseColor("#0185FF"));
            area7.setBackgroundColor(Color.parseColor("#E4F2FF"));
        }

        confirm=findViewById(R.id.confirm_btn);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            AreaPopUpView.super.dismiss();
            }
        });
        reset=findViewById(R.id.reset_btn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                area1.setTextColor(Color.parseColor("#7E7E7E"));
                area1.setBackgroundColor(Color.parseColor("#FAFAFA"));
                area2.setTextColor(Color.parseColor("#7E7E7E"));
                area2.setBackgroundColor(Color.parseColor("#FAFAFA"));
                area3.setTextColor(Color.parseColor("#7E7E7E"));
                area3.setBackgroundColor(Color.parseColor("#FAFAFA"));
                area4.setTextColor(Color.parseColor("#7E7E7E"));
                area4.setBackgroundColor(Color.parseColor("#FAFAFA"));
                area5.setTextColor(Color.parseColor("#7E7E7E"));
                area5.setBackgroundColor(Color.parseColor("#FAFAFA"));
                area6.setTextColor(Color.parseColor("#7E7E7E"));
                area6.setBackgroundColor(Color.parseColor("#FAFAFA"));
                area7.setTextColor(Color.parseColor("#7E7E7E"));
                area7.setBackgroundColor(Color.parseColor("#FAFAFA"));
                list.clear();
            }
        });

        area1.setOnClickListener(view1 -> {
            if (area1.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                list.add(area1.getText().toString());
                area1.setTextColor(Color.parseColor("#0185FF"));
                area1.setBackgroundColor(Color.parseColor("#E4F2FF"));
            } else {
                list.remove(area1.getText().toString());
                area1.setTextColor(Color.parseColor("#7E7E7E"));
                area1.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        });
        area2.setOnClickListener(view12 -> {
            if (area2.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                list.add(area2.getText().toString());
                area2.setTextColor(Color.parseColor("#0185FF"));
                area2.setBackgroundColor(Color.parseColor("#E4F2FF"));
            } else {
                list.remove(area2.getText().toString());
                area2.setTextColor(Color.parseColor("#7E7E7E"));
                area2.setBackgroundColor(Color.parseColor("#FAFAFA"));
            }
        });
        area3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (area3.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                    list.add(area3.getText().toString());
                    area3.setTextColor(Color.parseColor("#0185FF"));
                    area3.setBackgroundColor(Color.parseColor("#E4F2FF"));
                } else {
                    list.remove(area3.getText().toString());
                    area3.setTextColor(Color.parseColor("#7E7E7E"));
                    area3.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }
            }
        });
        area4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (area4.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                    list.add(area4.getText().toString());
                    area4.setTextColor(Color.parseColor("#0185FF"));
                    area4.setBackgroundColor(Color.parseColor("#E4F2FF"));
                } else {
                    list.remove(area4.getText().toString());
                    area4.setTextColor(Color.parseColor("#7E7E7E"));
                    area4.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }
            }
        });
        area5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (area5.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                    list.add(area5.getText().toString());
                    area5.setTextColor(Color.parseColor("#0185FF"));
                    area5.setBackgroundColor(Color.parseColor("#E4F2FF"));
                } else {
                    list.remove(area5.getText().toString());
                    area5.setTextColor(Color.parseColor("#7E7E7E"));
                    area5.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }
            }
        });

        area6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (area6.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                    list.add(area6.getText().toString());
                    area6.setTextColor(Color.parseColor("#0185FF"));
                    area6.setBackgroundColor(Color.parseColor("#E4F2FF"));
                } else {
                    list.remove(area6.getText().toString());
                    area6.setTextColor(Color.parseColor("#7E7E7E"));
                    area6.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }
            }
        });
        area7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (area7.getCurrentTextColor() == Color.parseColor("#7E7E7E")) {
                    list.add(area7.getText().toString());
                    area7.setTextColor(Color.parseColor("#0185FF"));
                    area7.setBackgroundColor(Color.parseColor("#E4F2FF"));
                } else {
                    list.remove(area7.getText().toString());
                    area7.setTextColor(Color.parseColor("#7E7E7E"));
                    area7.setBackgroundColor(Color.parseColor("#FAFAFA"));
                }
            }
        });
    }
}
