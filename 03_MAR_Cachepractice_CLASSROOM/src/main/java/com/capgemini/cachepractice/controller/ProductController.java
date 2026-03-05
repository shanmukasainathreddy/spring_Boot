package com.capgemini.cachepractice.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.cachepractice.entity.Product;
import com.capgemini.cachepractice.service.ProductService;
@RestController
public class ProductController {
//	private ProductRepository repository;
//	public ProductController(ProductRepository repository) {
//		this.repository=repository;
//	}
	
	private ProductService service;
	public ProductController(ProductService service) {
		super();
		this.service=service;
	}
	
	@PostMapping("/create")
	public Product addProduct(@RequestBody Product p) {
		return service.addProduct(p);
	}
	
	@GetMapping("/find-id/{id}") 
	public Product getProductById(@PathVariable int id) {
		return service.getById(id);
	}
	
	@PutMapping("/update")
    public Product updateProduct(@RequestBody Product p) {
        return service.updateProduct(p);
    }
	
	@DeleteMapping("/delete-id/{id}")
    public String deleteProduct(@PathVariable int id) {
        service.deleteProduct(id);
        return "Product deleted successfully";
    }

}