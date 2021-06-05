package com.nagarro.challenge.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nagarro.challenge.model.Statement;

public class StatementRowMapper implements RowMapper<Statement> {

	@Override
	public Statement mapRow(ResultSet rs, int rowNum) throws SQLException {
		Statement statement = new Statement();
		statement.setID(rs.getLong("ID"));
		statement.setAccountId(rs.getLong("account_id"));
		statement.setDatefield(rs.getString("datefield"));
		statement.setAmount(rs.getString("amount"));

		return statement;
	}

}
