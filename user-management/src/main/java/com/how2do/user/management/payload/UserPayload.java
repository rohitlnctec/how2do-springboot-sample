package com.how2do.user.management.payload;

import java.util.Date;

import com.how2do.user.management.entity.User;

public class UserPayload {

	private String id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Date createdDate;
	private SubsciptionPayload subsciptions;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public SubsciptionPayload getSubsciptions() {
		return subsciptions;
	}
	public void setSubsciptions(SubsciptionPayload subsciptions) {
		this.subsciptions = subsciptions;
	}
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
	
	public UserPayload() {
	}
	
	public UserPayload(User user, SubsciptionPayload subsciptionPayload) {
		this(user);
		setSubsciptions(subsciptionPayload);
	}
	
}
