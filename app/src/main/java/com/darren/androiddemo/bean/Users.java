package com.darren.androiddemo.bean;

import cn.bmob.v3.BmobObject;


/**
 * Created by lenovo on 2017/4/27.
 */

public class Users extends BmobObject {
    private String name;
    private String password;
    private String email;

    public Users() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
    }
}
