package com.example.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.AppUser;
import com.example.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

    private final PasswordEncoder passwordEncoder;

	private final UserRepository userrepository;
	
	public UserService(UserRepository userrepository, PasswordEncoder passwordEncoder) {
		this.userrepository = userrepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        AppUser user = userrepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .authorities("USER") // simple authority
                .build();
	}

	// Method to register new users with encoded password and unique username check.
	public AppUser registerUser(String username,String rawPassword) {
		if(userrepository.findByUsername(username).isPresent()) {
			throw new RuntimeException("Username already exists !");
		}
		AppUser newUser = new AppUser();
		newUser.setUsername(username);
		newUser.setPassword(passwordEncoder.encode(rawPassword));
		return userrepository.save(newUser);
	}
}
