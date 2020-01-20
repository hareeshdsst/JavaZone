package com.sg.service;

public class NoItemInventoryException extends Exception {

	public NoItemInventoryException() {
	}

	public NoItemInventoryException(String message) {
		super(message);
	}

	public NoItemInventoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public NoItemInventoryException(Throwable cause) {
		super(cause);
	}

	public NoItemInventoryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
