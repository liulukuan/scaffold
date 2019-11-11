package com.llk.scaffold.controller;

import com.llk.scaffold.model.entity.Permission;
import com.llk.scaffold.service.PermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 资源表(Permission)表控制层
 *
 * @author makejava
 * @since 2019-11-11 14:17:44
 */
@RestController
@RequestMapping("permission")
public class PermissionController {
    /**
     * 服务对象
     */
    @Resource
    private PermissionService permissionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Permission selectOne(Integer id) {
        return this.permissionService.queryById(id);
    }

}