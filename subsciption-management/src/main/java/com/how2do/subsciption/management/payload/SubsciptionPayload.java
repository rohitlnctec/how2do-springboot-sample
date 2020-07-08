package com.how2do.subsciption.management.payload;

import java.util.Date;

import com.how2do.subsciption.management.entity.Subscription;

public class SubsciptionPayload {

	private Date startDate;
	private Date expiaryDate;

	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getExpiaryDate() {
		return expiaryDate;
	}
	public void setExpiaryDate(Date expiaryDate) {
		this.expiaryDate = expiaryDate;
	}
	
	
	public SubsciptionPayload(Date startDate, Date expiaryDate) {
		super();
		this.startDate = startDate;
		this.expiaryDate = expiaryDate;
	}
	
	public SubsciptionPayload() {
		super();
	}
	public SubsciptionPayload(Subscription subscription) {
		
		if(subscription != null) {
			setStartDate(subscription.getStartDate());
			setExpiaryDate(subscription.getExpiaryDate());
		}
	}
	

	
}
