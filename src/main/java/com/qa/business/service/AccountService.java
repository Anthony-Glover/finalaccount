package com.qa.business.service;

import com.qa.persistence.domain.Account;

public interface AccountService {

	Iterable<Account> getAllAccounts();

	String addAccount(Account account);

	Account findAccount(Account account);

	String updateAccount(Long id, Account account);

	String deleteAccount(Long id);

}
