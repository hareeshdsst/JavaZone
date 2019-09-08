package com.sguild.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sguild.dto.Student;
import com.sguild.ui.UserIO;

public class ClassRosterDaoTest {

	private ClassRosterDao dao = new ClassRosterDaoFileImpl();


	public ClassRosterDaoTest() {

	}

	@Before
	public void setUp() throws Exception {
		List<Student> studentList = dao.getAllStudents();
		for (Student student : studentList) {
			dao.removeStudent(student.getStudentId());
		}
		System.out.println(studentList.toString());
	}

	@Test
	public void testAddGetStudent() throws Exception {
		// Set up the Data or Arrange Data.
		Student student = new Student("101010");
		student.setFirstName("Vikas");
		student.setLastName("Putta");
		student.setCohort("Java");
		// Act On Data
		dao.addStudent(student.getStudentId(), student);
		System.out.println("Get Student " + student.getStudentId());
		Student fromDao = dao.getStudent(student.getStudentId());

		System.out.println("Get Student from DAO " + fromDao.getStudentId());
		// Assert
		assertEquals(student, fromDao);
	}

	@Test
	public void testRemoveStudent() throws Exception {
		// Set up the Data or Arrange Data.
		Student student1 = new Student("001");
		student1.setFirstName("Ravi");
		student1.setLastName("My");
		student1.setCohort("Java");
		// student1 On Data
		dao.addStudent(student1.getStudentId(), student1);

		// Set up the Data or Arrange Data.
		Student student2 = new Student("002");
		student2.setFirstName("Jan");
		student2.setLastName("Joe");
		student2.setCohort("Java");
		// student1 On Data
		dao.addStudent(student2.getStudentId(), student2);
		dao.removeStudent(student1.getStudentId());
		// Assert
		assertEquals(1, dao.getAllStudents().size());
		assertNull(dao.getStudent(student1.getStudentId()));
	}

	@Test
	public void testGetAllStudent() throws Exception {
		// Set up the Data or Arrange Data.
		Student student1 = new Student("3000");
		student1.setFirstName("Ravi");
		student1.setLastName("My");
		student1.setCohort("Java");
		// student1 On Data
		dao.addStudent(student1.getStudentId(), student1);

		// Set up the Data or Arrange Data.
		Student student2 = new Student("3001");
		student2.setFirstName("Ravi");
		student2.setLastName("My");
		student2.setCohort("Java");
		// student1 On Data
		dao.addStudent(student2.getStudentId(), student2);
	
	
	  // Assert
		assertEquals(6, dao.getAllStudents().size());
		
	}

}
