package com.luna.web.cache.service.impl;

import com.luna.web.cache.entity.Department;
import com.luna.web.cache.mapper.DepartmentMapper;
import com.luna.web.cache.service.DepartmentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author luna
 * @since 2020-04-07 20:37:20
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
	private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);


	@Resource
    private DepartmentMapper departmentMapper;

	@Autowired
	CacheManager cacheManager;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    @Cacheable(value = "dept", unless="#result == null")
    public Department getById(Integer id) {
	    log.info("部门查询一次:"+id);
	    Cache dept = cacheManager.getCache("dept");
	    dept.put("dept-"+id,"缓存管理器操作");
	    return this.departmentMapper.getByPrimaryKey(id);
    }
    
    /**
     * 通过Department对象查询集合
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public List<Department> getAll(Department department) {
        return this.departmentMapper.getAll(department);
    }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insert(Department department) {
        this.departmentMapper.insert(department);
        return department;
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department update(Department department) {
        this.departmentMapper.updateByPrimaryKey(department);
        return this.getById(department.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.departmentMapper.deleteByPrimaryKey(id) > 0;
    }
}