package com.verinite.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
