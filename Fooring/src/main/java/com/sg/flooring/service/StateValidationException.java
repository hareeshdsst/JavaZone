package com.sg.flooring.service;

public class StateValidationException extends Exception {

	public StateValidationException(String message) {
		super(message);
	}
	public StateValidationException(String message, Throwable cause) {
		super(message,cause);
	}
}
