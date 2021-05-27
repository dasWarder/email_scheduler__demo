package com.example.emailscheduler.service.subscriber;

import com.example.emailscheduler.model.Subscriber;

public interface SubscriberService {

    Subscriber save(Subscriber subscriber);

    Subscriber getById(int subscriberId);

    void deleteById(int subscriberId);

    Subscriber getByEmail(String email);

    void deleteByEmail(String email);
}
