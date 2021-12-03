package com.verinite.bookstore.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.verinite.bookstore.entity.Category;
import com.verinite.bookstore.repository.CategoryRepository;
import com.verinite.bookstore.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	// Entity Object to hold a temporary entity Objects
	Category categoryData;

	@Override
	public Category saveCategory(Category category) {
		category.setCreatedOn(new Date(System.currentTimeMillis()));
		category.setUpdatedOn(new Date(System.currentTimeMillis()));
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAllCategorys() {
		return categoryRepository.findAll();
	}

	@Override
	public String deleteCategory(int categoryId) {
		try {
			categoryData = categoryRepository.findById(categoryId).get();
		} catch (Exception e) {
			return "Error:\n categoryId :  " + categoryId + " is not present on Database";
		}
		if (!categoryData.isDeleted()) {
			categoryData.setDeleted(true);
			categoryRepository.save(categoryData);
			return "Successfully Deleted";
		} else if (categoryData.isDeleted()) {
			return "data is already Deleted from database";
		} else {
			return "data is present with this categoryId " + categoryId;
		}

	}

	@Override
	public Object updateCategory(int categoryId, Category category) {
		try {
			categoryData = categoryRepository.findById(categoryId).get();
			if (categoryData.isDeleted()) {
				return "Error : There is no Data with this id  " + categoryId;
			}
			categoryData.setCategoryTitle(category.getCategoryTitle());
			categoryData.setUpdatedOn(new Date());
			return categoryRepository.save(categoryData);
		} catch (Exception e) {
			return "no data is not present with this categoryId " + categoryId;
		}

	}

	@Override
	public Object getCategoryById(int categoryId) {
		try {
			categoryData = categoryRepository.findById(categoryId).get();
			if (categoryData.isDeleted()) {
				return "Error : There is no Data with this category_id  " + categoryId;
			} else {
				return categoryData;
			}

		} catch (Exception e) {
			return "no data is present with this categoryId " + categoryId;
		}

	}

}