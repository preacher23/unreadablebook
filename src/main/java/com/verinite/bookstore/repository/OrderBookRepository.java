package com.verinite.bookstore.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.verinite.bookstore.entity.OrderBook;

@Repository
public interface OrderBookRepository extends JpaRepository<OrderBook, Integer> {
	 @Query(value="select * from tbl_orderbook Order by order_id ASC",nativeQuery = true)
	List<OrderBook> find();
	
	
	List<Object> findByBookId(int bookid);
	List<Object> findByBookName(String bookname);

}
