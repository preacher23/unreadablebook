package com.verinite.bookstore.entity;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tbl_orderbook")
public class OrderBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="order_id")
	private int orderId;
	
	@Column(name="ordered_date",nullable=false ,insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date orderedDate;
	
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="book_name",nullable=false,length = 128)
	private String bookName;
	
	@Column(name="created_on",nullable=false ,insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;
	
	@Column(name="updated_on",insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	public OrderBook(int orderId, Date orderedDate, int bookId, String bookName, Date createdOn, Date updatedOn) {
		super();
		this.orderId = orderId;
		this.orderedDate = orderedDate;
		this.bookId = bookId;
		this.bookName = bookName;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Date getOrderedDate() {
		return orderedDate;
	}

	public void setOrderedDate(Date orderedDate) {
		this.orderedDate = orderedDate;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public OrderBook() {
	}
	
	
	
}
