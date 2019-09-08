package com.sguild.dao;

import java.util.ArrayList;
import java.util.List;

import com.sguild.dto.Student;

public class ClassRosterDaoStubImpl implements ClassRosterDao {

	Student onlyStudent;
	List<Student> studentList = new ArrayList<Student>();

	public ClassRosterDaoStubImpl() {
		onlyStudent = new Student("0001");
		onlyStudent.setFirstName("Hareesh");
		onlyStudent.setLastName("Deva");
		onlyStudent.setCohort("Java");
	}

	@Override
	public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {
		if (studentId.equals(onlyStudent.getStudentId())) {
			return onlyStudent;
		} else {
			return null;
		}

	}

	@Override
	public List<Student> getAllStudents() throws ClassRosterPersistenceException {
		return studentList;
	}

	@Override
	public Student getStudent(String studentId) throws ClassRosterPersistenceException {
		if (studentId.equals(onlyStudent.getStudentId())) {
			return onlyStudent;
		} else {
			return null;
		}
	}

	@Override
	public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
		if (studentId.equals(onlyStudent.getStudentId())) {
			return onlyStudent;
		} else {
			return null;
		}
	}

}
