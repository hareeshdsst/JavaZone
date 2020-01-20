package com.sg.flooring.dao;

public class DataPersistenceException extends Exception {

	public DataPersistenceException(String message) {
		super(message);
	}
	public DataPersistenceException(String message, Throwable cause) {
		super(message,cause);
	}
}
