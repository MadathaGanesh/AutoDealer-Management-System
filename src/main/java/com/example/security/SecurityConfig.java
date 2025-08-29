package com.example.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtfilter;
	private final UserDetailsService userdetailservice;
	
	public SecurityConfig(JwtAuthenticationFilter jwtfilter, UserDetailsService userdetailservice) {
		this.jwtfilter = jwtfilter;
		this.userdetailservice = userdetailservice;
	}
	

	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		 http.csrf(csrf -> csrf.disable())
		    .authorizeHttpRequests(auth -> auth
		        .requestMatchers("/auth/**").permitAll()   // your public endpoints
		        .requestMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger-ui.html").permitAll()  // allow swagger
		        .anyRequest().authenticated()
		    )
	            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
	            .addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
	        return http.build();
	    }
	 
	 @Bean
	 public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
		 return config.getAuthenticationManager();
	 }
}
