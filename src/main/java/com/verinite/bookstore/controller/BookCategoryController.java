package com.verinite.bookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.verinite.bookstore.entity.BookCategory;
import com.verinite.bookstore.service.BookCategoryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BookCategoryController {
 @Autowired
    BookCategoryService bookCategoryService;

    @GetMapping("/bookcategory")
    public List<BookCategory>getBookCategory(){
      return bookCategoryService.getBookCategory();
    }
    @GetMapping("/bookcategory/{id}")
    public Object getBookCategoryId(@PathVariable("id") int categoryid){
        return bookCategoryService.getBookCategoryId(categoryid);
    }
    @PostMapping("/bookcategory")
    public BookCategory createBookCategory(@RequestBody BookCategory bookCategory){
        return bookCategoryService.createBookCategory(bookCategory);
    }

    @PutMapping("/bookcategory/{id}")
    public Object updateBookCategory(@PathVariable int id, @RequestBody BookCategory bookCategory){
        return bookCategoryService.updateBookCategory(id,bookCategory);
    }
}
