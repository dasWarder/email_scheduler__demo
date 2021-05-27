package com.example.emailscheduler.controller;

import com.example.emailscheduler.model.Subscriber;
import com.example.emailscheduler.service.subscriber.SubscriberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Slf4j
@Controller
public class SubscriberController {

    private SubscriberService subscriberService;

    @Autowired
    public SubscriberController(SubscriberService subscriberService) {
        this.subscriberService = subscriberService;
    }

    @GetMapping("/")
    public String getForm(Model model) {
        log.info("Add a new subscriber to the model");

        model.addAttribute("subscriber", new Subscriber());

        return "subscription";
    }

    @PostMapping("/subscribe")
    public String subscribe(@ModelAttribute("subscriber") Subscriber subscriber) {
        log.info("The attempt to create a new subscriber");

        Subscriber storedSub = subscriberService.save(subscriber);

        log.info("The subscriber with id={} was successfully subscribed", storedSub.getId());

        return "successful";
    }
}
