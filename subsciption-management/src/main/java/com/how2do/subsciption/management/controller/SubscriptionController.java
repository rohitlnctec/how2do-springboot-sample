package com.how2do.subsciption.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.how2do.subsciption.management.payload.SubsciptionPayload;
import com.how2do.subsciption.management.service.SubscriptionService;

@RestController
@RequestMapping("/subscription/user")
public class SubscriptionController {

	private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);
	
	@Autowired
	protected SubscriptionService subscriptionService;

	@GetMapping(value = "/{userId}/default")
	public ResponseEntity<SubsciptionPayload> createUser(@PathVariable String userId) {

		logger.info("Receive request to create user");

		try {
			SubsciptionPayload data = subscriptionService.createSubscription(userId);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		

	}


	@GetMapping(value = "/{userId}")
	public ResponseEntity<SubsciptionPayload> getUser(@PathVariable String userId) {

		logger.info("Receive request to get user");

		try {
			SubsciptionPayload data = subscriptionService.getSubscription(userId);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	
}
