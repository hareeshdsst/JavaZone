package com.sg.service;

import java.math.BigDecimal;
import java.util.List;

import com.sg.dao.PersistenceException;
import com.sg.model.Change;
import com.sg.model.Item;

/**
 * @author hareeshdevarasetty
 *
 */
public interface Service {

	Change buyItem(String itemId, BigDecimal money)
			throws PersistenceException, NoItemInventoryException, InsufficentFundsException;

	List<Item> getAllItems() throws PersistenceException;

	Item removeItem(String itemId) throws PersistenceException, NoItemInventoryException;

	int addItem(Item item) throws PersistenceException, NoItemInventoryException;

	Change giveChange(BigDecimal userMoney, BigDecimal price) throws PersistenceException;

	Item getItem(String itemId) throws PersistenceException;

	String addToMoney(BigDecimal userMoney);

	public BigDecimal getCurrentMoney();

}
