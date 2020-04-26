package com.mitchelletakuro.chefdelight.ui;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {


    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Context context;


    public PrefManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("first",0);
        editor = sharedPreferences.edit();
    }

    // Check if the app is used first time or not
    public void setFirst(Boolean isFirst){

        editor.putBoolean("check",isFirst);
        editor.commit();
    }

    public boolean Check(){
        return sharedPreferences.getBoolean("check",true);
    }


}
