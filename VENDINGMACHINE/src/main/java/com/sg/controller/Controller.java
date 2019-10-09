package com.sg.controller;

import com.sg.service.Service;
import com.sg.ui.View;

public class Controller {

	private View view;
	private Service service;
	private MachineBalance balance;

	public Controller(View view, Service service) {
		this.view = view;
		this.service = service;
		this.balance = new MachineBalance();
	}

	public void run() {
		view.displayEntryBanner();
	}
}
