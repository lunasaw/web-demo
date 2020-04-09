package com.luna.web.cache.service.impl;

import com.luna.web.cache.entity.Employee;
import com.luna.web.cache.mapper.EmployeeMapper;
import com.luna.web.cache.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
	private static final Logger log = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Resource
	private EmployeeMapper employeeMapper;

	/**
	 * 通过ID查询单条数据
	 *
	 * @param id 主键
	 * @return 实例对象
	 * 缓存
	 * 1. 属性
	 * cacheName / value 指定缓存组件的名字
	 * key 缓存数据使用的key 指定 默认使用方法参数的值 1- 方法的返回值
	 * SimpleKeyGenerator 生成Key的默认策略
	 * 1. 没有参数 key = new SimpleKey()
	 * 2. 一个参数 key = 参数值
	 * 3. 两个参数 key =new SimpleKey(params)
	 * 编写SpEl
	 * #id 参数id的值 #a0 #p0 #root.args[0]
	 * keyGenerator: key的生成器 可以自己指定key的生成器的组件id
	 * <p>
	 * cacheManger 指定缓存管理器 或者cacheResolver指定获取解析器
	 * condition 指定条件缓存
	 * unless 否定缓存  当unless 指定的方法的返回值条件不缓存 可以获取到结果进行判断
	 * sync 是否使用异步格式
	 * <p>
	 * 原理:
	 * 1. 自动配置类 cacheAutoConfiguration
	 * 2. 缓存的配置类
	 * <p>
	 * 流程:
	 * 1. 先去查询cache 组件 按照cacheName 获取  如果没有就按条件创建
	 * 2. 去cache中查找缓存内容 使用一个key  方法的参数
	 * 3. 如果没有查到缓存 就调用目标方法
	 * 4. 将目标方法返回的值放进缓存中
	 * @cacheable 标注的方法在方法执行前先检查缓存中有无数据 默认以参数作为默认值进入查询 数据不存在生成key 可查询结果放入缓存
	 * 如果数据存在 直接拿出数据
	 * <p>
	 * core :
	 * 1. CacheManager[ConcurrentMapCacheManager] 按照名字得到cache[ConcurrentMapCache] 组件
	 * 2. key 使用keyGenerator 生成  默认是 SimpleKeyGenerator
	 */
	@Override
	@Cacheable(cacheNames = {"emp"}, unless = "#result == null")
	/**
	 * TODO  cacheNames 与value 一值 接收一个数组 可以指定多个缓存  指定方法返回值所放入那个缓存中
	 * TODO key 键 默认是参数名
	 *  1. 拼串指定key key = "#root.methodName+'['+#id+']'"
	 *  2. 自定义generator配置 生成key keyGenerator = "KeyGenerator"
	 * TODO condition 条件缓存 condition = "#a0>1 and #root.methodName eq 'aaa'" 第一个参数的值大于1 才进入缓存 可用多条件
	 * TODO unless  否定条件  条件成立不进入缓存 condition = "#a0>1", unless = "#a0==2" ==>
	 *      2生成了key 但是没有进入缓存
	 *      1直接没有生成key
	 * TODO sync 是否异步 异步条件下 unless 失效
	 * condition => unless
	 */
	public Employee getById(Integer id) {
		Employee byPrimaryKey = employeeMapper.getByPrimaryKey(id);
		log.info("查询一次:" + byPrimaryKey);
		return byPrimaryKey;
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
	@Cacheable(value = "emp")
	public Employee insert(Employee employee) {
		this.employeeMapper.insert(employee);
		return employee;
	}


	/**
	 * @param employee 实例对象
	 * @return 实例对象
	 * @cachePut 既调用方法又更新缓存
	 * 运行时机:
	 * 1. 调用目标方法
	 * 2. 将目标方法的结果缓存
	 * 测试:
	 * 1. 查询一个员工 结果放入缓存
	 * key =id
	 * 2. 更新员工
	 * 使用 #result.id == #employee.id 但 Cacheable 不能使用 因为后者在查询之前就会调用key
	 * 将方法的返回值放入缓存中 key不一致 值为返回的对象
	 * TODO 故缓存指定不一致 不会更新缓存
	 * 修改数据
	 */
	@Override
	@CachePut(value = "emp", key = "#result.id")
	public Employee update(Employee employee) {
		employeeMapper.updateByPrimaryKey(employee);
		log.info("更新一次,修改行数:" + employee);
		return this.getById(employee.getId());
	}

	/**
	 * 通过主键删除数据
	 * CacheEvict 缓存清楚
	 * 1. 可通过key 删除指定key的缓存
	 *
	 * @param id 主键
	 * @return 是否成功
	 */
	@Override
	@CacheEvict(value = "emp", key = "#id")
	public boolean deleteById(Integer id) {
		log.info("删除一次:" + id);
		return this.employeeMapper.deleteByPrimaryKey(id) > 0;
	}

	/**
	 * 通过名字查询数据
	 * TODO Caching 复杂缓存
	 * 标注 cachePut 注解一定在方法执行后执行 即使有key存在
	 *
	 * @param name 主键
	 * @return
	 */
	@Override
	@Caching(
			cacheable = {
					@Cacheable(value = "emp", key = "#name")
			},
			put = {
					@CachePut(value = "emp", key = "#result.id"),
					@CachePut(value = "emp", key = "#result.email")
			}
	)
	public Employee getByName(String name) {
		log.info("名字查询:" + name);
		Employee byName = this.employeeMapper.getByName(name);
		return byName;
	}


	/**
	 * TODO 当引入CacheManger = = cache 缓存组件来个实际缓存存储时 引入RedisStarter 则更换了缓存组件变为了
	 *  1. RedisCacheManger
	 *  2. 帮我们创建
	 *  3. 默认数据是序列化保存的 因为默认使用的是jdkCacheManger
	 *  4. 保存为json
	 *
	 */
}