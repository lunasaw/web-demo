package com.luna.framework.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author Luna@win10
 * @date 2020/4/7 16:20
 */
@Component
public class HelloCommandLineRunner implements CommandLineRunner {
	private static final Logger log = LoggerFactory.getLogger(HelloCommandLineRunner.class);


	@Override
	public void run(String... args) throws Exception {
		log.info("CommandLineRunner...run");
		log.info(Arrays.asList(args).toString());
	}
}
