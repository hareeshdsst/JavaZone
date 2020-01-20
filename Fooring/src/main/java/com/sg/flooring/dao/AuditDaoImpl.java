package com.sg.flooring.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AuditDaoImpl implements AuditDao {

	public static final String AUDIT_FILE = "audit.txt";

	@Override
	public void writeAudit(String entry) throws DataPersistenceException {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
		} catch (IOException e) {
			throw new DataPersistenceException("Could'nt write in to file", e);
		}

		LocalDateTime timeStamp = LocalDateTime.now();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

		String formatedTs = timeStamp.format(formatter);
		out.println(formatedTs + " : " + entry);
		out.flush();
	}

}
