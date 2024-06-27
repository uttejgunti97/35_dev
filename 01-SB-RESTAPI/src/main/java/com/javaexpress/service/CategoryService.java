package com.javaexpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaexpress.entity.Category;
import com.javaexpress.entity.Product;
import com.javaexpress.repository.CategoryRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void createCategory(Category category) {
		log.info("CategoryService :: createCategory {} {}", category.getId(),category.getName());
		categoryRepository.save(category);
		log.info("Category saved in db succesfully");
	}
	
	public Category findByname(String name) {
		log.info("CategoryService :: findByname {}", name);
		return categoryRepository.findByname(name);
		
	}
	
	/*
	 * public List<Product> getAll(List<Product> name){ return (List<Product>)
	 * categoryRepository.findByProducts(name);
	 * 
	 * }
	 */
	

	

}
