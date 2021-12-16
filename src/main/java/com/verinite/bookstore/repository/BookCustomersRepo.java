package com.verinite.bookstore.repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;
import com.verinite.bookstore.entity.BookCustomers;

@Repository
public interface BookCustomersRepo extends JpaRepositoryImplementation<BookCustomers, Number> {

	
	@Query(value="select * from customer Order by customer_id ASC",nativeQuery=true)
	List<BookCustomers> getAllcustomers();

	List<Object> findByState(String state);
	List<Object> findByFirstNameAndLastName(String firstName, String lastName);

}