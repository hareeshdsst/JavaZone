package com.sg.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sg.model.Item;
import com.sg.service.NoItemInventoryException;

/**
 * @author hareeshdevarasetty
 *
 */
public class VendingMachineDaoFileImpl implements VendingMachineDao {

	private String inventoryFile = "inventory.txt";
	private static final String DELIMETER = "::";

	private Map<String, Item> vendableMap = new HashMap<>();

	public VendingMachineDaoFileImpl(String inventoryFile) {
		this.inventoryFile = inventoryFile;
	}

	public VendingMachineDaoFileImpl() {

	}

	/**
	 *
	 */
	@Override
	public List<Item> getAllItems() throws PersistenceException {
		loadInventory();
		return new ArrayList<>(vendableMap.values());
	}

	/**
	 *
	 */
	@Override
	public Item getItem(String itemID) throws PersistenceException {
		loadInventory();
		return vendableMap.get(itemID);
	}

	/**
	 * @throws PersistenceException
	 */
	@SuppressWarnings({ "unused", "resource" })
	private void loadInventory() throws PersistenceException {
		Scanner scanner;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(inventoryFile)));
		} catch (FileNotFoundException e) {
			throw new PersistenceException("File not found. Couldnot load data in to memory", e);
		}
		String[] currentLinetokens;
		String currentLine;
		while (scanner.hasNextLine()) {
			currentLine = scanner.nextLine();
			currentLinetokens = currentLine.split(DELIMETER);
			Item currentItem = new Item(currentLinetokens[0]);
			currentItem.setItemPrice(currentLinetokens[2]);
			Integer itemQuantity = Integer.parseInt(currentLinetokens[1]);
			currentItem.setItemQuantity(itemQuantity);
			vendableMap.put(currentItem.getItemName(), currentItem);
		}
		scanner.close();
	}

	/**
	 * @throws PersistenceException
	 */
	@SuppressWarnings({ "resource", "unused" })
	private void writeInventory() throws PersistenceException {
		PrintWriter out;
		try {
			out = new PrintWriter(new FileWriter(inventoryFile));
		} catch (IOException e) {
			throw new PersistenceException("Could not save inventory data.", e);
		}
		List<Item> items = this.getAllItems();

		for (Item item : items) {
			out.println(item.getItemName() + DELIMETER + item.getItemQuantity() + DELIMETER + item.getItemPrice());
			out.flush();
		}
		out.close();
	}

	@Override
	public Item removeItem(String itemID) throws NoItemInventoryException {
		Item removedItem = vendableMap.remove(itemID);
		try {
			writeInventory();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return removedItem;
	}

	@Override
	public Item addNewItem(Item item) throws NoItemInventoryException {
		Item addedItem = vendableMap.put(item.getItemName(), item);
		try {
			writeInventory();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return addedItem;
	}

	@Override
	public Item addToItem(Item item) throws NoItemInventoryException, PersistenceException {
		Item itemInMap = vendableMap.get(item.getItemName());
		int numberOfQuantity = itemInMap.getItemQuantity() + item.getItemQuantity();
		updateItemInStock(item.getItemName(), numberOfQuantity);
		writeInventory();
		return itemInMap;
	}

	private int updateItemInStock(String itemName, int numberOfQuantity) {
		Item itemInMap = vendableMap.get(itemName);
		itemInMap.setItemQuantity(numberOfQuantity);
		vendableMap.replace(itemName, itemInMap);
		return vendableMap.get(itemName).getItemQuantity();

	}

	@Override
	public Item buyItem(String itemName) throws PersistenceException {
		Item itemInMap = vendableMap.get(itemName);

		int num = (itemInMap.getItemQuantity() - 1);
		updateItemInStock(itemName, num);

		writeInventory();
		return itemInMap;
	}
}