package com.sg.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.sg.dao.PersistenceException;
import com.sg.model.Change;
import com.sg.model.Item;
import com.sg.service.InsufficentFundsException;
import com.sg.service.NoItemInventoryException;
import com.sg.service.Service;
import com.sg.ui.View;

/**
 * @author hareeshdevarasetty
 *
 */
public class Controller {

	private View view;
	private Service service;

	public Controller(View view, Service service) {
		this.view = view;
		this.service = service;
	}

	// -------------Main Menu ---------------//

	public void run() throws PersistenceException {
		String menuSelection;

		boolean keepGoing = true;

		while (keepGoing) {
			menuSelection = view.printMenuAndGetSelection();

			switch (menuSelection) {
			case "1":
				userPanel();
				break;
			case "2":
				keepGoing = false;
				break;
			case "abc":
				ExtraMenu();
				break;
			default:
				view.displaExitBanner();
				break;
			}
		}
		view.displaExitBanner();
	}

	private void ExtraMenu() throws PersistenceException {

		int userSelection = 0;
		boolean hasErrors = false;
		boolean keepGoing = true;

		do {
			try {
				userSelection = view.displaySecretMenu();
				hasErrors = false;

				switch (userSelection) {
				case 1:
					addItem();
					break;
				case 2:
					listAllItems();
					break;
				case 3:
					removeItems();
					break;
				case 4:
					hasErrors = false;
					keepGoing = false;
					break;
				}

			} catch (NumberFormatException e) {
				hasErrors = true;
				view.displayErrorMessage(e.getMessage());
			}
		} while (hasErrors || keepGoing);

	}

	private void removeItems() throws PersistenceException {
		view.displayRemoveItemBanner();

		String strItem = view.removeItem();
		try {
			service.removeItem(strItem);
			view.displaySuccessRemoveItemBanner();
		} catch (NoItemInventoryException e) {
			view.displayErrorMessage(e.getMessage());
		}

	}

	private void listAllItems() throws PersistenceException {
		List<Item> list = service.getAllItems();
		view.displayAllItems(list);
	}

	private void addItem() throws PersistenceException {
		view.displayAddBanner();

		try {
			Item itemToAdd = view.getItemToAdd();
			service.addItem(itemToAdd);
			view.displayAddSuccessBanner(itemToAdd);
		} catch (NoItemInventoryException e) {
			view.displayErrorMessage(e.getMessage());
		}

	}

	private void userPanel() throws PersistenceException {

		boolean hasErrors = false;

		Change change;

		List<Item> allItems = service.getAllItems();
		ArrayList<Item> orderedItems = new ArrayList<>(allItems);

		do {
			try {
				BigDecimal moneyFromConsumer = view.displayUserMenuItemsGetMoney(allItems, service.getCurrentMoney());
				service.addToMoney(moneyFromConsumer);
				Item itemSelected = view.getItemSelection(orderedItems);

				if (itemSelected == null) {
					view.displaExitBannerWithMoney(service.getCurrentMoney());
					hasErrors = false;
				} else {
					change = service.buyItem(itemSelected.getItemName(), service.getCurrentMoney());
					hasErrors = false;
					view.displayPurchaseSuccess(itemSelected);
					view.displayChange(change);
				}
			} catch (NoItemInventoryException | InsufficentFundsException | IndexOutOfBoundsException e) {
				hasErrors = true;
				view.displayErrorMessage(e.getMessage());
			}
		} while (hasErrors);
	}

}
