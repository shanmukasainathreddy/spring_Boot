package com.capgemini.springmvcboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DemoController {
	
	@Autowired
	UsersJpaRepo jpa;
	
	@GetMapping("/hello")
	public String getHi() {
		return "Welcome";
	}
	
	@GetMapping("/register")
	public String createAccount() {
		return "register";
	}
	
	/*
//@GetMapping("/createAccount") -> it will show detail in link
	@PostMapping("/createAccount")
	public String register(HttpServletRequest request) {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String number = request.getParameter("number");
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(number);
		
		return "sucess";
	}
	*/
	
	@PostMapping("/createAccount")
	public String register(@ModelAttribute Users users) {
//		System.out.println(users.getName());
//		System.out.println(users.getEmail());
//		System.out.println(users.getNumber());
//		
		jpa.save(users); 
		
		return "sucess";

		
	}
	
}
 