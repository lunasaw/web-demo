package com.luna;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Luna@win10
 * @date 2020/4/7 15:39
 * @SpringBootApplication(scanBasePackages = "com.luna")
 *
 * SpringBootApplication 扫描子包和同级包
 */
@SpringBootApplication
public class FrameworkApplication {

    public static void main(String[] args) {
        SpringApplication.run(FrameworkApplication.class, args);
    }

}
