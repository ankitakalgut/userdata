package com.example.userdata.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Configuration;

public class Validation
{

	public static void validateEmailId(String emailid)
	{
		  final String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	      //Matching the given phone number with regular expression
	      boolean result = emailid.matches(regex);
	      if(result) 
	      {
	         System.out.println("Given email-id is valid");
	      }
	      else {
	         throw new PersonExceptionHandler("Given email-id is not valid");
	      }
	   }
	
	public static boolean PasswordValidator (String password){

	    // digit + lowercase char + uppercase char + punctuation + symbol
	    final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

	    final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

	        Matcher matcher = pattern.matcher(password);
	        return matcher.matches();
	    }

	
	}
