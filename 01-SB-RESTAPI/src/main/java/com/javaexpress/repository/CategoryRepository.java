package com.javaexpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaexpress.entity.Category;
import com.javaexpress.entity.Product;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	
	// DSL Methods
		Category findByname(String name);
		
		Category findByProducts(List<Product> products);
}
