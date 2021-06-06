package com.nagarro.challenge.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestWrapper;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.challenge.exception.CustomException;
import com.nagarro.challenge.model.Statement;
import com.nagarro.challenge.service.StatementService;

@RestController
@RequestMapping("/statements")
public class StatementController {

	@Autowired
	private StatementService statementService;

	@GetMapping("/{accountId}")
	public ResponseEntity<List<Statement>> getAllStatements(@PathVariable long accountId,
			SecurityContextHolderAwareRequestWrapper request,
			@RequestParam(required = false) @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate startDate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "MM/dd/yyyy") LocalDate endDate,
			@RequestParam(required = false) Double fromAmount, @RequestParam(required = false) Double toAmount)
			throws Exception {
		if (request.isUserInRole("ADMIN")) {
			return ResponseEntity
					.ok(statementService.getAllStatements(accountId, startDate, endDate, fromAmount, toAmount));
		} else {
			if (startDate != null || endDate != null || fromAmount != null || toAmount != null) {
				throw new CustomException("This request does not support parameters for given user");
			}
			LocalDate now = LocalDate.now();
			return ResponseEntity.ok(statementService.getAllStatementsByDateRange(accountId, now.minusMonths(3), now));
		}
	}

	@ExceptionHandler(CustomException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleCustomException(CustomException e) {
		return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
		return new ResponseEntity<Exception>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
