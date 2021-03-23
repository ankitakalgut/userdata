package com.example.userdata.cofiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.userdata.jwt.JWTCreation;

@Configuration
public class BeanConfiguration {

	@Bean
	public JWTCreation jwToken() {
		return new JWTCreation();
	}
}
