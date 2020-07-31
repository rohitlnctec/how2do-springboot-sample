package com.how2do.user.management.services;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.how2do.user.management.entity.User;
import com.how2do.user.management.payload.SubsciptionPayload;
import com.how2do.user.management.payload.UserPayload;
import com.how2do.user.management.repository.UserRepository;


@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	protected UserRepository userRepository;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	public UserPayload createUser(UserPayload payload) {

		if (StringUtils.isEmpty(payload.getFirstName()) || StringUtils.isEmpty(payload.getLastName())
				|| payload.getAge() == null || payload.getAge() < 10) {

			throw new IllegalArgumentException("Invalid Data");

		}
		
		User user = payload.mapToModel();
		user.setCreatedDate(new Date());
		
		userRepository.save(user);
		
		return new UserPayload(user);
	}
	
	
	public UserPayload getUser(String userId) {
		
		User user = userRepository.findOne(userId);
		
		if(user == null)
			throw new IllegalArgumentException();
		
		SubsciptionPayload subsciptionPayload = getSubsciptionDate(userId);
		return new UserPayload(user, subsciptionPayload);
		
	}
	
	
	private SubsciptionPayload getSubsciptionDate(String userId) {
		
		String url = "http://localhost:8082/subscription/user/"+ userId;
		
		ResponseEntity<SubsciptionPayload> responseEntity;
		try {
			responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, SubsciptionPayload.class);
			logger.info("Get Enterprise response status: {}", responseEntity.getStatusCode());
			return responseEntity.getBody();
		} catch (HttpStatusCodeException exception) {
			logger.error("Get Enterprise response status : {} & body : {}", exception.getStatusCode(),
					exception.getResponseBodyAsString());
		} catch (ResourceAccessException resourceAccessException) {
//			throw new ResourceAccessException("Internal Server Error");
		}
		
		return null;
	}
}
