package com.how2do.subsciption.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.how2do.subsciption.management.payload.SubsciptionPayload;
import com.how2do.subsciption.management.service.SubscriptionService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/subscription/user")
@Api(value = "/subscription/user", tags = "Subscription Management")
public class SubscriptionController {

	private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);
	
	@Autowired
	protected SubscriptionService subscriptionService;

	@GetMapping(value = "/{userId}/default")
	@ApiOperation(value = "Create Default Subscription", notes = "Create Default Subscription for new user", tags = { "Subscription Management" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Default Subscription Data"),
			@ApiResponse(code = 404, message = "Invalid userId"),
			@ApiResponse(code = 500, message = "Internal server error") })
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
	@ApiOperation(value = "Get Subscription", notes = "Get User Subscription", tags = { "Subscription Management" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "User Subscription Data"),
			@ApiResponse(code = 404, message = "Invalid userId"),
			@ApiResponse(code = 500, message = "Internal server error") })
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
