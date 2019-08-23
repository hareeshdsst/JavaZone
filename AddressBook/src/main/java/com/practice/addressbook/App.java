package com.practice.addressbook;

import controller.AddressBookController;
import dao.AddressBookDao;
import dao.AddressBookDaoFileImpl;
import ui.AddressBookView;
import ui.UserIO;
import ui.UserIOConsoleImpl;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		UserIO io = new UserIOConsoleImpl();
		AddressBookView addressBookView = new AddressBookView(io);
		AddressBookDao addressBookDao = new AddressBookDaoFileImpl();
		AddressBookController controller = new AddressBookController(addressBookView,addressBookDao);
		controller.run();
		
	}
}
