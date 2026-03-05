package com.capgemini.DTOLAYERMAPPER.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.DTOLAYERMAPPER.dto.StudentDTO;
import com.capgemini.DTOLAYERMAPPER.service.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentContoller {

	private StudentService service;
	
	public StudentContoller(StudentService service) {
		super();
		this.service=service;
	}
	
	@PostMapping("/create")
	public StudentDTO addStudent(@Valid @RequestBody StudentDTO dto) {
		return service.addStudent(dto);
	}
	
	@GetMapping("/findby/{id}")
	public StudentDTO findByid(@PathVariable int id) {
		return service.getByid(id);
	}
}
