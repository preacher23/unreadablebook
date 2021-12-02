package com.verinite.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.Category;
import com.verinite.bookstore.serviceImpl.CategoryServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryServiceImpl service;

	// Method for post mapping
	@PostMapping("/saveCategory")
	public Category saveCategory(@RequestBody Category category) {
		return service.saveCategory(category);
	}

	// Method for get mapping
	@GetMapping("/getAllCategorys")
	public List<Category> getAllCategorys() {
		return service.getAllCategorys();
	}

	// Method for getting one data by using a categoryId
	@GetMapping("/getCategory/{category_id}")
	public Object getCategoryById(@PathVariable int category_id) {
		return service.getCategoryById(category_id);
	}

	// method for delete mapping
	@DeleteMapping("/deleteCategory/{category_id}")
	public String deleteCategory(@PathVariable int category_id) {
		return service.deleteCategory(category_id);
	}

	// Method for put mapping
	@PutMapping("/updateCategory/{category_id}")
	public Object updateCategory(@PathVariable int category_id, @RequestBody Category category) {
		return service.updateCategory(category_id, category);
	}
}