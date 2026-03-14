package com.user_service.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user_service.user_service.PaymentFeignClient;
import com.user_service.user_service.Service.UserService;
import com.user_service.user_service.entity.UserInformation;

@RestController
@CrossOrigin(origins="*")
public class UserController {
	
	@Autowired
	private PaymentFeignClient payment;
	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}
	
	@PostMapping("/create")
	public String create(@RequestBody UserInformation info) {
		return service.createUser(info);
	}
	
	@GetMapping("/{email}") //We are not using here request mapping, we are changing things in application properties, server.servlet.context-path=/user, this will work same as @RequestMapping
	public UserInformation findById(@PathVariable String email) {
		return service.findUser(email);
	}
	
	@GetMapping("/info")
	public String info() {
		System.err.println("Hii");
		return "hi";
		}
	
	@GetMapping("/pay")
	public List<String> getPayment(){
		return payment.paymentOption();
	}

}
