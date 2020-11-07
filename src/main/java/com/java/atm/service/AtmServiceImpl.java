package com.java.atm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java.atm.dao.AccountDAO;
import com.java.atm.entity.Account;

@Service
public class AtmServiceImpl implements AtmService {
	
	 @Autowired
	    private AccountDAO accountDAO;

	@Override
	public double checkBalance(long accountNumber) {
		 return accountDAO.getBalance(accountNumber);
	}

	@Override
	 @Transactional
	    public boolean withdraw(long accountNumber, int amount) {
	        double balance = accountDAO.getBalance(accountNumber);
	        if (balance >= amount) {
	            accountDAO.withdraw(accountNumber, amount);
	            return true;
	            
	        } else {
	        	 return false;
	           
	        }
	       
	    }

	    @Transactional
	    public boolean deposit(long accountNumber, int amount) {
	        if (amount > 0) {
	             accountDAO.deposit(accountNumber, amount);
	             return true;
	            } 
	         else {
	        	 return false;
	        }
	    }

		@Override
		public void save(Account account) {
			accountDAO.save(account);
			
		}


}
