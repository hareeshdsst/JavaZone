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

	Item removeItem(String itemID) throws NoItemInventoryException;

	Item addNewItem(Item item) throws NoItemInventoryException;

	Item addToItem(Item item) throws NoItemInventoryException, PersistenceException;

	Item getItem(String itemID) throws PersistenceException;

	Item buyItem(String itemName) throws PersistenceException;

}
