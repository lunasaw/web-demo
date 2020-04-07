package com.luna.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Luna@win10
 * @date 2020/4/7 23:03
 */
@Configuration
public class GeneratorConfig {
	private static final Logger log = LoggerFactory.getLogger(GeneratorConfig.class);

    @Bean("KeyGenerator")
    public KeyGenerator keyGenerator() {
	    log.info("自定义 KeyGenerator 生成器");
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
            	log.info("自定义key:"+method.getName() + "[" + Arrays.asList(params).toString() + "]");
                return method.getName() + "[" + Arrays.asList(params).toString() + "]";
            }
        };
    }

}
