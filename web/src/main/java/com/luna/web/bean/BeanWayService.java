package com.luna.web.bean;

/**
 * Bean的初始化和销毁
 * 1.java形式的配置方式：使用@bean的initMethod和destorymethod等同于init-method、destory-method
 * 2.注解方式：利用-250的@PostConstruct和@PreDestory
 *
 * @author Hiiso
 */
public class BeanWayService {
	public void init() {
		System.out.println("@Bean-init-method//1在构造函数执行完之后执行");
	}

	public BeanWayService() {
		super();
		System.out.println("初始化构造函数-BeanWayService");
	}

	public void destroy() {
		System.out.println("@Bean-destory-method//2在bean销毁之前执行");
	}
}