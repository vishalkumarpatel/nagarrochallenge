package com.nagarro.challenge.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "account")
@NoArgsConstructor
public class Account {

	@Id
	private Long ID;
	private String accountType;
	private String accountNumber;
}
