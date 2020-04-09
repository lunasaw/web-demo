package com.luna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


/**
 * @SpringBootApplication(scanBasePackages = "com.luna")
 *
 * SpringBootApplication 扫描子包和同级包
 *  1. 开启注解缓存 EnableCaching
 *  2. 注解缓存方法
 *  TODO 实际开发大都使用缓存中间件 redis 等..
 */
@EnableCaching
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

}
