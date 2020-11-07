package com.java.atm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="AccountInfo")
public class Account {
	
	public Account(String accountName, long accountNumber, int pin, double balance) {
		super();
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.pin = pin;
		this.balance = balance;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="accountName")
	    private String accountName;
	    
	@Column(name="accountNum")
	    private long accountNumber;
	    
	@Column(name="pin")
	    private int pin;
	    
	public Account()
	{
		
	}
	
	
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Column(name="balance")
	    private double balance;

	    public String getAccountName() {
	        return accountName;
	    }

	    public long getAccountNumber() {
	        return accountNumber;
	    }

	    public int getPin() {
	        return pin;
	    }

	    public double getBalance() {
	        return balance;
	    }

}
