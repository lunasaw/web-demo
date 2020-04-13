package com.luna.user.controller;

import com.luna.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luna@win10
 * @date 2020/4/13 22:10
 */
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/dubbo/{name}")
	public String sayHello(@PathVariable("name")String name){
		return userService.hello(name);
	}

}
