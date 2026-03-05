package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.capgemini.Employee;
import com.capgemini.EmployeeJpaRepository;

@Service
public class EmployeeService {
	EmployeeJpaRepository jpa;
	 
	public EmployeeService(EmployeeJpaRepository jpa) {
		this.jpa = jpa;
	}
	
	public ModelAndView createEmployee(Employee e) {
		Optional<Employee> optional = jpa.findById(e.getEmail());
		ModelAndView m = new ModelAndView();
		
		if(optional.isPresent()) {
			m.addObject("msg",e.getName());
			m.setViewName("exist");
			return m;
		}else {
			m.addObject("msg",e.getName());
			m.setViewName("successful");
			Employee employee = jpa.save(e);
			return m;
		}
	
	}
	
	public ModelAndView login(String email,String password) {
		Employee e = jpa.findByEmailAndPassword(email,password);
		ModelAndView m = new ModelAndView();
		if(e.getRole().equalsIgnoreCase("admin")) {
			List<Employee> emp = jpa.findAll();
			m.addObject("msg",e);
			m.setViewName("admin");
			return m;
		}else {
			m.addObject("msg",e);
			m.setViewName("userdetails");
			return m;
		}
	}

	//for deletion
		public ModelAndView deleteSelected(List<String> emails) {
			if(emails != null && !emails.isEmpty()) {
				jpa.deleteAllById(emails);
			}
			List<Employee> list = jpa.findAll();
			ModelAndView m = new ModelAndView();
			m.addObject("employees",list);
			m.addObject("isAdmin",true);
			m.setViewName("listEmployee");
			
			return m; 
			
		}
		
		public ModelAndView getAllEmployees() {

		    List<Employee> list = jpa.findAll();

		    ModelAndView m = new ModelAndView();
		    m.addObject("employees", list);
		    m.addObject("isAdmin", true);
		    m.setViewName("listEmployee");

		    return m;
		}
		
		//for update
		public ModelAndView getEmployeeForUpdate(String email) {

		    Employee emp = jpa.findById(email).orElse(null);

		    ModelAndView m = new ModelAndView();

		    m.addObject("employee", emp);
		    m.setViewName("updateEmployee");

		    return m;
		}
		
		public ModelAndView updateEmployee(Employee emp) {

		    jpa.save(emp);

		    List<Employee> list = jpa.findAll();

		    ModelAndView m = new ModelAndView();

		    m.addObject("employees", list);
		    m.addObject("isAdmin", true);
		    m.setViewName("listEmployee");

		    return m;
		}
}
