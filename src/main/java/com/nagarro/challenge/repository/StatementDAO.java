package com.nagarro.challenge.repository;

import java.util.Date;
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
	final String SELECT_BY_ACCOUNT_ID_DATE_RANGE = "SELECT * FROM statement"
			+ " WHERE account_id = 1 AND DateValue(Replace(datefield,\".\",\" \")) < Now;";
//	final String SELECT_BY_ACCOUNT_ID_DATE_RANGE = "SELECT * FROM statement"
//			+ " WHERE account_id = 1 AND DateValue(Replace(datefield,\".\",\" \")) >= CDate(\"10/13/2020\") AND DateValue(Replace(datefield,\".\",\" \")) <= CDate(\"10/14/2020\");";

	public List<Statement> getStatementByAccountId(final long accountId) {
		return this.jdbcTemplate.query(SELECT_BY_ACCOUNT_ID, new Object[] { accountId }, new StatementRowMapper());
	}

	public List<Statement> getStatementByAccountIdAndDateRange(final long accountId, String startDate, String endDate) {
		int accId = 1;
		startDate = "10/13/2020";
		endDate = "10/20/2020";
//		LocalDate startDt = LocalDate.of(2020, 9, 13);
//		LocalDate endDt = LocalDate.of(2020, 11, 20);
		Date startDt = new Date(120, 5, 10);
		Date endDt = new Date(120, 11, 20);
		return this.jdbcTemplate.query(SELECT_BY_ACCOUNT_ID_DATE_RANGE, new Object[] {}, new StatementRowMapper());
	}

	public List<Statement> getStatementByAccountIdAndAmountRange(final long accountId, String fromAmount,
			String toAmount) {
		return null;
	}

	public List<Statement> getStatementByAccountIdAndDateAndAmountRange(final long accountId, Date startDate,
			Date endDate, String fromAmount, String toAmount) {
		return null;
	}
}
