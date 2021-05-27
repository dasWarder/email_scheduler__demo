package com.example.emailscheduler.job;

import com.example.emailscheduler.service.email.group.GroupMessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SubscribeScheduleNotificator {

    private GroupMessageService groupMessageService;

    @Autowired
    public SubscribeScheduleNotificator(GroupMessageService groupMessageService) {
        this.groupMessageService = groupMessageService;
    }

    @Scheduled(cron = "0 2 17 * * *")
    public void emailing() {

        log.info("Scheduler making a task about informing subscribers");

        groupMessageService.sendGroupInfoMessage();

        log.info("Scheduler successfully informed all subscribers");
    }
}
