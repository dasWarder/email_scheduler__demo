package com.example.emailscheduler.service.email.group;


import com.example.emailscheduler.model.Message;
import com.example.emailscheduler.model.Subscriber;
import com.example.emailscheduler.service.email.sender.EmailService;
import com.example.emailscheduler.service.formatter.MessageFormatterService;
import com.example.emailscheduler.service.subscriber.SubscriberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GroupMessageServiceImpl implements GroupMessageService {

    private EmailService emailService;

    private SubscriberService subscriberService;

    private MessageFormatterService messageFormatterService;

    public GroupMessageServiceImpl(EmailService emailService,
                                   SubscriberService subscriberService,
                                   MessageFormatterService messageFormatterService) {
        this.emailService = emailService;
        this.subscriberService = subscriberService;
        this.messageFormatterService = messageFormatterService;
    }

    @Override
    public void sendGroupInfoMessage() {
        log.info("Try to send group Info message");

        List<Subscriber> subscribers = subscriberService.getAll();

        subscribers.forEach(sub -> {
            Message message = messageFormatterService.formatInfoMessage(sub.getName());
            message.setTo(sub.getEmail());
            emailService.sendEmail(message);
        });

        log.info("All group Info messages were successfully send");
    }
}
