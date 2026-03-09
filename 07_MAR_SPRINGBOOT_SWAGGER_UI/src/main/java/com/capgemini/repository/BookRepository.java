package com.capgemini.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.capgemini.entity.Book;


public interface BookRepository extends JpaRepository<Book, Long> {

}