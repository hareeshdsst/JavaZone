package com.sguild.dao;

@SuppressWarnings("serial")
public class ClassRosterPersistenceException extends Exception {
    public ClassRosterPersistenceException(String message) {
        super(message);
    }

    public ClassRosterPersistenceException(String message, Throwable cause) {
        super(message, cause);
    }
}