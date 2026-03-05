package com.capgemini.DTOLAYERMAPPER.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	int id;
	String name;
	double costprice;
	double sellingprice;
	int quantity;
}
