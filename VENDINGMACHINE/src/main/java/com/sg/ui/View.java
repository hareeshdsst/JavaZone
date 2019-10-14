package com.sg.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import com.sg.model.Change;
import com.sg.model.VendableItem;

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

	public void displayOutOfStock(List<VendableItem> itemsOutOfStock) {
		itemsOutOfStock.forEach((item) -> {
			io.print("\t");
			printItem(item);
		});
	}

	private void printItem(VendableItem item) {
		io.print(item.getName() + " -----$" + item.getPrice() + " ----- ");
		if (item.getCount() <= 0) {
			io.println("Out Of Stock");
		} else {
			io.println(item.getCount() + " ");
		}
	}

	public void displayOutOfService() {
		io.println("Out of service!");
	}

	public void displayInStock(List<VendableItem> itemsInStock) {
		itemsInStock.forEach((item) -> {
			// append number onto front thiw will be used later
			// for choosing what to buy
			io.print((itemsInStock.indexOf(item) + 1) + "\t");
			printItem(item);
		});
	}

	public BigDecimal requestMoney() {
		BigDecimal result = null;
		do {
			String money = io.readString("Please enter $ Amount: ");
			try {
				result = new BigDecimal(money);
			} catch (NumberFormatException e) {
				io.print("Not a valid amount");
			}

		} while (result == null);
		result = result.setScale(2, RoundingMode.DOWN);
		return result;
	}

	public void displayBalance(BigDecimal balance) {
		io.println("The machines display reads: $" + balance);
	}

	public int askForUserChoice(int min, int max) {
		int result = -1;
		do {
			result = io.readInt("Enter Choice: ", min, max);
			if (result == -1) {
				io.println("Invalid choice.");
			}
		} while (result == -1);
		return result;
	}

	public void displayVend(VendableItem item) {
		io.println("The machine dispensed a " + item.getName() + "'");
	}

	public void displayChange(Change change) {
		io.print("The change returned : ");

		if (change.getQuaters() > 0) {
			io.println(change.getQuaters() + " Quaters");
		}

		if (change.getDimes() > 0) {
			io.println(change.getDimes() + " Dimes");
		}

		if (change.getNickels() > 0) {
			io.println(change.getNickels() + " Nickels");
		}

		if (change.getPennis() > 0) {
			io.println(change.getPennis() + " Pennis");
		}
	}

	public boolean keepVending() {
		String value = io.readString("Do you still want to vend: (Y/N");
		return "y".equalsIgnoreCase(value.charAt(value.length() - 1) + "");
	}

	public void insufficientFundsException(BigDecimal balanceInMachine, VendableItem item) {
		BigDecimal amountToAdd = item.getPrice().subtract(balanceInMachine);
		io.print("Insifficeint funds to purchase: " + item.getName() + "There is only $" + balanceInMachine
				+ "You need to add " + amountToAdd + "To buy " + item.getName());
	}

	public void displayError(String message) {
		io.println(message);
	}

	public void displayExitMessage() {
		io.println("Thanks for Vending.");
	}
}