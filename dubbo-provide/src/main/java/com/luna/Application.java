package com.luna;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import com.luna.provide.service.TicketService;
import com.luna.provide.service.TicketServiceImpl;

import java.util.concurrent.CountDownLatch;

public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "111.229.114.126");

    public static void main(String[] args) throws Exception {
        ServiceConfig<TicketService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("dubbo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        service.setInterface(TicketService.class);
        service.setRef(new TicketServiceImpl());
        service.export();

        System.out.println("dubbo service started服务启动");
        new CountDownLatch(1).await();
    }
}