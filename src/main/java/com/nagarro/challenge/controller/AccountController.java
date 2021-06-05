package com.nagarro.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.challenge.model.Account;
import com.nagarro.challenge.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@GetMapping
	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}
}
