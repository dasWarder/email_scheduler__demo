package com.example.emailscheduler.service.formatter;

import com.example.emailscheduler.model.Message;

public interface MessageFormatterService {

    Message formatInfoMessage(String name);

    Message formatErrorMessage(String name, String reason);

    Message formatGreetingMessage(String name);
}
