package com.sg.service;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sg.dao.VendingMachineDao;
import com.sg.dao.VendingMachineDaoFileImpl;
import com.sg.model.Change;
import com.sg.model.Item;

public class ServiceTest {

	private VendingMachineDao dao = new VendingMachineDaoFileImpl();
	private Service service;

	public ServiceTest() {
		service = new ServiceImpl(dao);
	}

	@Before
	public void setUp() throws Exception {
		List<Item> items = service.getAllItems();
		for (Item item : items) {
			dao.removeItem(item.getItemId());
		}
	}

	@After
	public void tearDown() {

	}

	/**
	 * Test of getall function
	 *
	 */
	@Test
	public void testGetAllItems() throws Exception {
		System.out.println("Size in Object before{}" + dao.getAllItems().size());
		Item item1 = new Item("1");
		item1.setItemName("Taco");
		item1.setItemPrice("0.50");
		item1.setItemQuantity(4);
		dao.addItem(item1.getItemId(), item1);

		Item item2 = new Item("2");
		item2.setItemName("Snickers");
		item2.setItemPrice("1.0");
		item2.setItemQuantity(2);
		dao.addItem(item2.getItemId(), item2);
		System.out.println("Size in Object after{}" + dao.getAllItems().size());
		assertEquals(2, service.getAllItems().size());
	}

	@Test
	public void testGetAllFilteredItems() throws Exception {
		System.out.println("Filtered Size in Object before{}" + dao.getAllItemsFiletered().size());
		Item item1 = new Item("1");
		item1.setItemName("Taco");
		item1.setItemPrice("1.0");
		item1.setItemQuantity(0);
		// Add data to dao and test service layer
		dao.addItem(item1.getItemId(), item1);

		Item item2 = new Item("2");
		item2.setItemName("Snickers");
		item2.setItemPrice("1.0");
		item2.setItemQuantity(2);
		// Add data to dao and test service layer
		dao.addItem(item2.getItemId(), item2);
		System.out.println("Filtered Size in Object after{}" + dao.getAllItemsFiletered().size());
		assertEquals(1, service.getAllItemsFiltered().size());
	}

	@Test
	public void testGetItem() throws Exception {
		Item item1 = new Item("1");
		item1.setItemName("Taco");
		item1.setItemPrice("1.00s");
		item1.setItemQuantity(3);
		// Add data to dao and test service layer
		dao.addItem(item1.getItemId(), item1);
		assertEquals(item1, service.getItem("1"));
	}

	@Test
	public void giveChangeTest() throws Exception {
		Item item1 = new Item("1");
		item1.setItemName("Taco");
		item1.setItemPrice("1.00");
		item1.setItemQuantity(3);
		// Add data to dao and test service layer
		dao.addItem(item1.getItemId(), item1);
		// user enter 3.19 dollars
		service.setCurrentMoney(new BigDecimal("3.19"));
		Change userChange = service.purchaseItem("1");
		// create a new object to store return change.
		Change correctChange = new Change(219);

		assertEquals(correctChange, userChange);
	}

	@Test
	public void testCancelGiveChange() throws Exception {
		// user enter 3.19 dollars
		service.setCurrentMoney(new BigDecimal("3.19"));
		//user decides not to buy something and expects money back
		Change change = service.cancelGiveChange();
		
		//make a new change object , store return 
		
		Change returnedChange = new Change(319);
		assertEquals(returnedChange, change);
	}
}
