package com.luna.web.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Luna@win10
 * @date 2020/4/11 14:34
 */
@Service
public class ScheduleService {
	private static final Logger log = LoggerFactory.getLogger(ScheduleService.class);

	/**
	 * second 秒 minute 分 hour 时 day of month 日 month 月 day of week 周几
	 * 0 * * *  MON-FRI
	 *
	 * @Scheduled(cron = "0 * * * * MON-SAT")  //一分钟一次
	 * @Scheduled(cron = "0,1,2,3,4 * * * * MON-SAT") //0-4 秒执行
	 * @Scheduled(cron = "0-4 * * * * MON-SAT") // -连接
	 * @Scheduled(cron = "0/4 * * * * MON-SAT") // 每四秒一次
	 * @Scheduled(cron = "0/4 * * * * MON-SAT")
	 * @Scheduled(cron = "0 0/5 14 18 * * ? MON-SAT") //每天14点整18点整 每隔5分钟执行一次
	 * @Scheduled(cron = "0 15 10 ? * 1-16 MON-SAT")  //每个月的每周一至周六10:15 分执行一次
	 * @Scheduled(cron = "0 0 2 ? * 6L MON-SAT") //每个月的最后一个工作日凌晨两点执行一次
	 * @Scheduled(cron = "0 0 2-4 ? * 1#1 MON-SAT") //每个月的第一周凌晨2点到4点 每个整点执行一次
	 */
//	@Scheduled(cron = "0/4 * * * * MON-SAT") // 每四秒一次
//	public void schedule(){
//		log.info("定时任务启动");
//	}

}
