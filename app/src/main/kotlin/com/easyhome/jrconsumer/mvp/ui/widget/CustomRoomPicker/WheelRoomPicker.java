package com.easyhome.jrconsumer.mvp.ui.widget.CustomRoomPicker;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class WheelRoomPicker extends LinearLayout implements IWheelRoomPicker {

    private static final float ITEM_TEXT_SIZE = 18;
    private static final String SELECTED_ITEM_COLOR = "#333333";
    private static final String ITEM_COLOR="#ADADAD";
    private Context mContext;

    private List<String> mHall,mKitchen, mToilet,mRoom;;

    private LayoutParams mLayoutParams;

    private WheelPicker wRoom, wHall, wKitchen,wToilet;

    public WheelRoomPicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayoutParams();
        initView(context);
        initData();
        wRoom.setSelectedItemPosition(2);
        wHall.setSelectedItemPosition(1);
        wToilet.setSelectedItemPosition(1);
        wKitchen.setSelectedItemPosition(1);
    }

    private void initData() {

        for (int i = 0; i < 10; i++) {
            mRoom.add(i + "室");
            mHall.add(i + "厅");
            mKitchen.add(i + "厨");
            mToilet.add(i + "卫");

            wRoom.setData(mRoom);
            wToilet.setData(mToilet);
            wKitchen.setData(mKitchen);
            wHall.setData(mHall);
        }
    }

    private void initLayoutParams() {
        mLayoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT,4f);
        mLayoutParams.gravity= Gravity.TOP;
        mLayoutParams.setMargins(5, 5, 5, 5);
        mLayoutParams.width = 0;
    }

    private void initView(Context context) {
        setOrientation(HORIZONTAL);
        mContext = context;

        mRoom = new ArrayList<>();
        mHall=new ArrayList<>();
        mKitchen=new ArrayList<>();
        mToilet=new ArrayList<>();
        wRoom=new WheelPicker(context);
        wHall=new WheelPicker(context);
        wKitchen=new WheelPicker(context);
        wToilet=new WheelPicker(context);

        initWheelPicker(wRoom);
        initWheelPicker(wHall);
        initWheelPicker(wKitchen);
        initWheelPicker(wToilet);

    }

    private void initWheelPicker(WheelPicker wheelPicker ) {
        mLayoutParams.weight = 1;
        wheelPicker.setItemTextSize(dip2px(mContext,ITEM_TEXT_SIZE));
        wheelPicker.setSelectedItemTextColor(Color.parseColor(SELECTED_ITEM_COLOR));
        wheelPicker.setItemTextColor(Color.parseColor(ITEM_COLOR));
        wheelPicker.setItemSpace(100);
        wheelPicker.setCurved(false);
        wheelPicker.setLayoutParams(mLayoutParams);
        addView(wheelPicker);
    }

    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public void setPosition(Integer room,Integer hall,Integer kitchen, Integer toilet){
        wRoom.setSelectedItemPosition(room);
        wHall.setSelectedItemPosition(hall);
        wKitchen.setSelectedItemPosition(kitchen);
        wToilet.setSelectedItemPosition(toilet);
    }

    @Override
    public String getRoom() {
       return mRoom.get(wRoom.getCurrentItemPosition());
    }

    public int getRoomPosition(){
        return  wRoom.getCurrentItemPosition();
    }

    @Override
    public String getHall() {
        return mHall.get(wHall.getCurrentItemPosition());
    }

    public int getHallPosition(){
        return wHall.getCurrentItemPosition();
    }
    @Override
    public String getKitchen() {
        return mKitchen.get(wKitchen.getCurrentItemPosition());
    }
    public int getKitchenPosition(){
        return wKitchen.getCurrentItemPosition();
    }

    @Override
    public String getToilet() {
        return mToilet.get(wToilet.getCurrentItemPosition());
    }

    public int getToiletPosition(){
        return wToilet.getCurrentItemPosition();
    }
}
