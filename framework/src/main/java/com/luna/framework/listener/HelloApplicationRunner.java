package com.luna.framework.listener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author Luna@win10
 * @date 2020/4/7 16:19
 */
@Component
public class HelloApplicationRunner implements ApplicationRunner {
	private static final Logger log = LoggerFactory.getLogger(HelloApplicationRunner.class);


	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("参数传入");
		List<ApplicationArguments> applicationArguments = Arrays.asList(args);
		for (int i = 0; i < applicationArguments.size(); i++) {
			log.info(applicationArguments.get(i).getOptionNames().toString());
		}
	}
}
