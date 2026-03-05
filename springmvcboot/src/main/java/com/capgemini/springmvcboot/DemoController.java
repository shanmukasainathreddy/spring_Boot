package com.capgemini.springmvcboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class DemoController {
	@Autowired
	UsersJpaRepo jpa;
	//for welcome.jsp
	@GetMapping("/hello")
	public String getHi() {
		return "welcome";
	}
	
	//create end point for register
	//http://localhost:8080/register
	@GetMapping("/register")
	public String createAccount() { 
		return "register";
		
	}
	
	//HttpServletRequest will help to read data from url
	//http://localhost:8080/create-account
//	@PostMapping("/create-account")
//	public String register(HttpServletRequest request) {
//		String name = request.getParameter("name");
//		String email = request.getParameter("email");
//		String number = request.getParameter("number");
//		
//		System.out.println(name);
//		System.out.println(email);
//		System.out.println(number);
//		
//		return "success";
//	}
	
	
//	//Data binding
//	@PostMapping("/create-account")
//	public String register(@ModelAttribute Users users) {
//		System.out.println(users.getName());
//		System.out.println(users.getEmail());
//		System.out.println(users.getNumber());
//		
//		return "success";
//	}
	
	@PostMapping("/create-account")
	public String register(@ModelAttribute Users users) {
		jpa.save(users);
		return "success";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/logincheck")
	public String logincheck(HttpServletRequest request) {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		Users user = jpa.findByEmailAndPassword(email, password);
		if(user != null) {
			return "loginsuccess";
		} else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/hi")
	public ModelAndView sendData() {
		ModelAndView m = new ModelAndView();
		List<String> names = List.of("Miller","Allen","Smith");
		m.addObject("msg",names);
		m.setViewName("abc");
		return m;
	}
}