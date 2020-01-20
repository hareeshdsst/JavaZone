package com.sg.flooring.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import com.sg.flooring.model.Order;

public class View {

	private UserIO io;

	public View(UserIO io) {
		this.io = io;
	}

	public int printMenuAndGetSelection() {
		io.print("====Hareesh Corp Menu====");
		io.print("1. Display Orders");
		io.print("2. Add Orders");
		io.print("3. Edit Orders");
		io.print("4. Remove Orders");
		io.print("5. Exit");
		return io.readInt("Please select from the above options", 1, 5);
	}

	public Order getOrder() {
		Order order = new Order();
		order.setDate(getDate());
		order.setCustomerName(getCustName());
		order.setState(getState());
		order.setProductType(getProdType());
		order.setArea(getArea());
		return order;

	}

	public BigDecimal getArea() {
		return io.readBigDecimal("Please enter the area of your project in square feet", 2, BigDecimal.ZERO);
	}

	public String getProdType() {
		return io.readString("Please enter product you will be using", 15);
	}

	public String getState() {
		return io.readString("Please enter your State Abbr Ex.MI", 2);
	}

	public String getCustName() {
		return io.readString("Please enter your name.");
	}

	public LocalDate getDate() {
		return io.readDate("Please enter a date. (MM-DD-YYYY)", LocalDate.of(2005, 1, 1), LocalDate.of(2050, 1, 31));
	}

	public void displayErrorMessage(String message) {
		io.print("=====ERROR=======");
		io.print(message);
		displayContinue();
	}

	public void displayOrder(Order o) {
		io.print("Date: " + o.getDate());
		io.print("Cutomer Name: " + o.getCustomerName());
		io.print("State: " + o.getState());
		io.print("Tax Rate: " + o.getTaxRate() + "%");
		io.print("Product: " + o.getProductType());
		io.print("Material Cost per sq feet: " + io.formatCurrency(o.getCstPerSqrFt()));
		io.print("Labor Cost per sq feet : " + io.formatCurrency(o.getLaborcstPerSqrFt()));
		io.print("Area: " + o.getArea());
		io.print("Material Cost: " + io.formatCurrency(o.getMaterialCost()));
		io.print("Labor Cost: " + io.formatCurrency(o.getLaborCost()));
		io.print("Tax: " + o.getTax());
		io.print("==== TOTAL: " + io.formatCurrency(o.getTotal()) + "====");
	}

	public String saveOrder() {
		return io.readString("Do you want to save order (Y/N)", 1);
	}

	public void displayAddOrderSuccess(boolean success, Order o) {
		if (success == true) {
			io.print("Order #" + o.getOrderNumber() + "was successfully added");
		} else {
			io.print("Order was not saved");
			displayContinue();
		}

	}

	public void displayContinue() {
		io.readString("Hit Enter to continue");
	}

	public void displayUnknownCommandBanner() {
		io.readString("Unknown command");
		displayContinue();
	}

	public void displayDateBanner(LocalDate date) {
		System.out.printf("====Orders on %s ====\n", date);
	}

	public void displayDateOrders(List<Order> orders) {
		for (Order o : orders) {
			io.print(o.getOrderNumber() + " | " + o.getCustomerName() + " | " + io.formatCurrency(o.getTotal()));
		}

	}

	public int getOrderNumber() {
		return io.readInt("Please enter an order number");
	}

	public void displayRemoveOrder() {
		io.print("REMOVE ORDER");
	}

	public String askRemove() {
		return io.readString("Would you like you remove this order? Y/N", 1);
	}

	public void displayRemoveOrderSuccess(boolean success, Order o) {
		if (success == true) {
			io.print("Order #" + o.getOrderNumber() + "was successfully removed");
		} else {
			io.print("Order was not removed");
			displayContinue();
		}

	}

	public void displayEditOrderSuccess(boolean success, Order o) {
		if (success == true) {
			io.print("Order #" + o.getOrderNumber() + "was successfully edited");
		} else {
			io.print("Order was not edited");
			displayContinue();
		}

	}

	public void displayEditOrder() {
		io.print("==== EDIT ORDER ====");
	}

	public Order editOrderInfo(Order savedOrderNumber) {
		Order editedOrder = new Order();
		io.print("Customer Name: " + savedOrderNumber.getCustomerName());
		editedOrder.setCustomerName(getCustName());

		io.print("State Name: " + savedOrderNumber.getState());
		editedOrder.setState(getState());

		io.print("Product Name: " + savedOrderNumber.getProductType());
		editedOrder.setProductType(getProdType());

		io.print("Area : " + savedOrderNumber.getArea() + "Sq Ft");
		editedOrder.setArea(getArea());
		return editedOrder;
	}

	public void displayExitbanner() {
		io.print("Thanks Please visit again!!!");
	}

}
