package com.example.userdata.jwt;

import com.example.userdata.model.Person;
import com.example.userdata.utility.JWTException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.util.Date;    

public class JWTCreation{
	
	public String createJWT(Person person){
	SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	JwtBuilder builder = Jwts.builder()
			.setSubject(person.getEmailid())
			.setExpiration(new Date((System.currentTimeMillis()+600000)))
			.setIssuedAt(new Date())
			.setIssuer(person.getId())
			.signWith(signatureAlgorithm, "passKey");
			return builder.compact();}
	
	public static Claims verifyToken(String token) {
	try{
		Claims claims = Jwts.parser()
				.setSigningKey("passKey")
				.parseClaimsJws(token).
				getBody();
		return claims;} 
	catch (UnsupportedJwtException | MalformedJwtException | SignatureException | IllegalArgumentException e) 
	{
		throw new JWTException("Error in verifying JW Token");
	} 
	catch (ExpiredJwtException e) 
	{
		throw new JWTException("Token Expired");
	}
}
}