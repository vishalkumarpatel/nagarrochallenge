package com.nagarro.challenge.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.challenge.model.Statement;
import com.nagarro.challenge.repository.StatementDAO;

@Service
public class StatementServiceImpl implements StatementService {

	@Autowired
	private StatementDAO statementDAO;

	@Override
	public List<Statement> getAllStatements(final long accountId, final Date startDate, final Date endDate,
			final String fromAmout, final String toAmount) {
		return statementDAO.getStatementByAccountIdAndDateRange(accountId, null, null);
	}

}
