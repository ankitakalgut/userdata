package com.example.userdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.userdata.model.LoginDTO;
import com.example.userdata.model.Person;
import com.example.userdata.repository.PersonRepository;
import com.example.userdata.service.PersonService;
import com.example.userdata.utility.Response;

@RestController
public class PersonController 
{	
	@Autowired PersonService personService;
	
	@Autowired PersonRepository personRepository;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@RequestBody Person person)
	{
	personService.registerPerson(person);
	return new ResponseEntity<>(new Response("Registration Success", HttpStatus.CREATED), HttpStatus.OK);	
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginDTO loginDTO)
	{
		personService.loginPerson(loginDTO);
		return new  ResponseEntity<>(new Response("Login Succcess",HttpStatus.ACCEPTED),HttpStatus.OK);
	}
	
	@GetMapping("/getAllusers")
	public List<Person> getUsers()
	{
		return personRepository.findAll();
	}

	@PostMapping("/getUserId/{id}")
	public void getUserById2(@PathVariable String id)
	{
		personService.getPersonById(id);
	}
}