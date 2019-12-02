package com.sg.dao;

import java.util.List;

import com.sg.model.Item;
import com.sg.service.NoItemInventoryException;

/**
 * @author hareeshdevarasetty
 *
 */
public interface VendingMachineDao {

	List<Item> getAllItems() throws PersistenceException;   
	
	List<Item> getAllItemsFiletered() throws PersistenceException;
	
	Item getItem(String itemID) throws PersistenceException;
	
	Item makeSaleReduceInventory(String itemID) throws NoItemInventoryException;
	

	
}
