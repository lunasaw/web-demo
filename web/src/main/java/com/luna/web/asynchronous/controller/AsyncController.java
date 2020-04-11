package com.luna.web.asynchronous.controller;

import com.luna.common.core.domain.AjaxResult;
import com.luna.web.asynchronous.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Luna@win10
 * @date 2020/4/11 14:25
 */
@RestController
public class AsyncController {

	@Autowired
	AsyncService asyncService;

	@GetMapping("async")
	public AjaxResult async() throws InterruptedException {
		asyncService.asyncWork();
		return AjaxResult.success("success");
	}
}
