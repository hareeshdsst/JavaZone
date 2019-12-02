package com.sg.controller;

import com.sg.dao.PersistenceException;
import com.sg.model.Change;
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

	public void run() {
		boolean keepGoing = true;
		int menuSelection =0;
		try {
			while(keepGoing) {
				menuSelection = getMenuSelection();	
				switch(menuSelection) {
				case 1:
					addMoney();
					break;
				case 2:
					purchase();
					break;
				case 3:
					giveChange();
					break;
				case 4:
					keepGoing = false;
					break;
				default:
					unknownCommand();
				}
			}
			exitMessage();
		}catch(PersistenceException | InsufficentFundsException | NoItemInventoryException e) {
			view.displayErrorMessage(e.getMessage());
		}
	}

	private void exitMessage() {
		view.displaExitBanner();
	}

	private void unknownCommand() {
		view.displayUnknownCommandBanner();
	}

	private void giveChange() throws PersistenceException {
		view.displayChange(service.cancelGiveChange());
	}

	private void purchase() throws PersistenceException, NoItemInventoryException, InsufficentFundsException{
        Boolean success = false;
        do {
        	try {
        		Change change = service.purchaseItem(view.getItemChoice());
        		view.displayChange(change);
        		view.displayPurchaseSuccess();
        		success = true;
        	}catch(PersistenceException | NoItemInventoryException | InsufficentFundsException e) {
        		view.displayErrorMessage(e.getMessage());
        		continue;
        	}
        }while(false);
	}
	private void addMoney() {
		service.setCurrentMoney(view.getMoneyEntry());
		view.displayCurrentMoney(service.getCurrentMoney());
	}

	private int getMenuSelection() {
		try {
			view.displayAllItems(service.getAllItemsFiltered());
		}catch(PersistenceException e) {
			view.displayErrorMessage(e.getMessage());
		}
		return view.printMenuAndGetSelection(service.getCurrentMoney());
	}

}
