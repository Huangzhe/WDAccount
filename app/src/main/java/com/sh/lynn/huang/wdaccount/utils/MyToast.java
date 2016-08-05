package com.sh.lynn.huang.wdaccount.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.sh.lynn.huang.wdaccount.R;


/**
 *
 * 提示条
 * Created by zt-pc on 2014/12/31.
 */
public class MyToast {
    private static Toast toast=null;
    public static void  showToast(Context context,String string,int sts){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View layout=inflater.inflate(R.layout.app_msg, null);
        if(toast==null) {
            toast= Toast.makeText(context, string, sts);
        }else{
            toast.setDuration(Toast.LENGTH_LONG);
        }
        TextView title = (TextView) layout.findViewById(R.id.message);
        title.setText(string);
        switch (sts){
            case 0:
                layout.setBackgroundResource(R.color.alert);
//                toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.TOP,0,50);//FILL_HORIZONTAL全屏平铺
                break;
            case 1:
                layout.setBackgroundResource(R.color.confirm);
//                toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.TOP,0,50);//FILL_HORIZONTAL全屏平铺
                break;
            case 2:
                layout.setBackgroundResource(R.color.info);
//                toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.TOP,0,50);//FILL_HORIZONTAL全屏平铺
                break;
            case 3:
                layout.setBackgroundResource(R.color.custom);
//                toast.setGravity(Gravity.FILL_HORIZONTAL|Gravity.TOP,0,50);//FILL_HORIZONTAL全屏平铺
                break;
        }

        toast.setView(layout);
        toast.show();
    }

    public static void showToast(Context ctx, String str) {
        if(toast==null) {
            toast= Toast.makeText(ctx, str, Toast.LENGTH_LONG);
        }

        toast.show();
    }
}
