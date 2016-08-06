package com.sh.lynn.huang.wdaccount.utils;

import android.text.TextUtils;
import android.widget.TextView;

/**
 * Created by hyz84 on 16/8/2.
 */
public class Validator {
    public Validator(){}

    public boolean isEmpty(TextView textView,String notceText){
        if(TextUtils.isEmpty(textView.getText().toString())){
            textView.setError(notceText);
            return  false;
        }
        return  true;
    }
}
