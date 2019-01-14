package com.herba.sdk.myapplication.viewpager;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class MyConfiguration {

    private static final String TAG = MyConfiguration.class.getSimpleName();

    public static final String DEVICE_PREF_NAME = "DevicePref";
    public static final String COUNTER = "COUNTER";
    public static final String ISHOME = "false";

    // set value to shared preference
    public static void setPreferences(Context context, String key, String value) {
        SharedPreferences DevicePref = context.getSharedPreferences(DEVICE_PREF_NAME, 0);
        SharedPreferences.Editor DeviceEditor = DevicePref.edit();
        DeviceEditor.putString(key, value);
        DeviceEditor.commit();
    }

//    public static void setPreferences(Context context, String key, boolean value) {
//        SharedPreferences DevicePref = context.getSharedPreferences(DEVICE_PREF_NAME, 0);
//        SharedPreferences.Editor DeviceEditor = DevicePref.edit();
//        DeviceEditor.putBoolean(key, value);
//        DeviceEditor.commit();
//    }

    // get value from shared preference
    public static String getPreferences(Context context, String key) {

        String data = null;
        try {
            SharedPreferences DevicePref = context.getSharedPreferences(DEVICE_PREF_NAME, 0);
            data = DevicePref.getString(key, "");
        } catch (Exception e) {
            Log.d(TAG, "(getPreferences) catch exception = " + e.getMessage());
        }
        return data;
    }
}