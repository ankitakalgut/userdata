package com.example.userdata.utility;

public class PersonExceptionHandler extends RuntimeException

{
	private static final long serialVersionUID = 1L;
	
	public PersonExceptionHandler(String message)
	{
		super(message);
	}

}
