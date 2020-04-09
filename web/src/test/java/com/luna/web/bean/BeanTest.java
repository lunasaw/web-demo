package com.luna.web.bean;

import com.luna.common.utils.spring.SpringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Luna@win10
 * @date 2020/4/9 23:40
 */

/**
 * 测试类
 *
 * @author LinJie
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class BeanTest {
	/**
	 * Spring应用上下文环境
	 */
	private static ConfigurableListableBeanFactory beanFactory;

	@Test
	public void test() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentPrePostConfig.class);
		Student student = SpringUtils.getBean("student");
		student.play();
		student.setName("张三");
		System.out.println(student);
//		关闭容器
		context.close();
	}

	@Test
	public void bTest() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PrePostConfig.class);
		context.close();
	}
}


