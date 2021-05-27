package com.example.emailscheduler.repository;

import com.example.emailscheduler.model.Subscriber;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubscriberRepository extends JpaRepository<Subscriber, Integer> {

    Optional<Subscriber> getSubscriberByEmail(String email);

    void deleteSubscriberByEmail(String email);
}
