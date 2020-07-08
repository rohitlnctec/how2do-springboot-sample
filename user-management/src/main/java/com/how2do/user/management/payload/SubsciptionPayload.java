package com.how2do.user.management.payload;

import java.util.Date;

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
	
}
