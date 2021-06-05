package com.nagarro.challenge.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "statement")
@NoArgsConstructor
public class Statement {

	@Id
	private Long ID;
	private Long accountId;
	private String datefield;
	private String amount;
}
