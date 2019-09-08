package com.sguild.service;

import java.io.IOException;
import java.util.List;

import com.sguild.dao.ClassRosterAuditDao;
import com.sguild.dao.ClassRosterDao;
import com.sguild.dao.ClassRosterPersistenceException;
import com.sguild.dto.Student;

public class ClassRosterServiceLayerImpl implements ClassRosterServiceLayer {

	private ClassRosterDao classRosterDao;
	private ClassRosterAuditDao classRosterAuditDao;

	// initializing
	public ClassRosterServiceLayerImpl(ClassRosterDao classRosterDao, ClassRosterAuditDao classRosterAuditDao) {
		this.classRosterDao = classRosterDao;
		this.classRosterAuditDao = classRosterAuditDao;
	}

	// Add Business Rules.
	public void createStudent(Student student) throws ClassRosterDuplicateIdException,
			ClassRosterDataValidationException, ClassRosterPersistenceException {
		// Rule 1
		if (classRosterDao.getStudent(student.getStudentId()) != null) {
			throw new ClassRosterDuplicateIdException(
					"ERROR: Couldnt create student. Student Id " + student.getStudentId() + "Already exist");
		}
		// Rule 2
		validateStudentData(student);
		// Rule 3
		classRosterDao.addStudent(student.getStudentId(), student);
		try {
			classRosterAuditDao.writeAuditEntry("Student " + student.getStudentId() + "Created");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Pass through methods.
	public List<Student> getAllStudents() throws ClassRosterPersistenceException {
		return classRosterDao.getAllStudents();

	}

	public Student getStudent(String studentId) throws ClassRosterPersistenceException {
		return classRosterDao.getStudent(studentId);
	}

	public Student removeStudent(String studentId) throws ClassRosterPersistenceException {

		Student removeStudent = classRosterDao.removeStudent(studentId);
		try {
			classRosterAuditDao.writeAuditEntry("Student " + studentId + "Removed");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return removeStudent;
	}

	// Helper methods
	private void validateStudentData(Student student) throws ClassRosterDataValidationException {
		if (student.getFirstName() == null || student.getFirstName().trim().length() == 0
				|| student.getLastName() == null || student.getLastName().trim().length() == 0
				|| student.getCohort() == null || student.getCohort().trim().length() == 0) {
			throw new ClassRosterDataValidationException("ERROR ! First Name, Last Name, Cohort Details are required");
		}
	}

}
