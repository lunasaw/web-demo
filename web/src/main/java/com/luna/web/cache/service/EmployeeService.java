package com.luna.web.cache.service;

import com.luna.web.cache.entity.Employee;
import java.util.List;

/**
 * (Employee)表服务接口
 *
 * @author luna
 * @since 2020-04-07 20:35:56
 */
public interface EmployeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Employee getById(Integer id);
    
    /**
     * 通过Employee对象查询集合
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    List<Employee> getAll(Employee employee);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

	/**
	 * 通过名字查询数据
	 *
	 * @param name 主键
	 * @return 是否成功
	 */
	Employee getByName(String name);
}