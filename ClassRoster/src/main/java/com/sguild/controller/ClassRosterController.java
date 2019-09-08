package com.sguild.controller;

import java.util.List;

import com.sguild.dao.ClassRosterDao;
import com.sguild.dao.ClassRosterPersistenceException;
import com.sguild.dto.Student;
import com.sguild.service.ClassRosterDataValidationException;
import com.sguild.service.ClassRosterDuplicateIdException;
import com.sguild.service.ClassRosterServiceLayer;
import com.sguild.ui.ClassRosterView;

public class ClassRosterController {

	ClassRosterView view;
	ClassRosterServiceLayer service;

	public ClassRosterController(ClassRosterView view, ClassRosterServiceLayer service) {
		this.service = service;
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
					break;
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
		boolean hasErrorFlag = false;
		do {
			Student newStudent = view.getNewStudentInfo();
			try {
				service.createStudent(newStudent);
				view.displayCreateSuccessBanner();
				hasErrorFlag = false;
			}catch(ClassRosterDuplicateIdException | ClassRosterDataValidationException e) {
				hasErrorFlag = true;
				view.displayErrorMessage(e.getMessage());
			}
		}while(hasErrorFlag);
	}

	private void listStudents() throws ClassRosterPersistenceException {
		view.displayDisplayAllBanner();
		List<Student> studentList = service.getAllStudents();
		view.displayStudentList(studentList);
	}

	private void viewStudent() throws ClassRosterPersistenceException {
		view.displayDisplayStudentBanner();
		String studentId = view.getStudentIdChoice();
		//Pass through method
		Student student = service.getStudent(studentId);
		view.diaplayStudent(student);
	}

	private void removeStudent() throws ClassRosterPersistenceException {
		view.displayRemoveStudentBanner();
		String studentId = view.getStudentIdChoice();
		service.removeStudent(studentId);
		view.displayRemoveSuccessBanner();
	}

	private void unknownCommand() {
		view.displayUnknownCommandBanner();
	}

	private void exitMessage() {
		view.displayExitBanner();
	}
}
