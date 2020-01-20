package com.sg.flooring.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sg.flooring.constants.FlooringModeEnum;
import com.sg.flooring.model.Order;

public class OrdersDaoProdImpl implements OrderDao {

	private static final String HEADER = "OrderNumber,CustomerName,State,TaxRate,"
			+ "ProductType,Area,CostPerSquareFoot,LaborCostPerSquareFoot," + "MaterialCost,LaborCost,Tax,Total";
	public final static String DELIMITER = ",";
	public int lastOrderNumber;
	private String dataFolder = "orders/";

	public OrdersDaoProdImpl() {
	}

	public OrdersDaoProdImpl(String dataFolder) {
		this.dataFolder = dataFolder;
	}

	@Override
	public List<Order> getOrders(LocalDate dateChoice) throws DataPersistenceException {
		return loadOrdersData(dateChoice);
	}

	@Override
	public Order addOrder(Order order) throws DataPersistenceException, IOException {
		readLastOrderNumber();
		lastOrderNumber++;
		order.setOrderNumber(lastOrderNumber);
		writeLastOrderNumber(lastOrderNumber);
		List<Order> ordersByDateList = loadOrdersData(order.getDate());
		ordersByDateList.add(order);
		writeOrdersData(ordersByDateList, order.getDate());
		return order;
	}

	private void writeLastOrderNumber(int orderNumber) throws IOException, DataPersistenceException {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(dataFolder + "OrderNumberSaver.txt"));
		} catch (IOException e) {
			throw new DataPersistenceException("Could not save order saver data.", e);
		}
		out.println(orderNumber);
		out.flush();
		out.close();
	}

	private void readLastOrderNumber() throws DataPersistenceException {
		Scanner scanner;

		try {
			scanner = new Scanner(new BufferedReader(new FileReader(dataFolder + "OrderNumberSaver.txt")));
		} catch (FileNotFoundException e) {
			throw new DataPersistenceException("Couldnt load OrdersCount data in to memory ");
		}

		int currentOrderNumber = Integer.parseInt(scanner.nextLine());

		this.lastOrderNumber = currentOrderNumber;
		scanner.close();
	}

	private List<Order> loadOrdersData(LocalDate dateChoice) throws DataPersistenceException {

		Scanner scanner;
		String fileDate = dateChoice.format(DateTimeFormatter.ofPattern("MMddYYYY"));

		File f = new File(String.format("orders/Orders_%s", fileDate));

		List<Order> orderByDateList = new ArrayList<Order>();

		if (f.isFile()) {
			try {
				scanner = new Scanner(new BufferedReader(new FileReader(f)));
			} catch (FileNotFoundException e) {
				throw new DataPersistenceException("Couldnt load orders data in to memory ");
			}
			String currentLine;
			String[] tokens;
			scanner.nextLine();
			while (scanner.hasNextLine()) {
				currentLine = scanner.nextLine();
				tokens = currentLine.split(DELIMITER);
				Order order = new Order();
				order.setDate(LocalDate.parse(fileDate, DateTimeFormatter.ofPattern("MMddyyyy")));
				order.setOrderNumber(Integer.parseInt(tokens[0]));
				order.setCustomerName(tokens[1]);
				order.setState(tokens[2]);
				order.setTaxRate(new BigDecimal(tokens[3]));
				order.setProductType(tokens[4]);
				order.setArea(new BigDecimal(tokens[5]));
				order.setCstPerSqrFt(new BigDecimal(tokens[6]));
				order.setLaborcstPerSqrFt(new BigDecimal(tokens[7]));
				order.setMaterialCost(new BigDecimal(tokens[8]));
				order.setLaborCost(new BigDecimal(tokens[9]));
				order.setTax(new BigDecimal(tokens[10]));
				order.setTotal(new BigDecimal(tokens[11]));
				orderByDateList.add(order);
			}
			scanner.close();
		}
		return orderByDateList;
	}

	private void writeOrdersData(List<Order> orderList, LocalDate date) throws DataPersistenceException {
	if (FlooringModeEnum.getMode().equals(FlooringModeEnum.PRODUCTION)) {

			PrintWriter out;
			String fileDate = date.format(DateTimeFormatter.ofPattern("MMddyyyy"));
			File f = new File(String.format("orders/Orders_%s", fileDate));
			try {
				out = new PrintWriter(new FileWriter(f));
			} catch (IOException e) {
				throw new DataPersistenceException("Could not save order data.", e);
			}

			// Write Header
			out.println(HEADER);
			for (Order currentOrder : orderList) {
				// Write objects to file.
				out.println(currentOrder.getOrderNumber() + DELIMITER + currentOrder.getCustomerName() + DELIMITER
						+ currentOrder.getState() + DELIMITER + currentOrder.getTaxRate() + DELIMITER
						+ currentOrder.getProductType() + DELIMITER + currentOrder.getArea() + DELIMITER
						+ currentOrder.getCstPerSqrFt() + DELIMITER + currentOrder.getLaborcstPerSqrFt() + DELIMITER
						+ currentOrder.getMaterialCost() + DELIMITER + currentOrder.getLaborCost() + DELIMITER
						+ currentOrder.getTax() + DELIMITER + currentOrder.getTotal());
				// Force Pritwriter to write line to the file
				out.flush();
			}
			// Clean up
			out.close();
		}
	}

	@Override
	public Order editOrder(Order editedOrder) throws DataPersistenceException {

		int orderNumber = editedOrder.getOrderNumber();
		List<Order> ordersByDateList = loadOrdersData(editedOrder.getDate());

		Order orderChoosen = ordersByDateList.stream().filter(o -> o.getOrderNumber() == orderNumber).findFirst()
				.orElse(null);
		if (orderChoosen != null) {
			int index = ordersByDateList.indexOf(orderChoosen);
			ordersByDateList.set(index, editedOrder);

			writeOrdersData(ordersByDateList, editedOrder.getDate());
			return editedOrder;
		} else {
			return null;
		}
	}

	@Override
	public Order removeOrder(Order removeOrder) throws DataPersistenceException {
		int removableOrderNumber = removeOrder.getOrderNumber();
		List<Order> ordersByDateList = loadOrdersData(removeOrder.getDate());
		Order orderRm = ordersByDateList.stream().filter(o -> o.getOrderNumber() == removableOrderNumber).findFirst()
				.orElse(null);
		if (orderRm != null) {
			ordersByDateList.remove(orderRm);
			writeOrdersData(ordersByDateList, removeOrder.getDate());
			return orderRm;
		} else {
			return null;
		}
	}

}
