package com.luna.web.alipay.epay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Luna@win10
 * @date 2020/5/9 17:17
 */
@Controller
public class AliPayPageController {

	@GetMapping("alipay")
	public String aliPay(){
		return "alipay/pay";
	}


}
