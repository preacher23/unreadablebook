package com.verinite.bookstore.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_registration")
public class Registration {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int register_id;

	private String user_name;

	private String emailaddress;

	private String mobile_number;

	private String password;

	private String confirm_password;
	
    @Temporal(TemporalType.TIMESTAMP)
	private Date created_on=new Date(System.currentTimeMillis());

    @Temporal(TemporalType.TIMESTAMP)
	private Date updated_on=new Date(System.currentTimeMillis());

	private boolean is_delete;

	public int getRegister_id() {
		return register_id;
	}

	public void setRegister_id(int register_id) {
		this.register_id = register_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getEmailaddress() {
		return emailaddress;
	}

	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
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

	public boolean isIs_delete() {
		return is_delete;
	}

	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}

	public Registration(int register_id, String user_name, String emailaddress, String mobile_number, String password,
			String confirm_password, Date created_on, Date updated_on, boolean is_delete) {
		super();
		this.register_id = register_id;
		this.user_name = user_name;
		this.emailaddress = emailaddress;
		this.mobile_number = mobile_number;
		this.password = password;
		this.confirm_password = confirm_password;
		this.created_on = created_on;
		this.updated_on = updated_on;
		this.is_delete = is_delete;
	}

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Registration [register_id=" + register_id + ", user_name=" + user_name + ", emailaddress="
				+ emailaddress + ", mobile_number=" + mobile_number + ", password=" + password + ", confirm_password="
				+ confirm_password + ", created_on=" + created_on + ", updated_on=" + updated_on + ", is_delete="
				+ is_delete + "]";
	}

	

}
