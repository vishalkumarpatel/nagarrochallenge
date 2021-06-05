package com.nagarro.challenge.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nagarro.challenge.model.Account;

public class AccountRowMapper implements RowMapper<Account> {

	@Override
	public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
		Account account = new Account();
		account.setID(rs.getLong("ID"));
		account.setAccountType(rs.getString("account_type"));
		account.setAccountNumber(rs.getString("account_number"));
		return account;
	}

}
