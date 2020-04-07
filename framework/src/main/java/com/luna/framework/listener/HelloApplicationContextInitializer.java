package com.luna.framework.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Luna@win10
 * @date 2020/4/7 15:39
 */
public class HelloApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
	private static final Logger log = LoggerFactory.getLogger(HelloApplicationContextInitializer.class);


	@Override
	public void initialize(ConfigurableApplicationContext applicationContext) {
		log.info("Spring 监听器 ApplicationContextInitializer...initializer..." + applicationContext.toString());
	}
}
