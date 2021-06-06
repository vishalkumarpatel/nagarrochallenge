package com.nagarro.challenge.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.nagarro.challenge.model.Statement;

@Repository
public class StatementDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	final String SELECT_BY_ACCOUNT_ID = "select * from statement where account_id = ?";
	final String SELECT_BY_ACCOUNT_ID_DATE_RANGE = SELECT_BY_ACCOUNT_ID
			+ " AND DateSerial(Val(Mid(datefield, 7, 4)), Val(Mid(datefield, 4, 2)), Val(Mid(datefield, 1, 2))) Between CDate(?) And CDate(?)";
	final String SELECT_BY_ACCOUNT_ID_DATE_RANGE_AMOUNT_RANGE = SELECT_BY_ACCOUNT_ID_DATE_RANGE
			+ " AND Val(amount) BETWEEN Val(?) AND Val(?)";

	public List<Statement> getStatementByAccountIdAndDateRange(final long accountId, String startDate, String endDate) {
		return this.jdbcTemplate.query(SELECT_BY_ACCOUNT_ID_DATE_RANGE, new StatementRowMapper(), accountId, startDate,
				endDate);
	}

	public List<Statement> getStatementByAccountIdAndDateAndAmountRange(final long accountId, String startDate,
			String endDate, String fromAmount, String toAmount) {
		return this.jdbcTemplate.query(SELECT_BY_ACCOUNT_ID_DATE_RANGE_AMOUNT_RANGE, new StatementRowMapper(),
				accountId, startDate, endDate, fromAmount, toAmount);
	}
}
