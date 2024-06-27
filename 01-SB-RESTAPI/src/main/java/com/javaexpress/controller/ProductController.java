package com.javaexpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaexpress.entity.Product;
import com.javaexpress.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/product")
@Slf4j
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@PostMapping
	public void createProduct(@RequestBody Product product) {
		productService.createProduct(product);
	}
	
	@GetMapping("{pId}")
	public Product fetchProduct(@PathVariable(name="pId") Long productId) {
		return productService.fetchProductInfo(productId);
		}

	@PutMapping("{pId}")
		public void updateProduct(@PathVariable(name="pId") Long productId, @RequestBody Product product) {
		
			productService.updateProduct(productId, product);
	}
	
	@DeleteMapping("{pId}")
	public void deleteProduct(@PathVariable(name="pId") Long id) {
		productService.deleteProduct(id);
		
	}
	
	@GetMapping("/getproduct/{name}")
	public Product findByname(@PathVariable String name) {
		log.info("ProductController :: findByname {}",name);
		return productService.findByname(name);
		}
	
	@GetMapping("/category/{name}")
	public List<Product> findByCategoryName(@PathVariable String name){
		log.info("ProductController :: findByCategoryName");
		return productService.findByCategoryName(name);
		
	}
}
