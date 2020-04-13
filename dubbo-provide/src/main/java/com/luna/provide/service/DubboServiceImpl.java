package com.luna.provide.service;

import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;


@Component
@Service //将服务发布出去
public class DubboServiceImpl implements DubboService {
    @Override
    public String getDubbo(String name) {
        return "dubbo"+name;
    }
}
