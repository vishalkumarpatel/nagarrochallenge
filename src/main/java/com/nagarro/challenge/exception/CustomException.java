package com.nagarro.challenge.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CustomException() {
		super("Custom exception message.");
	}

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Throwable t) {
		super(message, t);
	}

}