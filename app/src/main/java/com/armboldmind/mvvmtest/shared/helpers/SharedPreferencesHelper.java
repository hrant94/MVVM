package com.armboldmind.mvvmtest.shared.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class SharedPreferencesHelper {

    private SharedPreferences mShared;
    private SharedPreferences.Editor mEditor;

    @SuppressLint("CommitPrefEdits")
    public SharedPreferencesHelper(Context context) {
        mShared = context.getSharedPreferences("Configs", Context.MODE_PRIVATE);
        mEditor = mShared.edit();
    }

    public void setStringSharedPreferences(String key, String value) {
        mEditor.putString(key, value);
        mEditor.commit();
    }

    public String getStringSharedPreferences(String key) {
        return mShared.getString(key, null);
    }

    public void setIntSharedPreferences(String key, int value) {
        mEditor.putInt(key, value);
        mEditor.commit();
    }

    public int getIntSharedPreferences(String key) {
        return mShared.getInt(key, 0);
    }

    public void setBooleanSharedPreferences(String key, Boolean value) {
        mEditor.putBoolean(key, value);
        mEditor.commit();
    }

    public Boolean getBooleanSharedPreferences(String key) {
        return mShared.getBoolean(key, false);
    }

    public void setObjectSharedPreferences(String key, List<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        mEditor.putString(key, json);
        mEditor.commit();
    }

    public List<String> getObjectSharedPreferences(String key) {
        Gson gson = new Gson();
        String json = mShared.getString(key, null);
        return gson.fromJson(json, new TypeToken<List<String>>() {
        }.getType());
    }

    public void deleteSharedPreferences() {
        mEditor.clear();
        mEditor.commit();
    }

    public SharedPreferences getSharedPreferences() {
        return mShared;
    }
}