package com.sg.ui;

import java.math.BigDecimal;
import java.util.ArrayList;
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

	public String displaExitBannerWithMoney(BigDecimal money) {
		io.print("Please take back your money $" + money.toString() + "!");
		return enterToCont();
	}
	private String enterToCont() {
		// TODO Auto-generated method stub
		return io.readString("Please enter to continue");
	}

	public void displayUnknownCommandBanner() {
		io.print("Unknown Command");
	}

	public void displayAllItems(List<Item> items) {
		io.print("Inventory List");
		for(Item item : items) {
			io.print(item.getItemName() + " " + item.getItemQuantity() + " " + item.getItemPrice());
		}
		io.print("");
	}

	public String printMenuAndGetSelection() {
		io.print("Welome to Vending!!!!!");
		io.print("Hareesh's Vending Machine");
		return io.readString("Input[1] to continue, [2] to exit, or input abc");
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



	public void displayPurchaseSuccess(Item purchasedItem) {
	     io.print("Purchase success!");
	     io.print("Enjoy your " + purchasedItem.getItemName() + "!!!");
	}
	public int displaySecretMenu() {
		io.print("******* Inventory Menu ******* ");		
		return io.readInt("1. Add to inventory \n2. View Inventory \n3. Remove from Inventory \n4. Return to main menu");
	}

	public void displayRemoveItemBanner() {
		io.print("Item to be removed from Inventory");
		
	}

	public String removeItem() {
		return io.readString("Please enter the item ID.to be removed");
	}

	public void displaySuccessRemoveItemBanner() {
		io.print("Item to be added to Inventory");
	}

	public void displayAddBanner() {
		io.print("");
		
	}

	public void displayAddSuccessBanner(Item itemToAdd) {
		String num = String.valueOf(itemToAdd.getItemQuantity());
		String price = itemToAdd.getItemPrice().toString();
		io.print(itemToAdd.getItemName() + " " + num + " " + price );
		io.print("Successfully Added");
		
	}

	public Item getItemToAdd() {
		String name = io.readString("Enter name of item to sell");
		String price = io.readString("Enter price");
		int noOf = io.readInt("Enter number of items to be added");

		Item item = new Item(name);
		item.setItemPrice(price);
		item.setItemQuantity(noOf);

		return item;
	}
	
	public BigDecimal displayUserMenuItemsGetMoney(List<Item> itemsList, BigDecimal initialAmount) {
		io.print("Hareesh's Vending Machine");
		itemsList.stream().forEach(i -> io.print(i.getItemName() 
				+ "\n In Stock: " + String.valueOf(i.getItemQuantity()
						+ "\n Price: $" + i.getItemPrice().toString())));
		io.print("\n current Money in : $" + initialAmount);

		return io.readBigDecimal("Put in your money: \n $");
	}

	public Item getItemSelection(ArrayList<Item> itemsList) {
		
		int menuNumber = 1;
		for(Item i : itemsList) {
			io.print((menuNumber) + ". " + i.getItemName());
			menuNumber++;
		}
		io.print((menuNumber) + " . Exit");
		int selection = io.readInt("Enter number choice", 1, menuNumber);
		try {
			return itemsList.get(selection - 1);
		}catch(IndexOutOfBoundsException e) {
			return null;
		}
	}
}