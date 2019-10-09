package com.sg.ui;

public class View {
	private UserIO io;

	public View(UserIO io) {
		this.io = io;
	}

	public void displayEntryBanner() {
		io.println("==============================");
		io.println("\tVENDING MACHINE");
		io.println("==============================");
	}

}
