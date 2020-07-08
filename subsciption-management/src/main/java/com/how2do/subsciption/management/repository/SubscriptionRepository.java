package com.how2do.subsciption.management.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.how2do.subsciption.management.entity.Subscription;

@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {

	Subscription findByUserId(String userId);

}
