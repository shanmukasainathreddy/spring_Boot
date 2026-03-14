package com.bookstore.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bookstore.orderservice.model.Order;
import com.bookstore.orderservice.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService service;

	@GetMapping
	public List<Order> getAllOrders(){
		return service.getAllOrders();
	}

	@GetMapping("/{id}")
	public Order getOrder(@PathVariable Long id){
		return service.getOrder(id);
	}

	@PostMapping
	public Order createOrder(@RequestBody Order order){
		return service.createOrder(order);
	}

	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable Long id,@RequestBody Order order){
		return service.updateStatus(id,order);
	}

	@DeleteMapping("/{id}")
	public void deleteOrder(@PathVariable Long id){
		service.deleteOrder(id);
	}
}