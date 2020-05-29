package com.luna.web.alipay.epay.service.impl;

import com.alipay.api.AlipayApiException;

import com.luna.web.alipay.epay.alipay.Alipay;
import com.luna.web.alipay.epay.alipay.AlipayBean;
import com.luna.web.alipay.epay.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayServiceImpl implements PayService {

	@Autowired
	private Alipay alipay;
	
	@Override
	public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
		return alipay.pay(alipayBean);
	}


}
