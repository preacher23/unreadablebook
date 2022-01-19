package com.verinite.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="payment_id")
	private int paymentId;
	
	@Column(name="account_number")
	private String accountNumber;
	
	@Column(name="customer_name")
	private String customerName;
	
	@Column(name="ifsc")
	private String ifsc;
	
	@Column(name="bank_name")
	private String bankName;
	
	@Column(name="branch")
	private String branch;
	
	@Column(name="balance")
	private double balance;
	
	@Column(name="branch_address")
	private String branchAddress;
	
	@Column(name="customer_address")
	private String customerAddress;

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getBranchAddress() {
		return branchAddress;
	}

	public void setBranchAddress(String branchAddress) {
		this.branchAddress = branchAddress;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
}
