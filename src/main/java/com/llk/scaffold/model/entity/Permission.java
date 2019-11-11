package com.llk.scaffold.model.entity;

import java.io.Serializable;

/**
 * 资源表(Permission)实体类
 *
 * @author makejava
 * @since 2019-11-11 14:17:44
 */
public class Permission implements Serializable {
    private static final long serialVersionUID = -21082555104749103L;
    /**
    * ID
    */
    private Integer id;
    /**
    * 资源名称
    */
    private String name;
    /**
    * 权限代码字符串
    */
    private String perCode;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPerCode() {
        return perCode;
    }

    public void setPerCode(String perCode) {
        this.perCode = perCode;
    }

}