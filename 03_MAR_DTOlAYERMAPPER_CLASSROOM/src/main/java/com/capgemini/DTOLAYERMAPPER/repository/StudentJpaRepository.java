package com.capgemini.DTOLAYERMAPPER.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.DTOLAYERMAPPER.entity.Student;

public interface StudentJpaRepository extends JpaRepository<Student,Integer> {

}
