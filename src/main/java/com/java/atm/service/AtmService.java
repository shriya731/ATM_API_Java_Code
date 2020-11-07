package com.java.atm.service;

import com.java.atm.entity.Account;

public interface AtmService {
  
	double checkBalance(long accountNumber);

	boolean withdraw(long accountNumber, int amount);

	boolean deposit(long accountNumber, int amount);

	void save(Account account);
}
