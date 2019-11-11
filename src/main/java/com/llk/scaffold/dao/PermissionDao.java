package com.llk.scaffold.dao;

import com.llk.scaffold.model.dto.PermissionDto;
import com.llk.scaffold.model.entity.Permission;
import com.llk.scaffold.model.entity.Role;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 资源表(Permission)表数据库访问层
 *
 * @author makejava
 * @since 2019-11-11 14:17:44
 */
public interface PermissionDao {

    List<PermissionDto> findPermissionByRole(Role roleDto);

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Permission queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Permission> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param permission 实例对象
     * @return 对象列表
     */
    List<Permission> queryAll(Permission permission);

    /**
     * 新增数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int insert(Permission permission);

    /**
     * 修改数据
     *
     * @param permission 实例对象
     * @return 影响行数
     */
    int update(Permission permission);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}