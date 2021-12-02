package com.verinite.bookstore.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Table(name = "tbl_bookauthor")
@Entity
public class BookAuthor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int book_id;

	private int author_id;

	// @Basic(optional = false)
//	@Column(nullable=false ,insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_on;

	// @Basic(optional = false)
//	@Column(insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_on;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
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

	public BookAuthor(int id, int book_id, int author_id, Date created_on, Date updated_on) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.author_id = author_id;
		this.created_on = created_on;
		this.updated_on = updated_on;
	}

	public BookAuthor() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "BookAuthor [id=" + id + ", book_id=" + book_id + ", author_id=" + author_id + ", created_on="
				+ created_on + ", updated_on=" + updated_on + "]";
	}

}