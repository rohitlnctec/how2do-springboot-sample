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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/user")
@Api(value = "/user", tags = "User Management")
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	protected UserService userService;

	@PostMapping(value = "/")
	@ApiOperation(value = "Create User", notes = "Create new user", tags = { "User Management" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "User Created successfully"),
			@ApiResponse(code = 404, message = "Invalid data"),
			@ApiResponse(code = 500, message = "Internal server error") })
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
		
		return new ResponseEntity<>("Update Test Success", HttpStatus.OK);
		

	}

	@GetMapping(value = "/{userId}")
	@ApiOperation(value = "Get User", notes = "Get user details", tags = { "User Management" })
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "User data"),
			@ApiResponse(code = 404, message = "Invalid userId"),
			@ApiResponse(code = 500, message = "Internal server error") })
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

		return new ResponseEntity<>("Delete Test Success", HttpStatus.OK);

	}
}
