package com.llk.scaffold.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.llk.scaffold.dao.SysUserDao;
import com.llk.scaffold.model.entity.SysUser;
import com.llk.scaffold.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2019-11-09 13:48:05
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;

    /**
     * 查询多条数据
     *
     * @param pageNum  当前页
     * @param pageSize 每页的数量
     * @return 对象列表
     */
    @Override
    public PageInfo<SysUser> queryAllByPage(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
        List<SysUser> list = this.sysUserDao.queryAll();
        PageInfo<SysUser> pageInfo = new PageInfo(list);
        return pageInfo;
    }
}