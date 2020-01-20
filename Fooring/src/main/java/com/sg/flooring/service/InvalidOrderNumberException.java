package com.sg.flooring.service;

public class InvalidOrderNumberException extends Exception {

	public InvalidOrderNumberException(String message) {
		super(message);
	}

	public InvalidOrderNumberException(String message, Throwable cause) {
		super(message, cause);
	}
}
