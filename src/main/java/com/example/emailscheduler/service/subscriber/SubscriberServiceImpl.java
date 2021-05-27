package com.example.emailscheduler.service.subscriber;

import com.example.emailscheduler.exception.SubscriberNotFoundException;
import com.example.emailscheduler.model.Message;
import com.example.emailscheduler.model.Subscriber;
import com.example.emailscheduler.repository.SubscriberRepository;
import com.example.emailscheduler.service.email.sender.EmailService;
import com.example.emailscheduler.service.formatter.MessageFormatterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.util.Assert.notNull;

@Slf4j
@Service
public class SubscriberServiceImpl implements SubscriberService {

    private SubscriberRepository subscriberRepository;

    private MessageFormatterService messageFormatterService;

    private EmailService emailService;

    public SubscriberServiceImpl(SubscriberRepository subscriberRepository,
                                 MessageFormatterService messageFormatterService,
                                 EmailService emailService) {
        this.subscriberRepository = subscriberRepository;
        this.messageFormatterService = messageFormatterService;
        this.emailService = emailService;
    }

    @Override
    public Subscriber save(Subscriber subscriber) {
        log.info("Check the subscriber with email={}", subscriber.getEmail());

        notNull(subscriber, "The subscriber must be not NULL");
        Subscriber storedSub = subscriberRepository.save(subscriber);

        log.info("The subscriber with id={}", storedSub.getId());

        if(getByEmail(subscriber.getEmail()) == null) {
            log.info("Greeting a new subscriber with id={} by email", storedSub.getId());

            Message greetingMessage = messageFormatterService.formatGreetingMessage(subscriber.getName());
            emailService.sendEmail(greetingMessage);

            log.info("Greeting by email for the subscriber with id={} was successfully completed", storedSub.getId());
        }

        return storedSub;
    }

    @Override
    public Subscriber getById(int subscriberId) {
        log.info("The attempt to get subscriber with id={}", subscriberId);

        Subscriber fromDbSub = subscriberRepository.getById(subscriberId);
        notNull(fromDbSub, "The subscriber must be not NULL");

        log.info("The subscriber with id={} was successfully added", subscriberId);
        return fromDbSub;
    }

    @Override
    public void deleteById(int subscriberId) {

        subscriberRepository.deleteById(subscriberId);

        log.info("The customer with id={} was successfully removed", subscriberId);
    }

    @Override
    public Subscriber getByEmail(String email) {
        log.info("The attempt to get the subscriber with email={}", email);
        Optional<Subscriber> subscriberByEmail = subscriberRepository.getSubscriberByEmail(email);

        if(!subscriberByEmail.isPresent()) {
            log.info("The subscriber with email={} not found", email);

            throw new SubscriberNotFoundException(String
                    .format("The subscriber with email={} wasn't founded", email));
        }

        log.info("The subscriber with email={} was successfully received", email);

        return subscriberByEmail.get();
    }

    @Override
    public void deleteByEmail(String email) {

        subscriberRepository.deleteSubscriberByEmail(email);

        log.info("The subscriber with email={} was successfully removed", email);
    }

    @Override
    public List<Subscriber> getAll() {
        log.info("The attempt to get the collection of all subscribers");

        List<Subscriber> subscribers = subscriberRepository.findAll();

        notNull(subscribers, "The collection of subscribers must be not NULL");
        log.info("The collection of subscribers was successfully received");

        return subscribers;
    }
}
