package com.iist.hrm.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.iist.hrm.service.TokenService;

@Component
public class ScheduledTasks {
	
	private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
	
	@Autowired
	private TokenService tokenService;
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void ScheduledTaskCleanToken() {
		logger.debug("Start job clean token");
		tokenService.cleanExpiredToken();
		logger.debug("End job clean token");
	}
}
