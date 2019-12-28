package com.sg.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;

import com.sg.dao.PersistenceException;
import com.sg.dao.VendingMachineDao;
import com.sg.model.Change;
import com.sg.model.Item;

/**
 * @author hareeshdevarasetty
 *
 */
public class ServiceImpl implements Service {
	private VendingMachineDao dao;

	public ServiceImpl(VendingMachineDao dao) {
		this.dao = dao;
	}

	// initial amount is Zero
	private BigDecimal currentMoney = new BigDecimal("0");

	@Override
	public List<Item> getAllItems() throws PersistenceException {
		return dao.getAllItems();
	}

	// Pass through method
	@Override
	public List<Item> getAllItemsFiltered() throws PersistenceException {
		return dao.getAllItemsFiletered();
	}

	// Pass through method
	@Override
	public Item getItem(String itemId) throws PersistenceException {
		return dao.getItem(itemId);
	}

	// Pass through method
	@Override
	public Change purchaseItem(String itemId) throws PersistenceException, NoItemInventoryException, InsufficentFundsException {
		Item itemToPurchase = dao.getItem(itemId);
		BigDecimal oneHundred = new BigDecimal("100");
		if(validateItem(itemId)) {
			if(currentMoney.compareTo(itemToPurchase.getItemPrice()) >= 0) {
			//we have item in stock and have enough money
			//Remanining money to Integer
			int remaniningCash = currentMoney.subtract(itemToPurchase.getItemPrice()).multiply(oneHundred).intValueExact();
			//reduce inventory by 1
			makeSaleReduceInventory(itemId);
			//get change
			return giveChange(remaniningCash);
		}else {
			throw new InsufficentFundsException("Not enough money");
		}
		}else {
			throw new InsufficentFundsException("Quantity = 0, cannot purchase");
		}
	}

	private Boolean validateItem(String itemToPurchase) throws PersistenceException {
		Item item = dao.getItem(itemToPurchase);
		if (item.getItemQuantity() <= 0) {
			throw new PersistenceException("Quantity = 0,cannot purchase");
		} else {
			return true;
		}
	}

	// Pass through method
	@Override
	public Item makeSaleReduceInventory(String itemId) throws PersistenceException, NoItemInventoryException {
		return dao.makeSaleReduceInventory(itemId);
	}

	@Override
	public void setCurrentMoney(BigDecimal moneyEntry) {
    this.currentMoney = this.currentMoney.add(moneyEntry, MathContext.UNLIMITED);
	}

	@Override
	public BigDecimal getCurrentMoney() {
		return currentMoney;
	}

	@Override
	public Change giveChange(int remaniningCash) throws PersistenceException {
		//Update cash inserted
		this.currentMoney = new BigDecimal("0");
		return new Change(remaniningCash);
	}

	@Override
	public Change cancelGiveChange() throws PersistenceException {
		BigDecimal oneHundred = new BigDecimal("100");
		int remaniningCash = currentMoney.multiply(oneHundred).intValueExact();
		return giveChange(remaniningCash);
	}

}
