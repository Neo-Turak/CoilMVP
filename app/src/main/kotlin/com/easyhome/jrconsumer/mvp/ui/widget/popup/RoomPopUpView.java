package com.easyhome.jrconsumer.mvp.ui.widget.popup;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.easyhome.jrconsumer.R;
import com.jess.arms.utils.DataHelper;

/**
 * @author Hugo
 */
public class RoomPopUpView extends BasePopup<RoomPopUpView> {

    private Button confirm,reset;
    private EditText room,hall,toilet;
    private Context context;

   public static RoomPopUpView create(Context context){
       return new RoomPopUpView(context);
   }

    private RoomPopUpView(Context context) {
        setContext(context);
        this.context = context;
    }


    @Override
    protected void initAttributes() {
        setContentView(R.layout.pick_room_view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.PopupAnimaFade)
                .setFocusAndOutsideEnable(true);
    }

    @Override
    protected void initViews(View view, RoomPopUpView popup) {
            confirm=findViewById(R.id.confirm_btn);
            reset=findViewById(R.id.reset_btn);
            room=findViewById(R.id.room_et);
            hall=findViewById(R.id.hall_et);
            toilet=findViewById(R.id.toilet_et);


            room.setText(DataHelper.getStringSF(context,"room"));
            hall.setText(DataHelper.getStringSF(context,"hall"));
            toilet.setText(DataHelper.getStringSF(context,"toilet"));

            reset.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    room.setText("");
                    hall.setText("");
                    toilet.setText("");
                    DataHelper.setStringSF(context,"room","");
                    DataHelper.setStringSF(context,"hall","");
                    DataHelper.setStringSF(context,"toilet","");

                }
            });
            confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DataHelper.setStringSF(context,"room",room.getText().toString());
                    DataHelper.setStringSF(context,"hall",hall.getText().toString());
                    DataHelper.setStringSF(context,"toilet",toilet.getText().toString());

                    dismiss();
                }
            });
            room.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (room.getText().toString().length()==1){
                        hall.requestFocus();
                    }
                }
            });
            hall.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                }

                @Override
                public void afterTextChanged(Editable editable) {
                if (hall.getText().toString().length()==1){
                    toilet.requestFocus();
                }
                }
            });
    }



}
