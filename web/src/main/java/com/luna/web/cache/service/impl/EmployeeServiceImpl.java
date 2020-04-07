package com.luna.web.cache.service.impl;

import com.luna.web.cache.entity.Employee;
import com.luna.web.cache.mapper.EmployeeMapper;
import com.luna.web.cache.service.EmployeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Employee)表服务实现类
 *
 * @author luna
 * @since 2020-04-07 20:37:05
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeMapper employeeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Employee getById(Integer id) {
        return this.employeeMapper.getByPrimaryKey(id);
    }
    
    /**
     * 通过Employee对象查询集合
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public List<Employee> getAll(Employee employee) {
        return this.employeeMapper.getAll(employee);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee insert(Employee employee) {
        this.employeeMapper.insert(employee);
        return employee;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee update(Employee employee) {
        this.employeeMapper.updateByPrimaryKey(employee);
        return this.getById(employee.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.employeeMapper.deleteByPrimaryKey(id) > 0;
    }
}