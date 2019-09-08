package com.sguild.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import com.sguild.dao.ClassRosterAuditDao;
import com.sguild.dao.ClassRosterAuditDaoStubImpl;
import com.sguild.dao.ClassRosterDao;
import com.sguild.dao.ClassRosterDaoStubImpl;
import com.sguild.dto.Student;

public class ClassRosterServiceTest {

	private ClassRosterServiceLayer service;

	public ClassRosterServiceTest() {
		ClassRosterDao dao = new ClassRosterDaoStubImpl();
		ClassRosterAuditDao auditDoa = new ClassRosterAuditDaoStubImpl();
		service = new ClassRosterServiceLayerImpl(dao, auditDoa);
	}

	@Test
	public void testCreateStudent() throws Exception {
		Student student = new Student("0002");
		student.setFirstName("Sally");
		student.setLastName("Getu");
		student.setCohort("DS");
		service.createStudent(student);
	}

	@Test
	public void testCreateStudentDuplicate() throws Exception {
		Student student = new Student("0001");
		student.setFirstName("Sally");
		student.setLastName("Getu");
		student.setCohort("DS");
		try {
			service.createStudent(student);
			fail("Expected ClassRosterDuplicateIdException was not thrown");
		} catch (ClassRosterDuplicateIdException e) {
			return;
		}
	}

	@Test
	public void testCreateStudentInvalidData() throws Exception {
		Student student = new Student("0002");
		student.setFirstName("");
		student.setLastName("Getu");
		student.setCohort("DS");
		try {
			service.createStudent(student);
			fail("Expected ClassRosterDataValidationException was not thrown");
		} catch (ClassRosterDataValidationException e) {
			return;
		}
	}
	
	@Test
	public void testGetAllStudents() throws Exception {
		assertEquals(1, service.getAllStudents().size());
	}

	@Test
	public void testGetStudent() throws Exception {
		Student student =  service.getStudent("0001");
		assertNotNull(student);
		student =  service.getStudent("0009");
		assertNull(student);
	}
	
	@Test
	public void testRemoveStudent() throws Exception {
		Student student = service.removeStudent("0001");
		assertNotNull(student);
		student = service.removeStudent("9999");
		assertNull(student);
	}
}
