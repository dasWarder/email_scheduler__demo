package com.example.emailscheduler.service.email.sender;


import com.example.emailscheduler.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import static com.example.emailscheduler.service.formatter.MessageFormatterServiceImpl.AUTHOR;


@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    private JavaMailSender mailSender;

    @Autowired
    public EmailServiceImpl(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendEmail(Message message) {
        log.info("Try to send a mail to {}", message.getTo());

        SimpleMailMessage simpleMessage = new SimpleMailMessage();
        simpleMessage.setSubject(message.getTopic());
        simpleMessage.setFrom(AUTHOR);
        simpleMessage.setText(message.getBody());
        simpleMessage.setTo(message.getTo());

        mailSender.send(simpleMessage);

        log.info("The mail was successfully send from {} to {}", simpleMessage.getFrom(), message.getTo());
    }
}
