package com.bookstore.bookservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookstore.bookservice.model.Book;
import com.bookstore.bookservice.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}

	@GetMapping("/{id}")
	public Book getBook(@PathVariable Long id){
		return service.getBook(id);
	}

	@PostMapping
	public Book createBook(@RequestBody Book book){
		return service.createBook(book);
	}

	@PutMapping("/{id}")
	public Book updateBook(@PathVariable Long id,@RequestBody Book book){
		return service.updateBook(id,book);
	}

	@DeleteMapping("/{id}")
	public void deleteBook(@PathVariable Long id){
		service.deleteBook(id);
	}
}