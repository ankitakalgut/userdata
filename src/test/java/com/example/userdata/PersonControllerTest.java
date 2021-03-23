package com.example.userdata;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.example.userdata.serviceimpl.PersonServiceImpl;
import com.example.userdata.model.Person;
import com.example.userdata.repository.PersonRepository;
import com.example.userdata.service.PersonService;

import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= UserdataApplication.class)
@SpringBootTest
public class PersonControllerTest
{

	@Autowired
	private PersonServiceImpl PersonServiceImpl;
	
	@MockBean
	private PersonRepository PersonRepository;
	
	@Test
	public void getPersonByIdTest() 
	{
		Person person=new Person("1","Anks","kal","email","14");
		String id="1";
		when(PersonRepository.findByid(id)).thenReturn(person);
		assertEquals(person,PersonServiceImpl.getPersonById(id));
	}

	@Test
	public void registerPersonTest()
	{
		Person person=new Person("1","Anks","kal","email","14");
		when(PersonRepository.save(person)).thenReturn(person);
		assertEquals(person,);
	
		
	}

}
	
