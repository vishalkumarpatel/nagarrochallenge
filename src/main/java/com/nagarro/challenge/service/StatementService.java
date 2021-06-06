package com.nagarro.challenge.service;

import java.time.LocalDate;
import java.util.List;

import com.nagarro.challenge.model.Statement;

public interface StatementService {

	List<Statement> getAllStatementsByDateRange(long accountId, LocalDate startDate, LocalDate endDate);

	List<Statement> getAllStatements(long accountId, LocalDate startDate, LocalDate endDate, Double fromAmount,
			Double toAmount);
}
