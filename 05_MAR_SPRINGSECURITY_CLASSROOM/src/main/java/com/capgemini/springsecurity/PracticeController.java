package com.capgemini.springsecurity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PracticeController {
	
	@GetMapping("/practices")
	public String getDetails() {
		return "Details";
	}
	
	@GetMapping("/admin")
	public String deleteUser() {
		return "Delete";
	}

}
