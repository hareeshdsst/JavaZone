package com.sg.ui;

import java.util.List;

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
			//append number onto front thiw will be used later
			// for choosing what to buy 
			io.print((itemsInStock.indexOf(item) + 1) + "\t");
			
		});
	}
}
