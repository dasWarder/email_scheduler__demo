package com.example.emailscheduler.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class EmailService {

    private JavaMailSender mailSender;

    @Autowired
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(String to, String body, String topic) {
        log.info("Try to send a mail to {}", to);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setFrom("andreymailsender@gmail.com");
        message.setSubject(topic);
        message.setText(body);
        mailSender.send(message);
        log.info("The mail was successfully send from {} to {}", message.getFrom(), to);
    }
}
