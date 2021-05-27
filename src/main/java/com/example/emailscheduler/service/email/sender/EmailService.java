package com.example.emailscheduler.service.email.sender;

import com.example.emailscheduler.model.Message;

public interface EmailService {

    void sendEmail(Message message);
}
