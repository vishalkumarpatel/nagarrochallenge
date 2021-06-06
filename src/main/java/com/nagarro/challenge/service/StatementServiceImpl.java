package com.nagarro.challenge.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.challenge.model.Statement;
import com.nagarro.challenge.repository.StatementDAO;

@Service
public class StatementServiceImpl implements StatementService {

	@Autowired
	private StatementDAO statementDAO;

	public static final String DATE_PATTERN = "MM/dd/yyyy";

	@Override
	public List<Statement> getAllStatementsByDateRange(final long accountId, final LocalDate startDate,
			final LocalDate endDate) {
		return statementDAO.getStatementByAccountIdAndDateRange(accountId,
				startDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)),
				endDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)));
	}

	@Override
	public List<Statement> getAllStatements(final long accountId, final LocalDate startDate, final LocalDate endDate,
			final Double fromAmout, final Double toAmount) {
		return statementDAO.getStatementByAccountIdAndDateAndAmountRange(accountId,
				startDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)),
				endDate.format(DateTimeFormatter.ofPattern(DATE_PATTERN)), String.valueOf(fromAmout),
				String.valueOf(toAmount));
	}
}
