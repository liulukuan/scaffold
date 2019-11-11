package com.llk.scaffold.model.entity;

import java.io.Serializable;

/**
 * 角色资源表(RolePermission)实体类
 *
 * @author makejava
 * @since 2019-11-11 14:18:00
 */
public class RolePermission implements Serializable {
    private static final long serialVersionUID = -35600392917582179L;
    /**
    * ID
    */
    private Integer id;
    /**
    * 角色id
    */
    private Integer roleId;
    /**
    * 权限id
    */
    private Integer permissionId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

}