package com.example.emailscheduler.service.email;


import com.example.emailscheduler.model.Message;
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

    public void sendEmail(Message message) {
        log.info("Try to send a mail to {}", message.getTo());
        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setTo(message.getTo());
        simpleMessage.setFrom("andreymailsender@gmail.com");
        simpleMessage.setSubject(message.getTopic());
        simpleMessage.setText(message.getBody());
        mailSender.send(simpleMessage);
        log.info("The mail was successfully send from {} to {}", simpleMessage.getFrom(), message.getTo());
    }
}
