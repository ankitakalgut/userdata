package com.example.userdata.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="persons")
public class Person {
private static final long serialVersionUID = 1L;
	
	@Id
	private String id;

	private String firstName;
	private String lastName;
	private String emailid;
	private String password;
	
	public String getId()
	{
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", emailid=" + emailid
				+ ", password=" + password + "]";
	}
	public Person(String id, String firstName, String lastName, String emailid, String password) 
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailid = emailid;
		this.password = password;
	}
	
	public Person()
	{
		
	}
	
}
