package com.luna.user.service;


import com.alibaba.dubbo.config.annotation.Reference;
import com.luna.provide.service.TicketService;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Reference
    TicketService ticketService;

    public String hello(String name){
        String helloName = ticketService.getTicket("=====>>"+name);
        System.out.println(helloName);
        return helloName;
    }

}
