package com.luna.web.rabbitmq;

import com.luna.web.cache.entity.Employee;
import com.luna.web.cache.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @authona@win10
 * @date 2020/4/10 13:48
 */
@Service("rabbitmq")
public class RabbitMqService {
	private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);


	@RabbitListener(queues = "luna.news")
	public void receive(Employee employee) {
		log.info("收到消息:" + employee.toString());
	}

	@RabbitListener(queues = "luna")
	public void receiveHead(Message message){
		log.info(message.getBody().toString());
		log.info(message.getMessageProperties().toString());
	}
}
