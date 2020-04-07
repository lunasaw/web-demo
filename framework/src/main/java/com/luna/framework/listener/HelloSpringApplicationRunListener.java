package com.luna.framework.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringApplicationRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * @author Luna@win10
 * @date 2020/4/7 16:14
 */
public class HelloSpringApplicationRunListener implements SpringApplicationRunListener {
    private static final Logger log = LoggerFactory.getLogger(HelloSpringApplicationRunListener.class);

    public HelloSpringApplicationRunListener(SpringApplication application, String[] args) {

    }

    @Override
    public void starting() {
        log.info("starter 启动 SpringApplicationRunListener...starting...");
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        Object o = environment.getSystemProperties().get("os.name");
        log.info("系统名称:" + o);
        log.info("SpringApplicationRunListener...environmentPrepared...");
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        log.info("ioc 准备: contextPrepared");
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        log.info("容器加载完成: contextLoaded");
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        log.info("starter 启动 SpringApplicationRunListener...started...");
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        log.info("running 启动完成 ");
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        log.info("失败处理: failed");
    }
}
