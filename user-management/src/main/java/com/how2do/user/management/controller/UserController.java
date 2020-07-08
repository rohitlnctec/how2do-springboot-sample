package com.how2do.user.management.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.how2do.user.management.payload.UserPayload;
import com.how2do.user.management.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	protected UserService userService;

	@PostMapping(value = "/")
	public ResponseEntity<UserPayload> createUser(@RequestBody UserPayload data) {

		logger.info("Receive request to create user");

		try {
			data = userService.createUser(data);
		} catch (Exception exception) {
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(data, HttpStatus.OK);

	}

	@PutMapping(value = "/{userId}")
	public ResponseEntity<String> udpateUser(@PathVariable String userId, @RequestBody String data) {

		logger.info("Receive request to update user");
		

		return new ResponseEntity<>("sdf", HttpStatus.OK);
		

	}

	@GetMapping(value = "/{userId}")
	public ResponseEntity<UserPayload> getUser(@PathVariable String userId) {

		logger.info("Receive request to get user");

		try {
			UserPayload data = userService.getUser(userId);
			return new ResponseEntity<>(data, HttpStatus.OK);
		} catch (Exception exception) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable String userId) {

		logger.info("Receive request to delete user");

		return new ResponseEntity<>("Delete Success", HttpStatus.OK);

	}
}
