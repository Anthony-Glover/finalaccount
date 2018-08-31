package com.qa.persistence.repository;

import java.util.Collection;

import com.qa.persistence.domain.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountSpringDBRepository extends CrudRepository<Account, Long> 
{
	Collection<Account> findByLastName(String lastName);
}