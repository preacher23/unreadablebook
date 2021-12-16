package com.verinite.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.BookCategory;

@Repository
public interface BookCategoryRepository extends JpaRepository <BookCategory , Integer> {

}
