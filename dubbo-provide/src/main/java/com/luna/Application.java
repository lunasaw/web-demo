package com.luna;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.luna.provide.service.DubboService;
import com.luna.provide.service.DubboServiceImpl;

import java.util.concurrent.CountDownLatch;

public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "111.229.114.126");

    public static void main(String[] args) throws Exception {
        ServiceConfig<DubboService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        service.setInterface(DubboService.class);
        service.setRef(new DubboServiceImpl());
        service.export();

        System.out.println("dubbo service started服务启动");
        new CountDownLatch(1).await();
    }
}