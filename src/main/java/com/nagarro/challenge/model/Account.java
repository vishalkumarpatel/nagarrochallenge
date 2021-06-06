package com.nagarro.challenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Account {

	private Long ID;
	private String accountType;
	private String accountNumber;
}
