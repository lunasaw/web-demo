package com.luna.web.table.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Luna@win10
 * @date 2020/3/25 0:46
 */
@Controller
public class CommonTableController {

	@GetMapping("table")
	public String table() {
		return "thymeleaf/table";
	}


}
