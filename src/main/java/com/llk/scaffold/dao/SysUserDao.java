package com.llk.scaffold.dao;

import com.llk.scaffold.model.entity.SysUser;

import java.util.List;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2019-11-09 13:48:05
 */
public interface SysUserDao {

    /**
     * 分页查询
     *
     * @return 对象列表
     */
    List<SysUser> queryAll();
}