package com.how2do.user.management.payload;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class SubsciptionPayload {

	private Date startDate;
	private Date expiaryDate;

	
}
