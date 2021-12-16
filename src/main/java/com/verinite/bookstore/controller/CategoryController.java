package com.verinite.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.verinite.bookstore.entity.Category;
import com.verinite.bookstore.serviceimpl.CategoryServiceImpl;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

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
	@GetMapping("/getCategory/{categoryId}")
	public Object getCategoryById(@PathVariable int categoryId) {
		return service.getCategoryById(categoryId);
	}

	// method for delete mapping
	@DeleteMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable int categoryId) {
		return service.deleteCategory(categoryId);
	}

	// Method for put mapping
	@PutMapping("/updateCategory/{categoryId}")
	public Object updateCategory(@PathVariable int categoryId, @RequestBody Category category) {
		return service.updateCategory(categoryId, category);
	}
}