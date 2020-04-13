package com.luna.user.service;


import com.alibaba.dubbo.config.annotation.Reference;

import com.luna.provide.service.DubboService;
import org.springframework.stereotype.Service;

@Service
public class UserService{

    @Reference
    DubboService dubboService;

    public String hello(String name){
        String helloName = dubboService.getDubbo("=====>>"+name);
        System.out.println(helloName);
        return helloName;
    }

}
