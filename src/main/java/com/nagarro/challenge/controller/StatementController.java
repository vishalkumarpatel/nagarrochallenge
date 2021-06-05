package com.nagarro.challenge.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.challenge.model.Statement;
import com.nagarro.challenge.service.StatementService;

@RestController
@RequestMapping("/statements")
public class StatementController {

	@Autowired
	private StatementService statementService;

	@GetMapping("/{accountId}")
	public List<Statement> getAllStatements(@PathVariable long accountId,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd.MM.yyyy") Date startDate,
			@RequestParam(required = false) @DateTimeFormat(pattern = "dd.MM.yyyy") Date endDate,
			@RequestParam(required = false) String fromAmout, @RequestParam(required = false) String toAmount) {
		return statementService.getAllStatements(accountId, startDate, endDate, fromAmout, toAmount);
	}
}
