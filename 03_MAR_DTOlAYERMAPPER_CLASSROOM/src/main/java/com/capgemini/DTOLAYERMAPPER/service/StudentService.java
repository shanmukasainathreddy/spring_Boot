package com.capgemini.DTOLAYERMAPPER.service;

import org.springframework.stereotype.Service;

import com.capgemini.DTOLAYERMAPPER.dto.StudentDTO;
import com.capgemini.DTOLAYERMAPPER.entity.Student;
import com.capgemini.DTOLAYERMAPPER.mapper.StudentMapper;
import com.capgemini.DTOLAYERMAPPER.repository.StudentJpaRepository;

@Service
public class StudentService {
	
	StudentJpaRepository jpa;
	
	public StudentService(StudentJpaRepository jpa) {
		this.jpa = jpa;
	}
	
	public StudentDTO addStudent(StudentDTO dto) {
		Student s = StudentMapper.createStudent(dto);
		 jpa.save(s);
		 return StudentMapper.createStudentDTO(s);
	}
	
	public StudentDTO getByid(int  id) {
		Student s =  jpa.findById(id).orElseThrow(()-> new RuntimeException("IOException"));
		return StudentMapper.createStudentDTO(s);
	
	}
}