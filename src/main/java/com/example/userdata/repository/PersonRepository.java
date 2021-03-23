package com.example.userdata.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.userdata.model.Person;

public interface PersonRepository extends MongoRepository<Person,String>  
{

	public Person findByemailid(String email);
	public Person findByPassword(String password);
	public Person findByid(String id);
	
}
