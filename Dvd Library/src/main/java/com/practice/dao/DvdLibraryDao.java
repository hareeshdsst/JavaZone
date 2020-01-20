package com.practice.dao;

import java.io.IOException;
import java.util.List;

import com.practice.dto.DVD;

public interface DvdLibraryDao {

	DVD addDVD(String title, DVD dvds) throws DVDLibraryPersistenceException, IOException;
	DVD getDVD(String title) throws DVDLibraryPersistenceException;
	List<DVD> getAllDVDs() throws DVDLibraryPersistenceException;
	DVD removeDVD(String title) throws DVDLibraryPersistenceException, IOException;
	DVD editDVD(String title, DVD dvds) throws DVDLibraryPersistenceException, IOException;
	
}
