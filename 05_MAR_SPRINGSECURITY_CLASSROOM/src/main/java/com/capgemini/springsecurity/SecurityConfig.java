package com.capgemini.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception{
		//singleton -> creates only one instance
		//builder design pattern->object should be created as per the requirement
		 return http.csrf(csrf->csrf.disable())
				 .authorizeHttpRequests(auth->auth
				 .requestMatchers("/practices").permitAll()
				 .requestMatchers("/admin").authenticated()) // user and admin can access
//				 .requestMatchers("/admin").hasRole("ADMIN")) //only specified can access
				 .httpBasic(Customizer.withDefaults())
				 .build();	
		}
	//to create user name and password
	
	@Bean
	public UserDetailsService getUserDetails() {
		UserDetails user = User
				.withUsername("admin")
				.password("{noop}1234")
				.roles("ADMIN")
				.build();
		
		User.withUsername("Dingaa")
		.password("1234")
		.roles("USER")
		.build();
		
		return new InMemoryUserDetailsManager(user);
	}
}