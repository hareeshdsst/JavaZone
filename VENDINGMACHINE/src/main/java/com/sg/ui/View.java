package com.sg.ui;

import java.math.BigDecimal;
import java.util.List;

import com.sg.model.Change;
import com.sg.model.Item;

/**
 * @author hareeshdevarasetty
 *
 */
public class View {

	private UserIO io;

	public View(UserIO io) {
		this.io = io;
	}

	public void displayErrorMessage(String message) {
		io.print("=====ERROR========");
		io.print(message);
	}

	public void displaExitBanner() {
		io.print("Thanks ! Have a good day");
	}

	public void displayUnknownCommandBanner() {
		io.print("Unknown Command");
	}

	public void displayAllItems(List<Item> items) {
		io.print("Inventory List");
		for(Item item : items) {
			io.print(item.getItemId() + " " + item.getItemName() + " " + item.getItemQuantity() + " " + item.getItemPrice());
		}
		io.print("");
	}

	public int printMenuAndGetSelection(BigDecimal currentMoney) {
		io.print("Welome to Vending!!!!!");
		io.print("Money inserted: " + currentMoney);
		io.print("1. Add Money");
		io.print("2. Purchasing an item");
		io.print("3. Get change");
		io.print("4. Exit");
		return io.readInt("Please select from above choices: ", 1, 4);
	}
	
	public BigDecimal getMoneyEntry() {
		return io.readBigDecimal("Please insert your money: ");
	}

	public void displayCurrentMoney(BigDecimal currentMoney) {
		io.print("Current money is : $" + currentMoney);
	}

	public String getItemChoice() {
		return io.readString("Please enter the item ID.");
	}

	public void displayChange(Change change) {
     io.print("Here is your change");
     io.print(change.getNumQuaters() + "  Quaters");
     io.print(change.getNumDimes() + "  Dimes");
     io.print(change.getNumNickles() + "  Nickels");
     io.print(change.getNumPennies() + "  Pennies");

	}

	public void displayPurchaseSuccess() {
	     io.print("Purchase success! Hit enter to continue");
	}
}