package com.sguild.service;

import java.util.List;

import com.sguild.dao.ClassRosterPersistenceException;
import com.sguild.dto.Student;

public interface ClassRosterServiceLayer {

	public void createStudent(Student student) throws ClassRosterDuplicateIdException,
	ClassRosterDataValidationException,
	ClassRosterPersistenceException;
	
	public List<Student> getAllStudents() throws ClassRosterPersistenceException;
	
	public Student getStudent(String studentId) throws ClassRosterPersistenceException;
	
	public Student removeStudent(String studentId) throws ClassRosterPersistenceException;
	
}
