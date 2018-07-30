package com.example.administrator.test.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2018/7/25.
 * SharedPreferences 的封装
 */

public class ShareUtils {
    /*private void test(Context mComtext){
        SharedPreferences sp=mComtext.getSharedPreferences("config",Context.MODE_PRIVATE);
        //根据Context获取SharedPreferences对象
        sp.getString("key","未获取到");
        SharedPreferences.Editor editor=sp.edit(); //利用edit()方法获取Editor对象
        editor.putString("key","value");通过Editor对象获取key-value值
        editor.commit();通过commit()提交数据
    }*/
    public static final String NAME="config";

    //存 值
    public static void putString(Context mContext,String key,String value){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putString(key,value).commit();
    }

    //存 默认值
    public static String getString(Context mContext,String key,String defValue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getString(key,defValue);
    }

    //存 值 int
    public static void putInt(Context mContext,String key,int value){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putInt(key,value).commit();
    }

    //存 默认值 int
    public static int getInt(Context mContext,String key,int defValue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getInt(key,defValue);
    }

    //存 值 boolean
    public static void putBoolean(Context mContext,String key,boolean value){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().putBoolean(key,value).commit();
    }

    //存 默认值 boolean
    public static boolean getBoolean(Context mContext,String key,boolean defValue){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        return sp.getBoolean(key,defValue);
    }

    //删除 单个
    public static void deleShare(Context mContext,String key){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().remove(key).commit();
    }

    //删除 全部
    public static void deleAll(Context mContext){
        SharedPreferences sp=mContext.getSharedPreferences(NAME,Context.MODE_PRIVATE);
        sp.edit().clear().commit();
    }
}
