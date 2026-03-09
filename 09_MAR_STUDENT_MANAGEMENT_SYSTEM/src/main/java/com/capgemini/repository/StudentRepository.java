package com.capgemini.repository;




import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.Student;


public interface StudentRepository extends JpaRepository<Student,Long>{

}