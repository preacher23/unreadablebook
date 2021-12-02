package com.verinite.bookstore.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "tbl_book")
@Getter
@Setter
@ToString
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int book_id;

	private String book_title;

	private String description;

	private Double book_price;

	private Date created_on;

	private Date updated_on;

	private int publisher_id;

	private boolean is_deleted;

//	@JsonBackReference
//	@ManyToOne
//	@JoinColumn(name="category_id")
//	private BookCategory category;


	public int getBook_id() {
		return book_id;
	}


	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	public String getBook_title() {
		return book_title;
	}


	public void setBook_title(String book_title) {
		this.book_title = book_title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getBook_price() {
		return book_price;
	}


	public void setBook_price(Double book_price) {
		this.book_price = book_price;
	}


	public Date getCreated_on() {
		return created_on;
	}


	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}


	public Date getUpdated_on() {
		return updated_on;
	}


	public void setUpdated_on(Date updated_on) {
		this.updated_on = updated_on;
	}


	public int getPublisher_id() {
		return publisher_id;
	}


	public void setPublisher_id(int publisher_id) {
		this.publisher_id = publisher_id;
	}


	public boolean isIs_deleted() {
		return is_deleted;
	}


	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}


	


	@Override
	public String toString() {
		return "Book [book_id=" + book_id + ", book_title=" + book_title + ", description=" + description
				+ ", book_price=" + book_price + ", created_on=" + created_on + ", updated_on=" + updated_on
				+ ", publisher_id=" + publisher_id + ", is_deleted=" + is_deleted +  "]";
	}


	public Book(int book_id, String book_title, String description, Double book_price, Date created_on,
			Date updated_on, int publisher_id, boolean is_deleted) {
		super();
		this.book_id = book_id;
		this.book_title = book_title;
		this.description = description;
		this.book_price = book_price;
		this.created_on = created_on;
		this.updated_on = updated_on;
		this.publisher_id = publisher_id;
		this.is_deleted = is_deleted;
	}


	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
}
