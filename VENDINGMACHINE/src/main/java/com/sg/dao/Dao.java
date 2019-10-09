package com.sg.dao;

import java.util.List;

import com.sg.model.VendableItem;

public interface Dao {

	
	public VendableItem getItem(String getItem) throws PersistenceException;
	
	public VendableItem addItem(VendableItem addItem) throws PersistenceException;
	
	public List<VendableItem> getAllItems() throws PersistenceException;
	
	public VendableItem removeItem(String getItem) throws PersistenceException;
	
	public void setCount(String item, int newCount) throws PersistenceException;;
}
