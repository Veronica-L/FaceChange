package com.example.administrator.test.entity;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2018/7/24.
 * 用户属性
 */

public class MyUser extends BmobUser{
    private boolean sex; //性别
    private String mailbox; //邮箱

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getMailbox() {
        return mailbox;
    }

    public void setMailbox(String mailbox) {
        this.mailbox = mailbox;
    }
}
