package com.sguild.classroster;

import com.sguild.controller.ClassRosterController;
import com.sguild.dao.ClassRosterDao;
import com.sguild.dao.ClassRosterDaoFileImpl;
import com.sguild.dao.ClassRosterPersistenceException;
import com.sguild.ui.ClassRosterView;
import com.sguild.ui.UserIO;
import com.sguild.ui.UserIOConsoleImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ClassRosterPersistenceException {
	    UserIO myIo = new UserIOConsoleImpl();
	    ClassRosterView myView = new ClassRosterView(myIo);
	    ClassRosterDao myDao = new ClassRosterDaoFileImpl();
	    ClassRosterController controller = 
	            new ClassRosterController(myDao, myView);
	    controller.run();
	}
}
