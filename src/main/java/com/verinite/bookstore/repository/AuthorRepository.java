package com.verinite.bookstore.repository;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepositoryImplementation<Author, Integer>{
	
	@Query(value="select * from public.tbl_author Order by author_id ASC",nativeQuery = true)
	List<Author> all();
}

