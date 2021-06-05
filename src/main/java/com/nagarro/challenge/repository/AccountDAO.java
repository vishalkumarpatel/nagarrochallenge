package com.nagarro.challenge.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.challenge.model.Account;

@Repository
public class AccountDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	final String SELECT_ALL = "select * from account";
	final String SELECT_BY_ID = "select * from account where id = ?";

	public List<Account> getAllAccounts() {
		return this.jdbcTemplate.query(SELECT_ALL, new AccountRowMapper());
	}

	public Account getAccountById(final long id) {
		return this.jdbcTemplate.queryForObject(SELECT_BY_ID, new Object[] { id }, new AccountRowMapper());
	}
}
