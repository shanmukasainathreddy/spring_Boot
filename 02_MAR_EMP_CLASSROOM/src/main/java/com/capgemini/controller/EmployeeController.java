package com.capgemini.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.Employee;
import com.capgemini.service.EmployeeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/register")
	public String regsiter() {
		return "register";
	}
	
	@PostMapping("/create")
	public ModelAndView create(@ModelAttribute Employee e) {
		return service.createEmployee(e);
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/logincheck")
	public ModelAndView getDetails(HttpServletRequest request) {
		return service.login(request.getParameter("email"), request.getParameter("password"));
	}
	//for delete
		@PostMapping("/delete-selected")
		public ModelAndView deleteSelected(@RequestParam(value="selectedEmails",required=false)
		List<String> emails) {
			return service.deleteSelected(emails);
		}

		 @GetMapping("/listEmployee")
		    public ModelAndView listEmployee() {
		        return service.getAllEmployees();
		    }
		 
		 //for update
		 @PostMapping("/update-selected")
		 public ModelAndView updateSelected(
		         @RequestParam("selectedEmail") String email) {

		     return service.getEmployeeForUpdate(email);
		 }
		 
		 @PostMapping("/update-employee")
		 public ModelAndView updateEmployee(Employee emp) {

		     return service.updateEmployee(emp);
		 }
		    
		
		    
	}
