package com.verinite.bookstore.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.verinite.bookstore.entity.OrderBook;
import com.verinite.bookstore.entity.Payment;
import com.verinite.bookstore.service.OrderBookService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/order")
public class OrderBookController {
	
	private OrderBookService service;
	@Autowired
	OrderBookController(OrderBookService service)
	{
		this.service=service;
	}
	
	@Autowired
	RestTemplate restTemplate;
	//insert data to DB
	@PostMapping("/Order-Book")
public	OrderBook saveOrderBook(@RequestBody OrderBook orderbook)
	{
		return service.saveOrderBook( orderbook);
	}
	
	//display all Data
	@GetMapping("/Order-Book")
public	List<OrderBook> displayAllRecords()
	{
		return service.displayAllOrders();
	}
	//display by id
	@GetMapping("/Order-Book/{id}")
public	Object displayById(@PathVariable int id)  
	{
		return service.displayByOrderId(id);
	}
	//update by id
	@PutMapping("/Order-Book/{id}")
public	Object updateOrderRecord(@PathVariable int id,@RequestBody OrderBook  orderbook) 
	{
		return service.updateById(id,  orderbook);
	}
	//display by book name
	@GetMapping("/Order-Book/bookName/{bookname}")
public	List<Object> displayByBookName(@PathVariable String bookname) 
	{
		return service.searchByBookName(bookname);
	}
	//display by book id
	@GetMapping("/Order-Book/bookId/{bookid}")
public	List<Object> displayByBookId(@PathVariable int bookid) 
	{
		return service.searchByBookId(bookid);
	}
	/*
	 * @DeleteMapping("Order-Book/orderId/{orderid}") public String
	 * deleteOrederIdRecord(@PathVariable int orderid) { return
	 * service.deleteByOrderId(orderid); }
	 */
	@GetMapping("/Order-Book/search/{text}")
	public List<OrderBook> search(@PathVariable Object text)
	{
		return service.searchText(text);
	}
	
	@GetMapping("/payments/allList")
	List<Payment> getall()
	{
		String url="http://payment/payment/getpay";
		Payment[] obj=restTemplate.getForObject(url,Payment[].class);
		return Arrays.asList(obj);
	}
	@PostMapping("/postpayment")
	public Payment post(@RequestBody Payment payment)
	{
		
		return service.savePayment(payment);
	}
	
	
}
