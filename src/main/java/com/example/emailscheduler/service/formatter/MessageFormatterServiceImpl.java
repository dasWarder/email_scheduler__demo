package com.example.emailscheduler.service.formatter;


import com.example.emailscheduler.model.Message;
import com.example.emailscheduler.service.subscriber.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Service
public class MessageFormatterServiceImpl implements MessageFormatterService {

    public static final String AUTHOR = "superSubscription@gmail.com";


    @Override
    public Message formatInfoMessage(String name) {
        Message infoMessage = new Message();

        String body = String.format("Good %s, %s!\n" +
                        "We would like to inform You, that today %s is a really great day for You.\n" +
                        "We also want to wish You good luck and be happy! \n" +
                        "Thank You for choosing us! %s",
                formatGreetingByTime(), name, LocalDate.now().toString(), sign());

        infoMessage.setTopic("You're the great!");
        infoMessage.setBody(body);

        return infoMessage;
    }

    @Override
    public Message formatErrorMessage(String name, String reason) {
        Message errorMessage = new Message();

        String body = String.format("Good %s %s!\n" +
                "We have to inform You that today our service not available due to the %s.\n" +
                "We hope that will be able to fix it ASAP.\n" +
                "Really sorry for this worry!\n" +
                "Thank you to choosing us! %s",
                formatGreetingByTime(), name, LocalDate.now().toString(), sign());

        errorMessage.setTopic("Important information");
        errorMessage.setBody(body);

        return errorMessage;
    }

    @Override
    public Message formatGreetingMessage(String name) {
        Message greetingMessage = new Message();

        String body = String.format("Good %s, %s!\n" +
                "Thank you for subscribing us!\n" +
                "We hope You will really enjoy our service! %s",
                formatGreetingByTime(), name, LocalDate.now().toString(), sign());

        greetingMessage.setTopic("Greeting!");
        greetingMessage.setBody(body);

        return greetingMessage;
    }

    private String formatGreetingByTime() {
        LocalTime dateTime = LocalTime.now();

        int hour = dateTime.getHour();

        if (hour >= 5 && hour < 12) {
            return "morning";
        } else if (hour >= 12 &&  hour < 17) {
            return "afternoon";
        } else if (hour >= 17 && hour < 21) {
            return "evening";
        } else if (hour >=21 || hour < 4) {
            return "night";
        }

        return "time";
    }

    private String sign() {
        return String
                .format("\n\n" +
                        "With kind regards, \n %s", AUTHOR);
    }
}
