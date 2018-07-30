package com.example.administrator.test.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


import com.example.administrator.test.MainActivity;
import com.example.administrator.test.R;
import com.example.administrator.test.entity.MyUser;
import com.example.administrator.test.utils.ShareUtils;
import com.example.administrator.test.utils.StaticClass;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2018/7/28.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private EditText password;
    private Button btn_register;
    private Button btn_login;
    private CheckBox keep_password;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bmob.initialize(this, StaticClass.BMOB_APP_ID);
        setContentView(R.layout.activity_login);
        
        initView();
    }

    private void initView() {
        name=findViewById(R.id.name);
        password=findViewById(R.id.password);
        btn_login=findViewById(R.id.btn_login);//登陆按钮
        btn_login.setOnClickListener(this);
        btn_register=findViewById(R.id.btn_register);//注册按钮
        btn_register.setOnClickListener(this);
        keep_password=findViewById(R.id.keep_password);//记住密码

        //设置选中状态
        boolean isCheck = ShareUtils.getBoolean(this,"keeppass",false); //默认为未选中
        keep_password.setChecked(isCheck);
        if(isCheck){
            //设置密码
            name.setText(ShareUtils.getString(this,"name",""));
            password.setText(ShareUtils.getString(this,"password",""));
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_register:
                startActivity(new Intent(this,RegisterActivity.class));
                break;

            case R.id.btn_login:

                //获取输入框的值
                String n = name.getText().toString().trim();
                String p = password.getText().toString().trim();
                //判断是否为空
                if(!TextUtils.isEmpty(n) & !TextUtils.isEmpty(p)){
                    //登录
                    MyUser user =new MyUser();
                    user.setUsername(n);
                    user.setPassword(p);

                    user.login(new SaveListener<MyUser>() {
                        @Override
                        public void done(MyUser myUser, BmobException e) {
                            if(e==null){ //没有异常
                                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            }
                            else{//有异常
                                Toast.makeText(LoginActivity.this, "登陆失败"+e.toString(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
