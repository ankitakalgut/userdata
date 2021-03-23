package com.example.userdata.service;

import com.example.userdata.model.LoginDTO;
import com.example.userdata.model.Person;

public interface PersonService{
	
	public void registerPerson(Person person);
	
	public void loginPerson(LoginDTO loginDTO);
	
	public Person getPersonById(String id);
}
