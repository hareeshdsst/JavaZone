package com.sguild.ui;

import java.util.List;

import com.sguild.dto.Student;

public class ClassRosterView {
	UserIO io;

	public ClassRosterView(UserIO io) {
		this.io = io;
	}

	public int printMenuAndGetSelection() {
		io.print("Main Menu");
		io.print("1. List Student IDs");
		io.print("2. Create New Student");
		io.print("3. View a Student");
		io.print("4. Remove a Student");
		io.print("5. Exit");
		return io.readInt("Please select from the above choices.", 1, 5);
	}

	public Student getNewStudentInfo() {
		String studentId = io.readString("Please enter student ID:");
		String firstName = io.readString("Please enter student first name:");
		String lastName = io.readString("Please enter student last name:");
		String cohort = io.readString("Please enter cohort details:");

		Student newStudent = new Student(studentId);
		newStudent.setFirstName(firstName);
		newStudent.setLastName(lastName);
		newStudent.setCohort(cohort);
		return newStudent;
	}

	public void displayCreateStudentBanner() {
		io.print("=== Create Student ===");
	}

	public void displayCreateSuccessBanner() {
		io.readString("Student successfully created.  Please hit enter to continue");
	}

	public void displayStudentList(List<Student> studentList) {
		for (Student currentStudent : studentList) {
			io.print(currentStudent.getStudentId() + ": " + currentStudent.getFirstName() + " "
					+ currentStudent.getLastName());
		}
		io.readString("Please hit enter to continue.");
	}

	public void displayDisplayAllBanner() {
		io.print("=== Display All Students ===");
	}

	public void displayDisplayStudentBanner() {
		io.print("=== Display Student ===");
	}

	public String getStudentIdChoice() {
		return io.readString("Please enter the Student ID.");
	}

	public void displayRemoveStudentBanner() {
		io.print("=== Remove Student ===");
	}

	public void displayRemoveSuccessBanner() {
		io.readString("Student successfully removed. Please hit enter to continue.");
	}

	public void displayExitBanner() {
		io.print("Good Bye!!!");
	}

	public void displayUnknownCommandBanner() {
		io.print("Unknown Command!!!");
	}

	public void diaplayStudent(Student student) {
		if (student != null) {
			io.print(student.getStudentId());
			io.print(student.getFirstName() + " " + student.getLastName());
			io.print(student.getCohort());
			io.print("");
		} else {
			io.print("No Such student");
		}
		io.readString("Please hit enter to continue.");
	}
	
	public void displayErrorMessage(String errorMessage){
		io.print("======ERROR======");
		io.print(errorMessage);
	}
}
