package com.luna.web.controller;

import com.luna.starter.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luna@win10
 * @date 2020/4/7 18:35
 */
@RestController
public class HelloController {

	@Autowired
	HelloService helloService;

	@GetMapping("/hello")
	public String hello(){
		return helloService.syaHello("自动配置! 你好呀");
	}
}
