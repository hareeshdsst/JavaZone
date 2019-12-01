package com.sg.app;

import com.sg.controller.Controller;
import com.sg.dao.VendingMachineDao;
import com.sg.dao.VendingMachineDaoFileImpl;
import com.sg.service.Service;
import com.sg.service.ServiceImpl;
import com.sg.ui.UserIO;
import com.sg.ui.UserIOConsoleImpl;
import com.sg.ui.View;

/**
 * @author hareeshdevarasetty
 *
 */
public class App {
	public static void main(String[] args) {
		// Instantiate the UserIO Implementations
		UserIO io = new UserIOConsoleImpl();
		// Instantiate the View Implementation and wire the UserIO into it.
		View view = new View(io);
		// Instantiate the DAO
		VendingMachineDao dao = new VendingMachineDaoFileImpl();
		// Instantiate the Service layer
		Service serv = new ServiceImpl(dao);
		// Instantiate the Controller Implementation and wire the Service into it.
		Controller control = new Controller(view, serv);
		//Kick off the controller
		control.run();
	}
}
