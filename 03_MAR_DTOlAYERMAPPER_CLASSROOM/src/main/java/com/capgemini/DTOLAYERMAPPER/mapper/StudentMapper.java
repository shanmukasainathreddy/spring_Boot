package com.capgemini.DTOLAYERMAPPER.mapper;

import com.capgemini.DTOLAYERMAPPER.dto.StudentDTO;
import com.capgemini.DTOLAYERMAPPER.entity.Student;

public class StudentMapper {
	
	public static Student createStudent(StudentDTO dto) {
		Student s = new Student();
		s.setName(dto.getName());
		s.setGender(dto.getGender());
		s.setMarks(dto.getMarks());
		s.setCollege(dto.getCollege());
		s.setEmail(dto.getEmail());
		s.setPhone(dto.getPhone());
		
		return s;
	}
	
	public static StudentDTO createStudentDTO(Student s) {
		StudentDTO dto = new StudentDTO();
		dto.setName(s.getName());
		dto.setCollege(s.getCollege());
		dto.setMarks(s.getMarks());
		
		return dto;
	}
}
