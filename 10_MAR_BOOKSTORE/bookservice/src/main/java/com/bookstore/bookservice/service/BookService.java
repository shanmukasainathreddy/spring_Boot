package com.bookstore.bookservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository repo;

	public Book createBook(Book book){
		return repo.save(book);
	}

	public List<Book> getAllBooks(){
		return repo.findAll();
	}

	public Book getBook(Long id){
		return repo.findById(id).orElse(null);
	}

	public Book updateBook(Long id,Book book){
		book.setId(id);
		return repo.save(book);
	}

	public void deleteBook(Long id){
		repo.deleteById(id);
	}
}