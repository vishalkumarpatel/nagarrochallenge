package com.nagarro.challenge.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.nagarro.challenge.model.Statement;
import com.nagarro.challenge.repository.StatementDAO;

@ExtendWith(MockitoExtension.class)
class StatementServiceTest {

	@Mock
	StatementDAO statementDAO;

	@InjectMocks
	StatementServiceImpl service;

	@Test
	void shouldReturnWhenGetAllStatementsByDateRange() {
		LocalDate startDate = LocalDate.now().minusMonths(3);
		LocalDate endDate = LocalDate.now();
		List<Statement> statements = service.getAllStatementsByDateRange(1L, startDate, endDate);

		assertNotNull(statements);
	}
}
