package com.nagarro.challenge.service;

import java.util.Date;
import java.util.List;

import com.nagarro.challenge.model.Statement;

public interface StatementService {

	List<Statement> getAllStatements(long accountId, Date startDate, Date endDate, String fromAmout, String toAmount);

}
