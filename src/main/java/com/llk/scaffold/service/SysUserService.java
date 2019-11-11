package com.llk.scaffold.service;

import com.github.pagehelper.PageInfo;
import com.llk.scaffold.model.entity.SysUser;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2019-11-09 13:48:05
 */
public interface SysUserService {

    /**
     * 查询多条数据
     *
     * @param pageNum  当前页
     * @param pageSize 每页的数量
     * @return 对象列表
     */
    PageInfo<SysUser> queryAllByPage(int pageNum, int pageSize);
}