package com.sg.flooring.dao;

public interface AuditDao {
	public void writeAudit(String entry) throws DataPersistenceException;
}
