package com.nagarro.challenge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.challenge.model.Account;
import com.nagarro.challenge.repository.AccountDAO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDAO accountDAO;

	@Override
	public List<Account> getAllAccounts() {
		return accountDAO.getAllAccounts();
	}

}
