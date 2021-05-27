package com.example.emailscheduler;


import com.example.emailscheduler.repository.SubscriberRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = SubscriberRepository.class)
public class EmailSchedulerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmailSchedulerApplication.class, args);
    }

}
