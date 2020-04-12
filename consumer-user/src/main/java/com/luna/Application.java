package com.luna;


import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.luna.ticket.service.TicketService;

public class Application {
    private static String zookeeperHost = System.getProperty("zookeeper.address", "111.229.114.126");

    public static void main(String[] args) {
        ReferenceConfig<TicketService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("first-dubbo-provider"));
        reference.setRegistry(new RegistryConfig("zookeeper://" + zookeeperHost + ":2181"));
        reference.setInterface(TicketService.class);
	    TicketService service = reference.get();
        String message = service.getTicket();
        System.out.println(message);
    }
}