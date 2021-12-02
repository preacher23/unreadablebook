package com.verinite.bookstore.serviceImpl;

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

	@Override
	public Category saveCategory(Category category) {
//		category.setCreated_on(new Date(System.currentTimeMillis()));
//		category.setUpdated_on(new Date(System.currentTimeMillis()));
		return categoryRepository.save(category);

	}

	@Override
	public List<Category> getAllCategorys() {

		return categoryRepository.findAll();
	}

	// Entity Object to hold a temporary entity Objects
	Category categoryData;

//	@Override
//	public String deleteCategoryById(int category_id) {
//		try {
//			categoryData = categoryRepository.findById(category_id).get();
//		} catch (Exception e) {
//			return "Error:\n category_id :  " + category_id + " is not present on Database";
//		}
//		if (categoryData.isIs_deleted() == false) {
//			categoryData.setIs_deleted(true);
//			categoryRepository.save(categoryData);
//			return "Successfully Deleted";
//		} else if (categoryData.isIs_deleted() == true) {
//			return "data is already Deleted from database";
//		} else {
//			return "no data is present with this categoryId " + category_id;
//		}
//
//	}

	@Override
	public Object updateCategory(int category_id, Category category) {
		try {
			categoryData = categoryRepository.findById(category_id).get();

			if (categoryData.isIs_deleted() == true) {
				return "Error : There is no Data with this id  " + category_id;
			}
			categoryData.setCategory_title(category.getCategory_title());
			categoryData.setUpdated_on(new Date());

			return categoryRepository.save(categoryData);
		} catch (Exception e) {

			String message = "Error:  no data is present ";
			return (Object) message;
		}

	}

	@Override
	public String deleteCategory(int category_id) {

//        try {
//            categoryData = categoryRepository.findById(category_id).get();
//        } catch (Exception e) {
//
//            String message = "Error:  no data is present ";//with  categoryId :"+  categoryId;
//            return message;
//        }
//       if (categoryData.isIs_deleted() == true) {
//            return "Error : There is no Data with this category_id  " + category_id;
//        } else {
//            return categoryData;
//
//        }
		categoryRepository.deleteById(category_id);
		return "delete succes";

	}

	@Override
	public Object getCategoryById(int category_id) {
		try {
			categoryRepository.findById(category_id).get();
			return categoryRepository.getById(category_id);
		} catch (Exception e) {
			return "Id not Found";
		}

	}

}