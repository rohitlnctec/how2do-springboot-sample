package com.how2do.user.management.payload;

import java.util.Date;

import com.how2do.user.management.entity.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserPayload {

	private String id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Date createdDate;
	private SubsciptionPayload subsciptions;
	
	public User mapToModel() {
		
		return new User(getFirstName(), getLastName(), getAge());
		
	}
	
	
	public UserPayload(User user) {
		setId(user.getId());
		setFirstName(user.getFirstName());
		setLastName(user.getLastName());
		setAge(user.getAge());
		setCreatedDate(user.getCreatedDate());
	}
	
	public UserPayload(String firstName, String lastName, Integer age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	
	public UserPayload(User user, SubsciptionPayload subsciptionPayload) {
		this(user);
		setSubsciptions(subsciptionPayload);
	}
	
}
