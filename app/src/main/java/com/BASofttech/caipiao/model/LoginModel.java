package com.BASofttech.caipiao.model;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

/**
 * created by stray cat on 2019/6/19.
 */
public class LoginModel extends LitePalSupport {
    private String password;
    private String userid;
    private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
