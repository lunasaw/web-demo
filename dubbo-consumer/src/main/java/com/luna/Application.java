package com.luna;


import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.luna.provide.service.DubboService;

public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "111.229.114.126");

    public static void main(String[] args) {
        ReferenceConfig<DubboService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("dubbo-consumer"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        reference.setInterface(DubboService.class);
	    DubboService service = reference.get();
        String message = service.getDubbo("luna");
        System.out.println(message);
    }
}