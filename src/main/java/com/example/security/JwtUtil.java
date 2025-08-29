package com.example.security;


import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {


	private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private final long jwtExpirationMs = 3600000;

	
	public String generateToken(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs))
				.signWith(key)
				.compact();
	}
	
	public String getUsernameFromToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key)
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean validateToken(String token) {
		try {
			Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
			return true;
		} catch (io.jsonwebtoken.security.SecurityException | MalformedJwtException e) {
			System.err.println("Invalid JWT Signature : " +e.getMessage());
		}catch (ExpiredJwtException e) {
			System.err.println("JWT token is expired : "+e.getMessage());
		}catch(UnsupportedJwtException e) {
			System.err.println("JWT token is unsupported : " +e.getMessage());
		}catch(IllegalArgumentException e) {
			System.err.println("JWT Claims string is empty : "+e.getMessage());
		}
		return false;
	}
}
