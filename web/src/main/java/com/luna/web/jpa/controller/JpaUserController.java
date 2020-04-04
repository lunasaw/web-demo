package com.luna.web.jpa.controller;

import com.luna.web.jpa.dao.JpaUserRepository;
import com.luna.web.jpa.entity.JpaUserDO;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Luna@win10
 * @date 2020/4/4 19:14
 */
@RestController
@RequestMapping("jpa")
public class JpaUserController {

	@Autowired
	JpaUserRepository jpaUserRepository;

	@GetMapping("/user/{id}")
	public String getUser(@PathVariable("id")Integer id){
		System.out.println("jpa进入方法");
		Optional<JpaUserDO> byId = jpaUserRepository.findById(id);
		return byId.toString();
	}

	@GetMapping("/user")
	public JpaUserDO insertUser(JpaUserDO jpaUserDO){
		System.out.println("jpa进入方法");
		JpaUserDO save = jpaUserRepository.save(jpaUserDO);
		return save;
	}

}
