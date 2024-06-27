package com.javaexpress.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.entity.Product;
import com.javaexpress.repository.ProductRepository;

import lombok.extern.slf4j.Slf4j;

@Service		
@Slf4j
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	
	
	public void createProduct(Product product) {
		log.info("ProductService :: createProduct ");
		product.setInStock(true);
		product.setBarcode(UUID.randomUUID().toString());
		productRepository.save(product);
		log.info("Product saved in db succesfully");
		
	
	}
	
	public Product fetchProductInfo(Long productId) {
		log.info("ProductService :: fetchProductInfo {} {}",productId);
		return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found") );
	}
	
	public void updateProduct(Long productId , Product inputproduct) {
		log.info("ProductService :: updateProduct {} {} ",productId, inputproduct.getName() );
		Product dbproduct = findUserById(productId);
		dbproduct.setName(inputproduct.getName());
		//dbproduct.setBarcode(inputproduct.getBarcode());
		dbproduct.setCategory(inputproduct.getCategory());
		dbproduct.setDescription(inputproduct.getDescription());
		dbproduct.setInStock(inputproduct.getInStock());
		dbproduct.setPrice(inputproduct.getPrice());
		dbproduct.setQuantity(inputproduct.getQuantity());
		
		productRepository.save(dbproduct);
		log.info("Product Updated in db Succesfully");
		}

	public Product findUserById(Long productId) {
		log.info("ProductService :: findUserById {}",productId);
		
		return productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
	}
	
	public void deleteProduct(Long productId) {
		log.info("ProductService :: deleteProduct {}",productId);
		if (productRepository.existsById(productId)) {
			productRepository.deleteById(productId);
		}
		else {
			throw new RuntimeException("Product not found");
		}
		log.info("Product deleted from db Successfully");
	}
	
	public Product findByname(String name) {
		log.info("ProductService :: findByname {}",name);
		return productRepository.findByname(name);
		
	}
	
	public List<Product> findByCategoryName (String name){
		log.info("ProductService :: findByCategoryName ");
		return productRepository.findByCategoryName(name);
		
	}
	
	
	
}
