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

	private   String inventoryFile = "inventory.txt";
	private static final String DELIMETER = "::";

	Map<String, Item> vendableMap = new HashMap<>();
	
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
	public List<Item> getAllItemsFiletered() throws PersistenceException{
		loadInventory();
		return vendableMap.values().stream().filter(i -> i.getItemQuantity() > 0).collect(Collectors.toList());
	}
	/**
	 *
	 */
	@Override
	public Item getItem(String itemID) throws PersistenceException{
		loadInventory();
		return vendableMap.get(itemID);
	}
	/**
	 *
	 */
	@Override
	public Item makeSaleReduceInventory(String itemID) throws NoItemInventoryException {
		Item removedItem = vendableMap.get(itemID);
		if(removedItem.getItemQuantity() >  0) {
			removedItem.setItemQuantity(removedItem.getItemQuantity() - 1);
		}else {
			throw new NoItemInventoryException("");
		}
		return removedItem;
	}
	/**
	 * @throws PersistenceException
	 */
	@SuppressWarnings({ "unused", "resource" })
	private void loadInventory() throws PersistenceException {
		Scanner scanner;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(inventoryFile)));
		}catch (FileNotFoundException e) {
			throw new PersistenceException("File not found. Couldnot load data in to memory", e);
		}
		String[] currentLinetokens;
		String currentLine;
		while(scanner.hasNextLine()) {
			currentLine = scanner.nextLine();
			currentLinetokens = currentLine.split(DELIMETER);
			Item currentItem = new Item(currentLinetokens[0]);
			currentItem.setItemName(currentLinetokens[1]);
			currentItem.setItemPrice(currentLinetokens[3]);
			Integer itemQuantity = Integer.parseInt(currentLinetokens[2]);
			currentItem.setItemQuantity(itemQuantity);
			vendableMap.put(currentItem.getItemId(),currentItem);
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
		}catch(IOException e) {
			throw new PersistenceException("Could not save inventory data.", e);
		}
		List<Item> items = this.getAllItems();
		
		for(Item item : items) {
			out.println(item.getItemId() + DELIMETER 
					 +  item.getItemName() + DELIMETER
					 +  item.getItemQuantity() + DELIMETER
				     +  item.getItemPrice());
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
	public Item addItem(String itemID, Item item) throws NoItemInventoryException {
		Item addedItem = vendableMap.put(itemID, item);
		try {
			writeInventory();
		} catch (PersistenceException e) {
			e.printStackTrace();
		}
		return addedItem;
	}
}