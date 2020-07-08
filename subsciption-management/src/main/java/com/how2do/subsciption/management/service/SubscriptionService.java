package com.how2do.subsciption.management.service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.how2do.subsciption.management.entity.Subscription;
import com.how2do.subsciption.management.payload.SubsciptionPayload;
import com.how2do.subsciption.management.repository.SubscriptionRepository;


@Service
public class SubscriptionService {

	private static final Logger logger = LoggerFactory.getLogger(SubscriptionService.class);
	
	@Autowired
	protected SubscriptionRepository subscriptionRepository;

	
	public SubsciptionPayload createSubscription(String userId) {
		
		Subscription subscription = subscriptionRepository.findByUserId(userId);
		
		if(subscription == null) {
			subscription = new Subscription();
			subscription.setStartDate(new Date());
			subscription.setExpiaryDate(Date.from(Instant.now().plus(7, ChronoUnit.DAYS)));
			
		} else {
			subscription.setStartDate(new Date());
			subscription.setExpiaryDate(Date.from(Instant.now().plus(7, ChronoUnit.DAYS)));
		}
		
		subscription.setUserId(userId);
		subscriptionRepository.save(subscription);
		
		return new SubsciptionPayload(subscription);
	}
	
	

	public SubsciptionPayload getSubscription(String userId) {
		
		Subscription subscription = subscriptionRepository.findByUserId(userId);
		return new SubsciptionPayload(subscription);
		
	}
	
	
}
