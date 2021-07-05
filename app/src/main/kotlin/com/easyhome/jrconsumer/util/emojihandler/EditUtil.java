package com.easyhome.jrconsumer.util.emojihandler;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @创建人 lin
 * @创建时间 2019/11/9
 * @描述
 */
public class EditUtil implements TextWatcher {

    EditText et;

    public EditUtil(EditText editText) {
        this.et = editText;
        et.addTextChangedListener(this);
    }

    static final String str = "^\\d+\\.?\\d{0,2}$";

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        int selectionStart = et.getSelectionStart();
        int selectionEnd = et.getSelectionEnd();
        if (!isOnlyPointNumber(s.toString()) && s.length() > 0) {
            //删除多余输入的字（不会显示出来）
            s.delete(selectionStart - 1, selectionEnd);
            et.setText(s);
            et.setSelection(s.length());
        }
    }

    public boolean isOnlyPointNumber(String number) {
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
