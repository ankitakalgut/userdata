package com.example.userdata.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userdata.model.LoginDTO;
import com.example.userdata.model.Person;
import com.example.userdata.repository.PersonRepository;
import com.example.userdata.service.PersonService;
import com.example.userdata.utility.PersonExceptionHandler;
import com.example.userdata.jwt.JWTCreation;
import com.example.userdata.utility.Validation;


@Service
public class PersonServiceImpl implements PersonService
{

	@Autowired
	PersonRepository personRepository;

	@Autowired
	JWTCreation JWTCreation;
	
	@Override
	public void registerPerson(Person person)
	{
	
		Person addperson=new Person();
		System.out.println("fisrtName is"+person.getFirstName());
		person.getFirstName().matches("^\\S*$");
		person.getLastName().matches("^\\S*$");
		if(person.getFirstName().isEmpty()||person.getLastName().isEmpty())
		{
			throw new PersonExceptionHandler("plesase fill all the details");
		}
		else
		Validation.validateEmailId(person.getEmailid());
		if(!Validation.PasswordValidator(person.getPassword()))
		{
			throw new PersonExceptionHandler("Password doesnt match the criteria");
		}
		else
		addperson=personRepository.findByemailid(person.getEmailid());
		if(addperson==null)
		{
			personRepository.save(person);
			String token=JWTCreation.createJWT(person);
			System.out.println(token);		
		}
		else
			
		{
			throw new PersonExceptionHandler("User already exists");
		}	
	}

	
	
	public Person getPersonById(String id)
	{
		return personRepository.findByid(id);
	}
	
	
	

	@Override
	public void loginPerson(LoginDTO loginDTO)
	{
		Person person=personRepository.findByemailid(loginDTO.getEmailid());
		if(person!=null)
		{
			if(person.getPassword().matches(loginDTO.getPassword()))
				{
				System.out.println("Login Success");
				
				}
			else
			{
				throw new PersonExceptionHandler("Incorrect Password");
			}	
		}
		else
		{
			throw new PersonExceptionHandler("Email id doesnt exists");
		}	
	}
}
