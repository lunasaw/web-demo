package com.luna.web.exception;

import com.luna.common.core.domain.AjaxResult;
import com.luna.common.utils.ServletUtils;
import com.luna.framework.config.DruidConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Luna@win10
 * @date 2020/3/31 14:25
 */
@ControllerAdvice
public class AdviceHanlerException {
	private static final Logger log = LoggerFactory.getLogger(AdviceHanlerException.class);

	@ExceptionHandler(value = RuntimeException.class)
	@ResponseBody
	public Object fix(HttpServletRequest request,Exception ex){
		System.out.println("优先第二 do This @ControllerAdvice+@ExceptionHandler");
		if (ServletUtils.isAjaxRequest(request)){
			return AjaxResult.error(ex.getMessage());
		}
		return new ModelAndView("/error/500");
	}

}
