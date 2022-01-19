package com.verinite.bookstore.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.verinite.bookstore.entity.OrderBook;
import com.verinite.bookstore.entity.Payment;
import com.verinite.bookstore.repository.OrderBookRepository;
import com.verinite.bookstore.service.OrderBookService;

@Service
public class OrderBookImpl implements OrderBookService{
	
	private OrderBookRepository orderBookRepository;
	@Autowired
	OrderBookImpl(OrderBookRepository orderBookRepository)
	{
		this.orderBookRepository=orderBookRepository;
		
	}

	@Autowired
	RestTemplate restTemplate;
	@Override
	public OrderBook saveOrderBook(OrderBook  orderbook) {
		 orderbook.setCreatedOn(new Date());
		 orderbook.setOrderedDate(new Date());
		 orderbook.setUpdatedOn(new Date());
		return orderBookRepository.save( orderbook);
	}

	@Override
	public List<OrderBook> displayAllOrders() {
		
		return orderBookRepository.find();
	}

	@Override
	public Object displayByOrderId(int orderId) {
		Optional<OrderBook> orderbook=orderBookRepository.findById(orderId);
		if(orderbook.isPresent())
		{
			return orderbook.get();
		}
		else
		{
			return "record is not present to show with the id of "+orderId;
		}
		
	}
	

	@Override
	public Object updateById(int orderId, OrderBook orderbook) {
		
		
		try
		{
			 OrderBook oldOrderBookTable=orderBookRepository.findById(orderId).get();
			if(orderbook.getBookId()!=0 || orderbook.getBookName()!=null)
			{
				 oldOrderBookTable.setUpdatedOn(new Date());
				 if(orderbook.getBookId()!=0)
				 {
				 oldOrderBookTable.setBookId(orderbook.getBookId());
				 }
				 if(orderbook.getBookName()!=null)
				 oldOrderBookTable.setBookName(orderbook.getBookName());
				 return orderBookRepository.save(oldOrderBookTable);
				
		
			}
			else
			{
				return "please give atleast one parameter to update";
				
			}

			
	}
		catch(Exception e)
		{
			return "record is not present to update with id of "+orderId;
		}
	}

	@Override
	public List<Object> searchByBookName(String bookname) {
		List<Object> orderbook=orderBookRepository.findByBookName(bookname);
		if(orderbook.isEmpty())
		{
			List<Object> error =new ArrayList<Object>();
		error.add("record is not present to show");
			return error ;
		}
		else
			return orderBookRepository.findByBookName(bookname);
	
	}

	@Override
	public List<Object> searchByBookId(int bookid) {
		List<Object> orderbook=orderBookRepository.findByBookId(bookid);
		if(orderbook.isEmpty())
		{
			List<Object> error =new ArrayList<Object>();
			error.add(" record is not present to show");
			return error ;
		}
		else
			return orderBookRepository.findByBookId(bookid);
	}

	@Override
	public List<OrderBook> searchText(Object text) {
		if(((String) text).matches("[0-9]+"))
		{
			int num=Integer.parseInt((String) text);
			return orderBookRepository.findByIntegers(num);
		}
		else
			
		return orderBookRepository.searchText(text);
	}

	
	@Override
	public Payment savePayment(Payment payment) {
		HttpEntity<Payment> entity=new HttpEntity<>(payment);
		
		
		return restTemplate.exchange("http://payment/payment/save", HttpMethod.POST, entity, Payment.class).getBody();
	}


}
