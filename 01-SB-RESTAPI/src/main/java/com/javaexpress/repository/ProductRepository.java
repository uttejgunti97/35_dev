package com.javaexpress.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javaexpress.entity.Product;
import com.javaexpress.entity.User;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	// DSL Methods
		Product findByname(String name);
		
	// DSL Method	
		List<Product> findByCategoryName(String categoryName);
		
		
		
		
	

}
