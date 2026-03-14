package com.bookstore.orderservice.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.orderservice.client.BookClient;
import com.bookstore.orderservice.dto.BookDTO;
import com.bookstore.orderservice.model.Order;
import com.bookstore.orderservice.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private BookClient bookClient;

	public Order createOrder(Order order){

		BookDTO book = bookClient.getBookById(order.getBookId());

		order.setTotalPrice(book.getPrice()*order.getQuantity());
		order.setStatus("PLACED");
		order.setOrderDate(LocalDate.now());

		return repo.save(order);
	}

	public List<Order> getAllOrders(){
		return repo.findAll();
	}

	public Order getOrder(Long id){
		return repo.findById(id).orElse(null);
	}

	public Order updateStatus(Long id,Order order){
		Order existing = repo.findById(id).orElse(null);
		if(existing!=null){
			existing.setStatus(order.getStatus());
			return repo.save(existing);
		}
		return null;
	}

	public void deleteOrder(Long id){
		repo.deleteById(id);
	}
}