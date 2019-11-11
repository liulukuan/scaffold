package com.llk.scaffold.model.entity;

import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2019-11-09 13:48:04
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = 251291806378138279L;
    /**
    * 主键
    */
    private Long uId;
    /**
    * 用户名
    */
    private String userName;
    /**
    * 密码
    */
    private String userPass;


    public Long getUId() {
        return uId;
    }

    public void setUId(Long uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

}