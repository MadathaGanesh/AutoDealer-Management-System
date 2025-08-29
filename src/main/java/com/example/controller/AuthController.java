package com.example.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.JwtUtil;
import com.example.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtutil;
	private final UserService userservice;
	
	public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtutil, UserService userservice) {
		this.authenticationManager = authenticationManager;
		this.jwtutil = jwtutil;
		this.userservice = userservice;
	}
	
	public static class AuthRequest{
		public String username;
		public String password;
	}
	
	@PostMapping("/register")
	public String register(@RequestBody AuthRequest request) {
		userservice.registerUser(request.username, request.password);
		return "User registered successfully";
	}
	
	
	@PostMapping("/login")
	public String login(@RequestBody AuthRequest request) {
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.username, request.password));
		return jwtutil.generateToken(authentication.getName());
	}
	
	
}
