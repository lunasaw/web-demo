package com.luna.web.asynchronous;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author Luna@win10
 * @date 2020/4/11 14:22
 */
@Service
public class AsyncService {
	private static final Logger log = LoggerFactory.getLogger(AsyncService.class);

	/**
	 * 告诉Spring 这是一个异步方法
	 * @throws InterruptedException
	 */
	@Async
	public void asyncWork() throws InterruptedException {
		Thread.sleep(3000);
		log.info("数据处理中...");
	}

}
