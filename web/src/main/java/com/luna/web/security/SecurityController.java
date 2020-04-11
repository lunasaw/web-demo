package com.luna.web.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Luna@win10
 * @date 2020/4/11 20:32
 */
@RequestMapping("/security")
@Controller
public class SecurityController {
	private final String PREFIX = "pages/";

	/**
	 * 欢迎页
	 *
	 * @return
	 */
	@GetMapping("/welcome")
	public String index() {
		return PREFIX + "welcome";
	}

	/**
	 * 登陆页
	 *
	 * @return
	 */
	@GetMapping("/userlogin")
	public String loginPage() {
		return PREFIX + "login";
	}


	/**
	 * level1页面映射
	 *
	 * @param path
	 * @return
	 */
	@GetMapping("/level1/{path}")
	public String level1(@PathVariable("path") String path) {
		return PREFIX + "level1/" + path;
	}

	/**
	 * level2页面映射
	 *
	 * @param path
	 * @return
	 */
	@GetMapping("/level2/{path}")
	public String level2(@PathVariable("path") String path) {
		return PREFIX + "level2/" + path;
	}

	/**
	 * level3页面映射
	 *
	 * @param path
	 * @return
	 */
	@GetMapping("/level3/{path}")
	public String level3(@PathVariable("path") String path) {
		return PREFIX + "level3/" + path;
	}


}