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
@Table(name = "tbl_author")
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int author_id;
	
	@Column(nullable = false, length = 128)
	private String first_name;
	
	@Column(nullable = false, length = 128)
	private String last_name;
	
//	@Basic(optional = false)
//	@Column(insertable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_on;
	
//	@Basic(optional = false)
//	@Column(insertable = false, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_on;
	
	@Column(nullable = false)
	private boolean is_deleted;

	public int getAuthor_id() {
		return author_id;
	}

	public void setAuthor_id(int author_id) {
		this.author_id = author_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
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

	public boolean isIs_deleted() {
		return is_deleted;
	}

	public void setIs_deleted(boolean is_deleted) {
		this.is_deleted = is_deleted;
	}

	@Override
	public String toString() {
		return "Author [author_id=" + author_id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", created_on=" + created_on + ", updated_on=" + updated_on + ", is_deleted=" + is_deleted + "]";
	}

	public Author(int author_id, String first_name, String last_name, Date created_on, Date updated_on,
			boolean is_deleted) {
		super();
		this.author_id = author_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.created_on = created_on;
		this.updated_on = updated_on;
		this.is_deleted = is_deleted;
	}

	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}

}