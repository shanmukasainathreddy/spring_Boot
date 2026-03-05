package com.capgemini.cachepractice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.cachepractice.entity.FileData;

@Repository
public interface FileRepository extends JpaRepository<FileData,Integer>{

}