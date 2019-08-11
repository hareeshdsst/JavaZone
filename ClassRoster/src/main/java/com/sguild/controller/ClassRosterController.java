package com.sguild.controller;

import java.util.List;

import com.sguild.dao.ClassRosterDao;
import com.sguild.dao.ClassRosterPersistenceException;
import com.sguild.dto.Student;
import com.sguild.ui.ClassRosterView;

public class ClassRosterController {

	ClassRosterView view;
	ClassRosterDao dao;

	public ClassRosterController(ClassRosterDao dao, ClassRosterView view) {
		this.dao = dao;
		this.view = view;
	}

	public void run() throws ClassRosterPersistenceException {
		boolean keepGoing = true;
		int menuSeletion = 0;
		try {
			while (keepGoing) {
				menuSeletion = getMenuSelection();
				switch (menuSeletion) {
				case 1:
					listStudents();
					break;
				case 2:
					createStudent();
					break;
				case 3:
					viewStudent();
					break;
				case 4:
					removeStudent();
					break;
				case 5:
					keepGoing = false;
					break;
				default:
					unknownCommand();
				}
			}
			exitMessage();
		} catch (ClassRosterPersistenceException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}

	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}

	private void createStudent() throws ClassRosterPersistenceException {
		view.displayCreateStudentBanner();
		Student newStudent = view.getNewStudentInfo();
		dao.addStudent(newStudent.getStudentId(), newStudent);
		view.displayCreateSuccessBanner();
	}

	private void listStudents() throws ClassRosterPersistenceException {
		view.displayDisplayAllBanner();
		List<Student> studentList = dao.getAllStudents();
		view.displayStudentList(studentList);
	}

	private void viewStudent() throws ClassRosterPersistenceException {
		view.displayDisplayStudentBanner();
		String studentId = view.getStudentIdChoice();
		Student student = dao.getStudent(studentId);
		view.diaplayStudent(student);
	}

	private void removeStudent() throws ClassRosterPersistenceException {
		view.displayRemoveStudentBanner();
		String studentId = view.getStudentIdChoice();
		dao.removeStudent(studentId);
		view.displayRemoveSuccessBanner();
	}

	private void unknownCommand() {
		view.displayUnknownCommandBanner();
	}

	private void exitMessage() {
		view.displayExitBanner();
	}
}
