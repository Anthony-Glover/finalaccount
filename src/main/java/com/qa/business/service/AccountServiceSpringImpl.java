package com.qa.business.service;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountSpringDBRepository;

@Service
public class AccountServiceSpringImpl implements AccountService 
{
	private static final Logger LOGGER = Logger.getLogger(AccountServiceSpringImpl.class);

	@Autowired
	AccountSpringDBRepository repo;
	 
	public Iterable<Account> getAllAccounts() 
	{
		LOGGER.info("In AccountServiceImpl getAllAccounts");
		return repo.findAll();
	}

	public Account findAccount(Account account) 
	{
		LOGGER.info("In AccountServiceImpl findAccount: " + account);
		return repo.findOne(account.getId());
	}

	public String addAccount(Account account) 
	{
		LOGGER.info("In AccountServiceImpl createAccount: " + account);
		repo.save(account);
		return "{\"message\": \"account sucessfully Created\"}";
	}

	public String updateAccount(Long id, Account account) 
	{
		LOGGER.info("In AccountServiceImpl updateAccount: " + id + ", " + account);
		Account accountDB = repo.findOne(account.getId());
		accountDB = account;
		repo.save(accountDB);
		return "{\"message\": \"account sucessfully Updated\"}";
	}

	public String deleteAccount(Long id) 
	{
		LOGGER.info("In AccountServiceImpl deleteAccount: " + id);
		repo.delete(id); 
		return "{\"message\": \"account sucessfully deleted\"}";
	}
}
