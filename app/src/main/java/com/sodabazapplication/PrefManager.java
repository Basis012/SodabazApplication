package com.sodabazapplication;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    private static final String PREF_NAME = "IntroPref";
    private static final String KEY_IS_FIRST_TIME = "isFirstTime";

    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private Context context;

    public PrefManager(Context context) {
        this.context = context;
        pref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(KEY_IS_FIRST_TIME, isFirstTime);
        editor.apply();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(KEY_IS_FIRST_TIME, true);
    }
}
