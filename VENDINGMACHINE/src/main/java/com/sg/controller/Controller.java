package com.sg.controller;

import java.math.BigDecimal;
import java.util.List;

import com.sg.dao.PersistenceException;
import com.sg.model.Change;
import com.sg.model.VendableItem;
import com.sg.service.InsufficentFundsException;
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
		try {
			// Start of program asks for money before getting choices.
			displayVendorItems();
			// Ask user for money
			addDollarsInMachine(requestUserForMoney());
			view.displayBalance(getBalance());
			do {
				// Get user choice
				int choice = getChoice();
				if (choice == service.getAllItemsInStock().size() + 1) {
					break;
				}
				VendableItem item = choiceToItem(choice);
				try {
					BigDecimal change = vendItem(item);
					if (keepVending()) {
						displayItemsInStock();// Display Items
						addDollarsInMachine(change);
						view.displayBalance(getBalance());
					} else {
						break;// Break if keep vending is false.
					}

				} catch (InsufficentFundsException e) {
					view.insufficientFundsException(getBalance(), item);
					// ask for more money
					addDollarsInMachine(requestUserForMoney());
					view.displayBalance(getBalance());
					displayVendorItems();
				}

			} while (true);
		} catch (PersistenceException e) {
			view.displayError(e.getMessage());
			System.exit(0);
		}
		view.displayExitMessage();
	}

	private boolean keepVending() {
		return view.keepVending();
	}

	private BigDecimal vendItem(VendableItem item) throws InsufficentFundsException, PersistenceException {
		BigDecimal change = service.vendItem(item.getPrice(), item);
		view.displayVend(item);
		// IF change is not zero
		if (change.equals(BigDecimal.ZERO) == false) {
			view.displayChange(new Change(change));
		}
		// remove everything from machine
		removeFromMachine(getBalance());
		return change;

	}

	private void removeFromMachine(BigDecimal amount) {
		this.balance.removeBalance(amount);
	}

	private VendableItem choiceToItem(int choice) throws PersistenceException {
		return service.getAllItems().get(choice);
	}

	private int getChoice() throws PersistenceException {
		return view.askForUserChoice(0, service.getAllItemsInStock().size());
	}

	private BigDecimal getBalance() {

		return this.balance.getBalance();
	}

	private void addDollarsInMachine(BigDecimal requestUserForMoney) {
		this.balance.addBalance(requestUserForMoney);
	}

	/** Helper Methods **/

	private void displayVendorItems() throws PersistenceException {
		view.displayOutOfStock(service.getAllItemsOutOfStock());
		displayItemsInStock();
	}

	private BigDecimal requestUserForMoney() {
		BigDecimal amount = view.requestMoney();
		return amount;
	}

	private void displayItemsInStock() throws PersistenceException {
		List<VendableItem> itemsInStock = service.getAllItemsInStock();
		if (itemsInStock.isEmpty()) {
			view.displayOutOfService();
            System.exit(0);
		} else {
            view.displayInStock(itemsInStock);
		}
	}
}
