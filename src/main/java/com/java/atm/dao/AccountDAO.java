package com.java.atm.dao;

import com.java.atm.entity.Account;

public interface AccountDAO {
	
	double getBalance(long accountNumber);

	void withdraw(long accountNumber, int amount);

	void deposit(long accountNumber, int amount);

	void save(Account account);

	


}
