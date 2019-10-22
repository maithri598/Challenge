package com.transaction.example.CustomerAccountDAO;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.transaction.example.Exception.CustomerTransactionException;
import com.transaction.example.entity.Customer;
import com.transaction.example.entity.CustomerInfo;

@Repository
public class CustomerAccountdao {

	@Autowired(required=false)
	private EntityManager entityManager;

	public CustomerAccountdao() {
	}

	public Customer findById(Long id) { 
		return this.entityManager.find(Customer.class, id);
	}

	public List<CustomerInfo> listCustomerAccountInfo() {
		String sql = "Select new " + CustomerInfo.class.getName() //
				+ "(e.id,e.fullName,e.balance) " //
				+ " from " + Customer.class.getName() + " e ";
		Query query = entityManager.createQuery(sql, CustomerInfo.class);
		return query.getResultList();
	}

	@Transactional(propagation = Propagation.MANDATORY )
	public void addAmount(Long id, double amount, String currency) throws CustomerTransactionException {
		Customer account = this.findById(id);
		if (account == null) {
			throw new CustomerTransactionException("Account not found " + id);
		}
		if(currency == "USD") {
			amount = amount / 0.50;
			
		}
		else {
			amount = amount / 10;
		}

		double newBalance = account.getBalance() + amount;
		if (account.getBalance() + amount < 0) {
			throw new CustomerTransactionException(
					"The money in the account '" + id + "' is not enough (" + account.getBalance() + ")");
		}
		account.setBalance(newBalance);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, 
			rollbackFor = CustomerTransactionException.class)
	public void sendMoney(Long fromAccountId, Long toAccountId, double amount, String currency) throws CustomerTransactionException {

		addAmount(toAccountId, amount,currency);
		addAmount(fromAccountId, -amount,currency);
	}
}
