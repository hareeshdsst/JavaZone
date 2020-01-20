package com.practice.dvdlibrary;

import java.io.IOException;

import com.practice.controller.DvdLibraryController;
import com.practice.dao.DVDLibraryPersistenceException;
import com.practice.dao.DvdLibraryDao;
import com.practice.dao.DvdLibraryDaoImpl;
import com.practice.ui.DVDLibraryView;
import com.practice.ui.DvdIO;
import com.practice.ui.DvdIOImpl;


public class App {
	public static void main(String[] args) throws DVDLibraryPersistenceException, IOException {
		//Initialize UI, Dao(Map, DVD Object before sending data to controller)
		DvdIO io = new DvdIOImpl();
		DVDLibraryView view = new DVDLibraryView(io);
		DvdLibraryDao dao = new DvdLibraryDaoImpl();
		DvdLibraryController controller = new DvdLibraryController(view, dao);
		controller.run();
	}
}
