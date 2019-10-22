package com.transaction.example.entity;

public class CustomerInfo {
	private Long id;
	   private String fullName;
	   private double balance;
	   private String currency;
	 
	   public CustomerInfo() {
	 
	   }
	 
	   // Used in JPA query.
	   public CustomerInfo(Long id, String fullName, double balance, String currency) {
	      this.id = id;
	      this.fullName = fullName;
	      this.balance = balance;
	      this.currency=currency;
	   }
	   
	 
	   public Long getId() {
	      return id;
	   }
	 
	   public void setId(Long id) {
	      this.id = id;
	   }
	 
	   public String getFullName() {
	      return fullName;
	   }
	 
	   public void setFullName(String fullName) {
	      this.fullName = fullName;
	   }
	 
	   public double getBalance() {
	      return balance;
	   }
	 
	   public void setBalance(double balance) {
	      this.balance = balance;
	   }

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}
	   
	}


