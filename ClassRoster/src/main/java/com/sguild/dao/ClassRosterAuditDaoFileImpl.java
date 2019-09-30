package com.sguild.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class ClassRosterAuditDaoFileImpl implements ClassRosterAuditDao{
	public static final String AUDIT_FILE = "audit.txt";
	
	@SuppressWarnings("resource")
	@Override
	public void writeAuditEntry(String entry) throws ClassRosterPersistenceException {
		
		@SuppressWarnings("unused")
		PrintWriter printWriter;
		
		try {
			printWriter = new PrintWriter(new FileWriter(AUDIT_FILE, true));
		} catch (IOException e) {
			throw new ClassRosterPersistenceException("Couldnt persist Audit information", e);
		}
		
		LocalDateTime timeStamp = LocalDateTime.now();
		printWriter.println(timeStamp.toString() + " : " + entry);
		printWriter.flush();
	}

}
