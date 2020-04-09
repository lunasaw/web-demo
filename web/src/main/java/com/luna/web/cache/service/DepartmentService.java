package com.luna.web.cache.service;


import com.luna.web.cache.entity.Department;

import java.util.List;

/**
 * (Department)表服务接口
 *
 * @author luna
 * @since 2020-04-07 20:37:20
 */
public interface DepartmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Department getById(Integer id);
    
    /**
     * 通过Department对象查询集合
     *
     * @param department 实例对象
     * @return 实例对象
     */
    List<Department> getAll(Department department);

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department insert(Department department);

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    Department update(Department department);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}