package com.luna.web.bean;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author luna
 * @Description:一个学生类(Bean)，能体现其生命周期的Bean
 */
@Component
public class Student implements BeanNameAware {
	private String name;

	//无参构造方法
	public Student() {
		super();
		System.out.println("Student这个Bean：构造器");
	}

	/**
	 * 设置对象属性
	 *
	 * @param name the name to set
	 */
	public void setName(String name) {
		System.out.println("设置对象属性setName()..");
		this.name = name;
	}

	//Bean的初始化方法
	@PostConstruct
	public void init() {
		System.out.println("Student这个Bean：初始化");
	}

	//Bean的销毁方法
	@PreDestroy
	public void destroy() {
		System.out.println("Student这个Bean：销毁前执行");
	}

	//Bean的使用
	public void play() {
		System.out.println("Student这个Bean：使用");
	}

	/* 重写toString
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Student [name = " + name + "]";
	}

	//调用BeanNameAware的setBeanName()
	//传递Bean的ID。
	@Override
	public void setBeanName(String name) {
		System.out.println("调用BeanNameAware的setBeanName()...");
	}

}
