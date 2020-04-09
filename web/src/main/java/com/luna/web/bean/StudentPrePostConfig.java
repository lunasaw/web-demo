package com.luna.web.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.luna.web.bean")
public class StudentPrePostConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
		//1
	Student beanStudent() {
		return new Student();
	}


}