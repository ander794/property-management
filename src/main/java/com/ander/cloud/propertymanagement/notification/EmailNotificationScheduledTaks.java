package com.ander.cloud.propertymanagement.notification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationScheduledTaks {
    private static final Logger log = LoggerFactory.getLogger(EmailNotificationScheduledTaks.class);

    @Scheduled(fixedRate = 5000)
	public void sendEmailNotification() {
    	//log.info("Email notification was sent");
	}
}
