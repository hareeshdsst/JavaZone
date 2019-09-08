package com.sguild.dao;

import java.io.IOException;

public interface ClassRosterAuditDao {

	public void writeAuditEntry(String entry) throws ClassRosterPersistenceException, IOException;
	
}
