package com.sh.lynn.huang.wdaccount.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wanglj on 16/7/4.
 */

public class PreferencesManager {

    public static final String PREFERENCES_NAME = "MYTESTP";
    private SharedPreferences sharedPreferences;


    public PreferencesManager(Application application){
         sharedPreferences = application.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE);
    }

    public void saveLoginInfo(String username,String password){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username",username);
        editor.putString("password",password);
        editor.commit();
    }

    public void saveJessionId(String jessionId){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("MyJessionId",jessionId);
        editor.commit();
    }
    public String getJessionId(){
        return sharedPreferences.getString("MyJessionId","");
    }
    public String getUserName(){
        return sharedPreferences.getString("username","");
    }

    public String getPassword(){
        return sharedPreferences.getString("password","");
    }

}
