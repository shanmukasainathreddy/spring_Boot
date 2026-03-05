package com.capgemini.cachepractice.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.capgemini.cachepractice.entity.Product;
import com.capgemini.cachepractice.repository.ProductRepository;



@Service
public class ProductService {
	private ProductRepository repository;
	
	public ProductService(ProductRepository repository) {
		this.repository = repository;
	}
	
	@CachePut(cacheNames = "product" ,key="#result.id")
	public Product addProduct(Product p) {
		return repository.save(p);
	}
	
	@Cacheable(cacheNames="product",key="#id")
	public Product getById(int id) {
		return repository.findById(id).orElseThrow(()->new RuntimeException("Id not present"));
	}
	
	@CachePut(cacheNames = "product", key = "#result.id")
	public Product updateProduct(Product p) {
		Product existing = repository.findById(p.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));
		
		existing.setName(p.getName());
		
		return repository.save(existing);
	}
	
	@CacheEvict(cacheNames = "product", key = "#id")
    public void deleteProduct(int id) {

        if (!repository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }

        repository.deleteById(id);
    }

}