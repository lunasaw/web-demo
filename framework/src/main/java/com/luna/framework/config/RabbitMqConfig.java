package com.luna.framework.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sun.rmi.runtime.NewThreadAction;

/**
 * @author Luna@win10
 * @date 2020/4/10 12:07
 */
@Configuration
public class RabbitMqConfig {
	private static final Logger log = LoggerFactory.getLogger(RabbitMqConfig.class);

	/**
	 * 自动配置
	 *  1. Properties封装配置信息
	 *  2. RabbitTemplate 封装发送和接收消息
	 *  3. AmqpAdmin 系统管理组件 可以声明队列创建交换器
	 *
	 */
	@Bean
	public MessageConverter messageConverter(){
		log.info("自定义消息转化为Json");
		return new Jackson2JsonMessageConverter();
	}

}
