package com.example.administrator.test.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.administrator.test.utils.StaticClass;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2018/7/23.
 * Activity 基类
 */

/**
 * 主要做的事情
 * 1.统一的属性
 * 2.统一的接口
 * 3.统一的方法
 */

public class BaseActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, StaticClass.BMOB_APP_ID);

        //显示返回键
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //菜单栏操作

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
