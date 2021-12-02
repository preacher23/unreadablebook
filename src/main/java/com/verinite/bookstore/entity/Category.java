package com.verinite.bookstore.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tbl_category")
@Setter
@Getter
@ToString
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int category_id;
	
    private String category_title;
    
//    @Column(nullable=false ,updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_on;
    
//    @Basic(optional = false)
//    @Column(insertable = false, updatable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated_on=new Date(System.currentTimeMillis());
    
    private boolean is_deleted;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	public String getCategory_title() {
		return category_title;
	}

	public void setCategory_title(String category_title) {
		this.category_title = category_title;
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
		return "Category [category_id=" + category_id + ", category_title=" + category_title + ", created_on="
				+ created_on + ", updated_on=" + updated_on + ", is_deleted=" + is_deleted + "]";
	}

	public Category(int category_id, String category_title, Date created_on, Date updated_on, boolean is_deleted) {
		super();
		this.category_id = category_id;
		this.category_title = category_title;
		this.created_on = created_on;
		this.updated_on = updated_on;
		this.is_deleted = is_deleted;
	}

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
//	@JsonManagedReference
//	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "category")
//	private Set<Book> book;

	
}
