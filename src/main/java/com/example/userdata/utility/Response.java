package com.example.userdata.utility;

import org.springframework.http.HttpStatus;

public class Response 
{
	private String message;
	private HttpStatus HttpStatus;
	private int code;
	
	public Response(String message, org.springframework.http.HttpStatus httpStatus) 
	{
		super();
		this.message = message;
		HttpStatus = httpStatus;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public HttpStatus getHttpStatus() {
		return HttpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		HttpStatus = httpStatus;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
}

	
	
	