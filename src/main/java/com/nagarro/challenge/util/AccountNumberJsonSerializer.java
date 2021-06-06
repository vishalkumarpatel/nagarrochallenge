package com.nagarro.challenge.util;

import java.io.IOException;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.nagarro.challenge.model.Account;

@JsonComponent
public class AccountNumberJsonSerializer extends JsonSerializer<Account> {

	@Override
	public void serialize(Account account, JsonGenerator jsonGenerator, SerializerProvider serializers)
			throws IOException {
		jsonGenerator.writeStartObject();
		jsonGenerator.writeNumberField("id", account.getID());
		jsonGenerator.writeStringField("accountType", account.getAccountType());
		jsonGenerator.writeStringField("accountNumber", getHashedAccountNumber(account.getAccountNumber()));
		jsonGenerator.writeEndObject();
	}

	private String getHashedAccountNumber(String accountNumber) {
		return new BCryptPasswordEncoder().encode(accountNumber);
	}

}
