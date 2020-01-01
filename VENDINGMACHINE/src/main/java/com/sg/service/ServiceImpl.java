package com.sg.service;

import java.math.BigDecimal;
import java.util.List;

import com.sg.dao.PersistenceException;
import com.sg.dao.VendingMachineDao;
import com.sg.model.Change;
import com.sg.model.Item;
import com.sg.model.MachineBalance;

/**
 * @author hareeshdevarasetty
 *
 */
public class ServiceImpl implements Service {
	private VendingMachineDao dao;

	private MachineBalance machineBal = new MachineBalance();

	public ServiceImpl(VendingMachineDao dao) {
		this.dao = dao;
	}

	// Pass through method
	@Override
	public Change buyItem(String itemName, BigDecimal userMoney)
			throws PersistenceException, NoItemInventoryException, InsufficentFundsException {
		Item itemToPurchase = dao.getItem(itemName);
		if (itemToPurchase == null) {
			throw new NoItemInventoryException("No Item found exception");
		} else if ((itemToPurchase.getItemQuantity() == 0)) {
			throw new NoItemInventoryException("Out of stock");
		} else {

			BigDecimal price = itemToPurchase.getItemPrice();
			if (userMoney.compareTo(price) >= 0) {
				dao.buyItem(itemName);
				resetMoney();

				return giveChange(userMoney, price);
			} else {
				throw new InsufficentFundsException("Quantity = 0, cannot purchase");
			}
		}
	}

	private void resetMoney() {
		String reset = "0";
		machineBal.setCurrentMoney(reset);

	}

	@Override
	public List<Item> getAllItems() throws PersistenceException {
		return dao.getAllItems();
	}

	// Pass through method
	@Override
	public Item getItem(String itemId) throws PersistenceException {
		return dao.getItem(itemId);
	}

	@Override
	public Change giveChange(BigDecimal userMoney, BigDecimal price) throws PersistenceException {
		BigDecimal leftChange = userMoney.subtract(price);
		BigDecimal hundred = new BigDecimal("100");
		BigDecimal calChange = leftChange.multiply(hundred);
		BigDecimal formatChange = calChange.setScale(0);

		String strChange = formatChange.toString();
		Integer change = Integer.parseInt(strChange);

		Integer quaters = 0;
		Integer dimes = 0;
		Integer nickels = 0;
		Integer pennies = 0;
		Integer remainder = 0;

		if ((change / 25) >= 1) {
			quaters = change / 25;
			remainder = change % 25;

			if ((remainder / 10) >= 1) {
				dimes = remainder / 10;
				remainder = remainder % 10;
			}
			if ((remainder / 5) >= 1) {
				nickels = remainder / 5;
				remainder = remainder % 5;
			}
		} else if ((change / 10) >= 1) {
			dimes = change / 10;
			remainder = change % 10;

			if ((remainder / 5) >= 1) {
				nickels = remainder / 5;
				remainder = remainder % 5;
			}
		} else if ((change / 5) >= 1) {
			nickels = change / 5;
			remainder = change % 5;
		} else {
			remainder = change;
		}
		pennies = remainder;

		Change changeToBereturened = new Change();

		changeToBereturened.setNumQuaters(quaters);
		changeToBereturened.setNumDimes(dimes);
		changeToBereturened.setNumNickles(nickels);
		changeToBereturened.setNumPennies(pennies);

		return changeToBereturened;
	}

	@Override
	public Item removeItem(String itemId) throws PersistenceException, NoItemInventoryException {
		Item removedItem = dao.getItem(itemId);
		if (removedItem != null) {
			dao.removeItem(itemId);
			return removedItem;
		} else {
			throw new NoItemInventoryException("No item exists");
		}

	}

	@Override
	public int addItem(Item item) throws PersistenceException, NoItemInventoryException {
		// if item to add not in inventory, add it as new key-value pair, if item is
		// there, update the numberof.
		validateItemAttr(item);
		Item foundItem = dao.getItem(item.getItemName());
		if (foundItem == null) {
			dao.addNewItem(item);
			return item.getItemQuantity();
		} else {
			dao.addToItem(item);
			return dao.getItem(item.getItemName()).getItemQuantity();
		}

	}

	private void validateItemAttr(Item itemId) throws NoItemInventoryException {
		Integer numInStock = itemId.getItemQuantity();
		BigDecimal price = new BigDecimal("0");
		price = itemId.getItemPrice();
		String strPrice = price.toString();
		if (itemId.getItemName() == null || itemId.getItemName().trim().length() == 0 || numInStock == 0
				|| numInStock == null || strPrice == null || strPrice == "0" || strPrice.trim().length() == 0) {
			throw new NoItemInventoryException("All Attr are required");
		}

	}

	@Override
	public BigDecimal getCurrentMoney() {
		return machineBal.getCurrentMoney();
	}

	@Override
	public String addToMoney(BigDecimal userMoney) {
		BigDecimal currMoney = machineBal.getCurrentMoney();
		BigDecimal newMoney = userMoney;
		BigDecimal total = currMoney.add(newMoney);
		String strMny = total.toString();
		machineBal.setCurrentMoney(strMny);
		return machineBal.getCurrentMoney().toString();
	}

}
