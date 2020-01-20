package com.sg.flooring.advice;

import org.aspectj.lang.JoinPoint;

import com.sg.flooring.dao.AuditDao;
import com.sg.flooring.dao.DataPersistenceException;

public class LoggingAdvice {

	AuditDao auditDao;

	public LoggingAdvice(AuditDao auditDao) {
		this.auditDao = auditDao;
	}

	public void createAuditEntry(JoinPoint jp) {

		Object[] args = jp.getArgs();
		String auditEntry = jp.getSignature().getName() + ": ";

		for (Object currentArg : args) {
			auditEntry += " " + currentArg;
		}
		try {
			auditDao.writeAudit(auditEntry);
		} catch (DataPersistenceException e) {
			System.err.println("Error: could not create entry");
		}
	}
}
