package com.how2do.user.management.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "user")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class User {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Date createdDate;


	public User(String firstName, String lastName, Integer age) {
		setFirstName(firstName);
		setLastName(lastName);
		setAge(age);
	}



}
