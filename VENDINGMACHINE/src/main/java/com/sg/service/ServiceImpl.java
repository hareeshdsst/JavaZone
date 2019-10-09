package com.sg.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import com.sg.dao.Dao;
import com.sg.dao.PersistenceException;
import com.sg.model.VendableItem;

public class ServiceImpl implements Service {

	private Dao dao;

	public ServiceImpl(Dao dao) {
		this.dao = dao;
	}

	@Override
	public VendableItem getItem(String name) throws PersistenceException, NoItemInventoryException {
		VendableItem item = dao.getItem(name);
		if (item != null && item.getCount() == 0) {
			throw new NoItemInventoryException();
		}
		return item;
	}

	@Override
	public void setCount(String name, int newCount) throws PersistenceException {
		if (newCount < 0) {
			throw new PersistenceException("newCount must be >= 0");
		}
		dao.setCount(name, newCount);
	}

	@Override
	public List<VendableItem> getAllItems() throws PersistenceException {
		return dao.getAllItems();
	}

	@Override
	public List<VendableItem> getAllItemsInStock() throws PersistenceException {
		return dao.getAllItems().stream().filter((item) -> item.getCount() > 0)// Check the logic
				.collect(Collectors.toList());
	}

	@Override
	public List<VendableItem> getAllItemsOutOfStock() throws PersistenceException {
		return dao.getAllItems().stream().filter((item) -> item.getCount() <= 0).collect(Collectors.toList());
	}

	@Override
	public BigDecimal vendItem(BigDecimal amountInMachine, VendableItem item)
			throws InsufficentFundsException, PersistenceException {
		if (item.getPrice().compareTo(amountInMachine) > 0) {
			throw new InsufficentFundsException("Insufficent Funds");
		}
		setCount(item.getName(), item.getCount() - 1);
		return amountInMachine.subtract(item.getPrice());
	}

	@Override
	public VendableItem addItem(VendableItem item) throws PersistenceException {
		return dao.addItem(item);
	}

	@Override
	public VendableItem removeItem(String itemName) throws PersistenceException {
		return dao.removeItem(itemName);
	}

}
