package com.sg.flooring.controller;

import java.io.IOException;
import java.time.LocalDate;

import com.sg.flooring.constants.FlooringModeEnum;
import com.sg.flooring.dao.DataPersistenceException;
import com.sg.flooring.model.Order;
import com.sg.flooring.service.InvalidOrderNumberException;
import com.sg.flooring.service.Service;
import com.sg.flooring.service.StateValidationException;
import com.sg.flooring.ui.View;

public class Controller {

	Service service;
	View view;

	public Controller(Service service, View veiw) {
		this.service = service;
		this.view = veiw;
	}

	public void execute()
			throws DataPersistenceException, StateValidationException, IOException, InvalidOrderNumberException {
		boolean keepGoing = true;
		int menuSelection = 0;
		while (keepGoing) {
			menuSelection = getMenuSelection();

			switch (menuSelection) {
			case 1:
				getOrdersByDate();
				break;
			case 2:
				addorder();
				break;
			case 3:
				editOrder();
				break;
			case 4:
				removeOrder();
				break;
			case 5:
				keepGoing = false;
				break;
			default:
				unknownCommand();
			}
		}
		exitmessage();
	}

	private void exitmessage() {
		view.displayExitbanner();

	}

	private void unknownCommand() {
		view.displayUnknownCommandBanner();

	}

	private void removeOrder() throws DataPersistenceException {
		LocalDate date = view.getDate();
		view.displayDateBanner(date);
		try {
			view.displayDateOrders(service.getOrders(date));
			int orderNumber = view.getOrderNumber();
			Order o = service.getOrder(date, orderNumber);
			view.displayRemoveOrder();
			view.displayOrder(o);
			String response = view.askRemove();
			if (response.equalsIgnoreCase("Y")) {
				service.removeOrder(o);
				view.displayRemoveOrderSuccess(true, o);
			} else if (response.equalsIgnoreCase("N")) {
				view.displayRemoveOrderSuccess(false, o);
			} else {
				unknownCommand();
			}
		} catch (InvalidOrderNumberException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}

	private void editOrder() throws DataPersistenceException {
		view.displayEditOrder();
		try {
			LocalDate date = view.getDate();
			int orderNumber = view.getOrderNumber();
			Order savedOrderNumber = service.getOrder(date, orderNumber);
			Order editOrderNumber = view.editOrderInfo(savedOrderNumber);

			Order updatedOrderNumber = service.compareOrders(savedOrderNumber, editOrderNumber);
			view.displayEditOrder();
			view.displayOrder(updatedOrderNumber);
			String response = view.saveOrder();
			if (response.equalsIgnoreCase("Y")) {
				service.editOrder(updatedOrderNumber);
				view.displayEditOrderSuccess(true, updatedOrderNumber);
			} else if (response.equalsIgnoreCase("N")) {
				view.displayEditOrderSuccess(false, updatedOrderNumber);
			} else {
				unknownCommand();
			}
		} catch (InvalidOrderNumberException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}

	private void addorder()
			throws DataPersistenceException, StateValidationException, IOException, InvalidOrderNumberException {
		try {
			Order order = service.calculateOrder(view.getOrder());
			view.displayOrder(order);
			String response = "Y";
			if(FlooringModeEnum.getMode().equals(FlooringModeEnum.PRODUCTION)) {
			response = view.saveOrder();
			}
			if (response.equalsIgnoreCase("Y")) {
				service.addOrder(order);
				view.displayAddOrderSuccess(true, order);
			} else if (response.equalsIgnoreCase("N")) {
				view.displayAddOrderSuccess(false, order);
			} else {
				unknownCommand();
			}
		} catch (StateValidationException | DataPersistenceException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}

	private void getOrdersByDate() throws DataPersistenceException, StateValidationException {
		LocalDate date = view.getDate();
		view.displayDateBanner(date);
		try {
			view.displayDateOrders(service.getOrders(date));
			view.displayContinue();
		}catch (DataPersistenceException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}

	private int getMenuSelection() {
		return view.printMenuAndGetSelection();
	}
}
