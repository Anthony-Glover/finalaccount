package com.qa.business.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountSpringDBRepository;

@Service
public class AccountServiceSpringImpl implements AccountService 
{
	private static final Logger LOGGER = Logger.getLogger(AccountService.class);

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
		
		
		
//		public AccountCollection find(int accountNumber, String firstName, String lastName)
//		{
//			AccountCollection resultAccountCollection  = new AccountCollection();
//			
//			if (0 < accountNumber) 
//			{
//				Account account = accountCollection.find(accountNumber);
//				
//				if ((null == firstName || "".equals(firstName) || firstName.equals(account.getFirstName())) && 
//					(null == lastName || "".equals(lastName) || lastName.equals(account.getLastName())) &&
//					null != account)
//				{
//					try 
//					{
//						resultAccountCollection.addAccount(account);
//					} 
//					catch (Exception e) 
//					{
//						e.printStackTrace();
//					}
//				}
//				
//				return resultAccountCollection;
//			}
//					
//			if (null != firstName && !"".equals(firstName))
//				resultAccountCollection = accountCollection.findByFirstName(firstName);
//			
//			if (null != lastName && !"".equals(lastName))
//				return resultAccountCollection.findByLastName(lastName);
//				
//			return resultAccountCollection;
//		}		
		
		
		
		
		
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
