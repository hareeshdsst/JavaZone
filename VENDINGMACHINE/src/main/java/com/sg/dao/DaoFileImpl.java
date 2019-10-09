package com.sg.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.sg.model.VendableItem;

public class DaoFileImpl implements Dao {

	Map<String, VendableItem> vendableMap = new HashMap<String, VendableItem>();
	private static final String FILE_NAME = "items.txt";
	private static final String DELIMETER = "::";

	@Override
	public VendableItem getItem(String getItem) throws PersistenceException {
		try {
			loadInventoryData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		VendableItem item = vendableMap.get(getItem);
		return item;
	}

	@Override
	public VendableItem addItem(VendableItem addItem) throws PersistenceException {
		try {
			loadInventoryData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		VendableItem item = vendableMap.put(addItem.getName(), addItem);
		return item;
	}

	@Override
	public List<VendableItem> getAllItems() throws PersistenceException {
		try {
			loadInventoryData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return new ArrayList<>(vendableMap.values());
	}

	@Override
	public VendableItem removeItem(String Item) throws PersistenceException {
		try {
			loadInventoryData();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		VendableItem removedItem = vendableMap.remove(Item);
		return removedItem;
	}

	@Override
	public void setCount(String item, int newCount) throws PersistenceException {
		if (newCount < 0) {
			throw new PersistenceException("Count should be greater than zero");
		} else {
			getItem(item).setCount(newCount);
		}
	}

	public void loadInventoryData() throws PersistenceException, FileNotFoundException {
		// If file has already been read in then return
		if (vendableMap != null) {
			return;
		} else {
			vendableMap = new TreeMap<String, VendableItem>();
		}

		// Create new file if it doesn't exist
		File file = new File(FILE_NAME);
		if (file.exists() == false) {
			// Create in a default directory

			try {
				file.createNewFile();
				createDefaultVendingInventoryList();
			} catch (IOException io) {
				throw new PersistenceException("Cannot find");
			}
		}
		try (Scanner sc = new Scanner(file)) {
			while (sc.hasNext()) {
				String[] tokens = sc.nextLine().split(DELIMETER);
				String name = tokens[0];
				BigDecimal price = new BigDecimal(tokens[1]);
				int count = Integer.parseInt(tokens[2]);

				VendableItem vendableItem = new VendableItem(name, price, count);
				vendableMap.put(vendableItem.getName(), vendableItem);
			}
		} catch (IOException io) {
			throw new PersistenceException("Cannot find");
		} catch (NumberFormatException io) {
			throw new PersistenceException("Error !");
		}
	}

	private void createDefaultVendingInventoryList() throws PersistenceException, FileNotFoundException {
		VendableItem coke = new VendableItem("Coke", new BigDecimal(1.5), 4);
		VendableItem snickers = new VendableItem("Snickers", new BigDecimal(1.25), 8);
		VendableItem chips = new VendableItem("Chips", new BigDecimal(2.25), 10);
		VendableItem cookies = new VendableItem("Cookies", new BigDecimal(0.25), 10);
		vendableMap.put(coke.getName(), coke);
		vendableMap.put(snickers.getName(), snickers);
		vendableMap.put(chips.getName(), chips);
		vendableMap.put(cookies.getName(), cookies);
		writeInventoryData();
	}

	public void writeInventoryData() throws PersistenceException, FileNotFoundException {
		List<VendableItem> itemList = getAllItems();

		try (PrintWriter writer = new PrintWriter(FILE_NAME)) {

			StringBuilder builderLine = new StringBuilder();

			for (VendableItem item : itemList) {
				builderLine.append(item.getName());
				builderLine.append(DELIMETER);
				builderLine.append(item.getPrice());
				builderLine.append(DELIMETER);
				builderLine.append(item.getCount());
				builderLine.append("\n");
			}
			writer.println(builderLine.toString());
			writer.flush();

			builderLine.delete(0, builderLine.length());
		} catch (FileNotFoundException ex) {
			// should never happen as read file is always called before write
			throw new PersistenceException("Cant find items");
		}

	}

}
