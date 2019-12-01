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

	List<Item> getAllItems() throws PersistenceException;

	List<Item> getAllItemsFiltered() throws PersistenceException;

	Item getItem(String itemId) throws PersistenceException;

	Change purchaseItem(String itemId) throws PersistenceException, NoItemInventoryException, InsufficentFundsException;

	Item makeSaleReduceInventory(String itemId) throws PersistenceException, PersistenceException, NoItemInventoryException;

	public void setCurrentMoney(BigDecimal moneyEntry);

	public BigDecimal getCurrentMoney();

	public Change giveChange(int remaniningCash) throws PersistenceException;

	public Change cancelGiveChange() throws PersistenceException;

}
