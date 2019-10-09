package com.sg.service;

public class InsufficentFundsException extends Exception {
    public InsufficentFundsException() {
    }

    public InsufficentFundsException(String message) {
        super(message);
    }

    public InsufficentFundsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InsufficentFundsException(Throwable cause) {
        super(cause);
    }

    public InsufficentFundsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
