package com.sguild.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.sguild.dto.Student;

public class ClassRosterDaoFileImpl implements ClassRosterDao {

	public static final String ROSTER_FILE = "roster.txt";
	public static final String DELIMITER = "|";
	private Map<String, Student> students = new HashMap<String, Student>();

	public Student addStudent(String studentId, Student student) throws ClassRosterPersistenceException {

		Student newStudent = students.put(studentId, student);
		writeRoster();
		return newStudent;
	}

	public List<Student> getAllStudents() throws ClassRosterPersistenceException {
		loadRoster();
		return new ArrayList<Student>(students.values());
	}

	public Student getStudent(String studentId) throws ClassRosterPersistenceException {
		loadRoster();
		return students.get(studentId);
	}

	public Student removeStudent(String studentId) throws ClassRosterPersistenceException {
		writeRoster();
		Student removeStudent = students.get(studentId);
		return removeStudent;
	}

	@SuppressWarnings("unused")
	private void writeRoster() throws ClassRosterPersistenceException {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(ROSTER_FILE));
		} catch (IOException e) {
			throw new ClassRosterPersistenceException("Could not save student data.", e);
		}

		List<Student> studentList = this.getAllStudents();

		for (Student currentStudent : studentList) {
			// write the Student object to the file
			out.println(currentStudent.getStudentId() + DELIMITER + currentStudent.getFirstName() + DELIMITER
					+ currentStudent.getLastName() + DELIMITER + currentStudent.getCohort());
			// force PrintWriter to write line to the file
			out.flush();
		}
		out.close();
	}

	@SuppressWarnings({ "unused", "resource" })
	private void loadRoster() throws ClassRosterPersistenceException {

		Scanner scanner;

		try {
			scanner = new Scanner(new BufferedReader(new FileReader(ROSTER_FILE)));
		} catch (FileNotFoundException e) {
			throw new ClassRosterPersistenceException("Could not load roster data in to memory.", e);
		}
		String currentLine;

		String[] currentTokens;

		while (scanner.hasNextLine()) {
			currentLine = scanner.nextLine();
			currentTokens = currentLine.split(DELIMITER);

			Student currentStudent = new Student(currentTokens[0]);
			currentStudent.setFirstName(currentTokens[1]);
			currentStudent.setLastName(currentTokens[2]);
			currentStudent.setCohort(currentTokens[3]);
			// Put current student into the Map using Student ID as the key.
			students.put(currentStudent.getStudentId(), currentStudent);
		}
		scanner.close();
	}
}
