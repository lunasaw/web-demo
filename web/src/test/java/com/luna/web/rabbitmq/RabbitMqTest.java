package com.luna.web.rabbitmq;

import com.luna.web.cache.entity.Employee;
import com.luna.web.cache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Luna@win10
 * @date 2020/4/10 12:11
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RabbitMqTest {

	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	EmployeeMapper employeeMapper;
	/**
	 * 1. 单播
	 */
	@Test
	public void aTest() {
		/**
		 *  Message 需要自己构造 自定义消息内容和消息头
		 * 		rabbitTemplate.send(exchange,routeKey,message);
		 * 	object 默认当成消息体 只需传入发送对象 自动序列化(默认使用java方式)发送给rabbitmq
		 * 	    rabbitTemplate.convertAndSend(exchange,routeKey,Object);
		 */
		Map<String, Object> map=new HashMap<>();
		map.put("msg","这是第一个消息");
		map.put("data", Arrays.asList("helloworld",123,true));
		rabbitTemplate.convertAndSend("exchange.direct","luna.news",employeeMapper.getByName("张三"));
	}

	/**
	 * 接收消息,如何数据自动json化
	 */
	@Test
	public void bTest() {
		Object o = rabbitTemplate.receiveAndConvert("luna.news");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	/**
	 * 广播
	 */
	@Test
	public void cTest() {
		rabbitTemplate.convertAndSend("exchange.fanout","",employeeMapper.getByName("李四"));
	}
}
