package com.qa.interoperability;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.qa.business.service.AccountService;
import com.qa.persistence.domain.Account;

@Path("/account")
public class AccountEndPoint 
{
	private static final Logger LOGGER = Logger.getLogger(AccountEndPoint.class);

	@Inject
	private AccountService service;

	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() 
	{
		LOGGER.info("In AccountEndPoint getAllAccounts");
		Iterable<Account> accounts = service.getAllAccounts();
		LOGGER.info("In AccountEndPoint getAllAccounts, got accounts");
		Gson gson = new Gson();
		return gson.toJson(accounts);
	}

	@Path("/find_json")
	@GET
	@Produces({ "application/json" })
	public String findAccount(String accountInJSON)
	{
		LOGGER.info("In AccountEndPoint getAccount: " + accountInJSON);
		
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);
		
		LOGGER.info("In AccountEndPoint getAccount(JAVA): " + account.toString());
		return gson.toJson(service.findAccount(account));
	}

	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String accountInJSON) 
	{
		LOGGER.info("In AccountEndPoint addAccount(JSON): " + accountInJSON);
		
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);

		LOGGER.info("In AccountEndPoint addAccount(JAVA): " + account.toString());
		return service.addAccount(account);
	}

	@Path("/json/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String accountInJSON) 
	{
		LOGGER.info("In AccountEndPoint updateAccount(JSON): " + id + ", " + accountInJSON);
		
		Gson gson = new Gson();
		Account account = gson.fromJson(accountInJSON, Account.class);

		LOGGER.info("In AccountEndPoint addAccount(JAVA): " + account.toString());
		return service.updateAccount(id, account);
	}

	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) 
	{
		LOGGER.info("In AccountEndPoint updateAccount: " + id);
		return service.deleteAccount(id);
	}

	public void setService(AccountService service) 
	{
		this.service = service;
	}

}
