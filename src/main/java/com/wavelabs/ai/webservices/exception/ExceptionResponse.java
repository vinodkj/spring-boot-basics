package com.wavelabs.ai.webservices.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private String message;
	private String details;
	private Date timeStamp;
	public ExceptionResponse() {
	}
	public ExceptionResponse(String message, String details) {
		this.message = message;
		this.details = details;
		this.timeStamp = new Date();
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getDate() {
		return timeStamp;
	}
	public void setDate(Date date) {
		this.timeStamp = date;
	}
	
	
	
	
	

}
