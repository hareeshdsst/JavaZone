package com.sg.app;

import com.sg.controller.Controller;
import com.sg.dao.Dao;
import com.sg.dao.DaoFileImpl;
import com.sg.service.Service;
import com.sg.service.ServiceImpl;
import com.sg.ui.UserIO;
import com.sg.ui.UserIOConsoleImpl;
import com.sg.ui.View;

public class App {
	public static void main(String[] args) {
		// Initialize Service , View layers in App class.
		Dao dao = new DaoFileImpl();
		Service serv = new ServiceImpl(dao);

		UserIO io = new UserIOConsoleImpl();
		View view = new View(io);

		Controller controller = new Controller(view, serv);
		controller.run();
	}
}
