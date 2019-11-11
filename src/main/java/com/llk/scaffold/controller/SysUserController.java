package com.llk.scaffold.controller;

import com.github.pagehelper.PageInfo;
import com.llk.scaffold.model.entity.SysUser;
import com.llk.scaffold.service.SysUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2019-11-09 13:48:06
 */
@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;

    /**
     * 分页查询全部数据
     */
    @GetMapping("/selectAll")
    public PageInfo<SysUser> selectOne(int pageNum, int pageSize) {
        return this.sysUserService.queryAllByPage(pageNum, pageSize);
    }

}