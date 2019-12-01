package com.sg.service;

@SuppressWarnings("serial")
public class InsufficentFundsException extends Exception {
    public InsufficentFundsException() {
    }

    public InsufficentFundsException(String message) {
        super(message);
    }

    public InsufficentFundsException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
