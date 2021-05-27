package com.example.emailscheduler;

import com.example.emailscheduler.model.Message;
import com.example.emailscheduler.repository.SubscriberRepository;
import com.example.emailscheduler.service.email.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SubscriberRepository.class)
public class EmailSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailSchedulerApplication.class, args);
    }

}
