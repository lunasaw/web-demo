package com.luna.web.db;

import com.luna.web.cache.entity.Employee;
import com.luna.web.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author Luna@win10
 * @date 2020/4/9 13:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CacheTest {

    @Resource
    EmployeeMapper                employeeMapper;

    // kv 操作字符串
    @Autowired
    StringRedisTemplate           stringRedisTemplate;

    // kv 操作对象
    @Autowired
    RedisTemplate                 redisTemplate;

    // 自定义序列化
	@Autowired
    RedisTemplate<String, Object> objectRedisTemplate;


    /**
     * redis 常用操作
     */
    @Test
    public void aTest() {
        // String =>stringRedisTemplate.opsForValue()
        // TODO 保存数据
        stringRedisTemplate.opsForValue().append("luna1", "iszychen1");
        // TODO 获取数据
        String luna = stringRedisTemplate.opsForValue().get("luna1");
	    stringRedisTemplate.expire("luna1",3000, TimeUnit.SECONDS);
        System.out.println(luna);
        // List
//        stringRedisTemplate.opsForList().leftPush("myList", "1");
//        stringRedisTemplate.opsForList().leftPush("myList", "2");
//        stringRedisTemplate.opsForList().leftPush("myList", "3");
        // Set =>stringRedisTemplate.opsForSet()
        // Hash =>stringRedisTemplate.opsForHash()
        // Zset =>stringRedisTemplate.opsForZSet()
    }

    /**
     * TODO 测试保存对象
     */
    @Test
    public void bTest() {
        Employee emp = employeeMapper.getByName("张三");
        System.out.println(emp);
        // 保存对象使用序列化后的数据保存redis数据
        // redisTemplate.opsForValue().set("emp-1",emp);
        /**
         * TODO json保存
         * 1. 自己将数据转为json字符串
         * 2. 指定规则
         */
//	    objectRedisTemplate.opsForValue().set("emp-03",emp);
	    Object o = objectRedisTemplate.opsForValue().get("emp-03");
	    System.out.println(o.toString());
    }
}
