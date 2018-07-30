package com.example.administrator.test.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.administrator.test.R;
import com.example.administrator.test.entity.MyUser;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2018/7/28.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {
    private EditText et_user;
    private EditText et_password;
    private EditText et_password_again;
    private RadioGroup mRadioGroup;
    private EditText et_mailbox;
    private Button btn_register2;
    //性别
    private boolean sex=true;//默认为男

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        initView();
    }

    private void initView() {
        et_user=findViewById(R.id.et_user);
        et_password=findViewById(R.id.et_password);
        et_password_again=findViewById(R.id.et_password_again);
        et_mailbox=findViewById(R.id.et_mailbox);
        mRadioGroup=findViewById(R.id.mRadioGroup);
        btn_register2=findViewById(R.id.btn_register2);
        btn_register2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btn_register2:
                //点击，获取到输入框的值
                String name=et_user.getText().toString().trim();
                String password=et_password.getText().toString().trim();
                String password_again=et_password_again.getText().toString().trim();
                String mailbox=et_mailbox.getText().toString().trim();

                //判断是否为空
                if(!TextUtils.isEmpty(name) & !TextUtils.isEmpty(password)
                        & !TextUtils.isEmpty(password_again) & !TextUtils.isEmpty(mailbox)){

                    //判断两次输入的密码是否一致
                    if(password.equals(password_again)){

                        //判断性别
                        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                                if(i==R.id.boy){
                                    sex=true;
                                }
                                else if(i==R.id.girl)
                                    sex=false;
                            }
                        });

                        //注册
                        MyUser user =new MyUser();
                        user.setUsername(name);
                        user.setPassword(password);
                        user.setEmail(mailbox);
                        user.setSex(sex);

                        user.signUp(new SaveListener<MyUser>() {
                            @Override
                            public void done(MyUser myUser, BmobException e) {
                                if(e==null){
                                    finish();
                                    Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
                                }else{
                                    Toast.makeText(RegisterActivity.this, "注册失败"+e.toString(), Toast.LENGTH_SHORT).show();
                                }

                            }
                        });
                    }
                    else{
                        Toast.makeText(this, "两次密码输入不一致", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    //若有输入框为空，弹出提示
                    Toast.makeText(this, "输入框不能为空", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
