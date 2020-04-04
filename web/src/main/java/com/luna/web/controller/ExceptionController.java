package com.luna.web.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.luna.common.core.domain.AjaxResult;
import com.luna.common.utils.ServletUtils;

/**
 * @author Luna@win10
 * @date 2020/3/31 13:45
 */
@Controller
@RequestMapping("detail")
public class ExceptionController {

	@GetMapping("/demo1")
	@ResponseBody
	public Object demo1(){
//		int i = 1 / 0;
		return new Date();
	}

	@ExceptionHandler({RuntimeException.class})
	public Object fix(HttpServletRequest request, Exception ex){
		System.out.println("do This @Controller+@ExceptionHandler优先级最高");
		if (ServletUtils.isAjaxRequest(request)){
			return AjaxResult.error(ex.getMessage());
		}
		return new ModelAndView("/error/500");
	}

}
