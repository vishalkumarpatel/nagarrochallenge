package com.nagarro.challenge.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Statement {

	private Long ID;
	private Long accountId;
	private String datefield;
	private String amount;
}
