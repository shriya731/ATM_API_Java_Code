package com.java.atm.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.atm.entity.Account;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

@Repository
public class AccountDAOImpl implements AccountDAO {
	
   private EntityManager entityManager;
	
	@Autowired
	public AccountDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public double getBalance(long accountNumber) {
		Query theQuery = 
				entityManager.createQuery("select balance from AccountInfo where accountNum=:account");
		
		theQuery.setParameter("account", accountNumber);
		@SuppressWarnings("unchecked")
		List<Double> bal= theQuery.getResultList();
		if(bal!=null)
		return bal.get(0);
		else
			return 0.0;
	}

	@Override
	public void withdraw(long accountNumber, int amount) {
		double balValue = 0;
		Query theQuery = 
				entityManager.createQuery("select balance from AccountInfo where accountNum=:account");
		
		theQuery.setParameter("account", accountNumber);
		@SuppressWarnings("unchecked")
		List<Double> bal= theQuery.getResultList();
		if(bal!=null)
		balValue=bal.get(0);
		balValue-=amount;
		theQuery = 
				entityManager.createQuery("Update AccountInfo set"
						+ " balance =:balValue where accountNum=:account");
		theQuery.setParameter("balValue", balValue);
		theQuery.setParameter("account", accountNumber);
		
		theQuery.executeUpdate();
		
	}

	@Override
	public void deposit(long accountNumber, int amount) {
		double balValue = 0;
		Query theQuery = 
				entityManager.createQuery("select balance from AccountInfo where accountNum=:account");
		
		theQuery.setParameter("account", accountNumber);
		@SuppressWarnings("unchecked")
		List<Double> bal= theQuery.getResultList();
		if(bal!=null)
		balValue=bal.get(0);
		balValue+=amount;
		theQuery = 
				entityManager.createQuery("Update AccountInfo set"
						+ " balance =:balValue where accountNum=:account");
		theQuery.setParameter("balValue", balValue);
		theQuery.setParameter("account", accountNumber);
		
		theQuery.executeUpdate();
	}

	@Override
	public void save(Account account) {
		Account dbAccount = entityManager.merge(account);
		
		// update with id from db ... so we can get generated id for save/insert
		account.setId(dbAccount.getId());
		
	}

	

}
