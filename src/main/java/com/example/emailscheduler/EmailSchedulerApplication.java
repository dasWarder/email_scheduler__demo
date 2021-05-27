package com.example.emailscheduler;

import com.example.emailscheduler.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class EmailSchedulerApplication {

    @Autowired
    private EmailService emailService;

    public static void main(String[] args) {
        SpringApplication.run(EmailSchedulerApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void trigger() {
        emailService.sendEmail("babichev@tlu.ee", "This is just a test message", "Test");
    }

}
