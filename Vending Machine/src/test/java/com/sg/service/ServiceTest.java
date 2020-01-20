package com.sg.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.math.BigDecimal;

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
//TODO 
	public ServiceTest() {
		service = new ServiceImpl(dao);
	}

	@Before
	public void setUp() throws Exception {

	}

	@After
	public void tearDownClass() throws Exception {

	}

	@Test
	public void testInInventoryEnoughFund() throws Exception {
		String buyableItem = "Candy";
		Item fromDao = service.getItem(buyableItem);
		BigDecimal cash = new BigDecimal("8");
		Change change = service.buyItem(buyableItem, cash);

		assertEquals(buyableItem, fromDao.getItemName());

		assertEquals(0, change.getNumPennies());
		assertEquals(0, change.getNumNickles());
		assertEquals(0, change.getNumDimes());
		assertEquals(0, change.getNumQuaters());

	}

	@Test
	public void testInMoneyTrackingTest() throws Exception {

		BigDecimal cash = new BigDecimal("8");
		service.addToMoney(cash);
		assertEquals(cash, service.getCurrentMoney());

		BigDecimal extraCash = new BigDecimal("3");
		service.addToMoney(extraCash);

		BigDecimal totalCash = cash.add(extraCash);

		assertEquals(totalCash, service.getCurrentMoney());

		service.buyItem("candy", totalCash);

		BigDecimal newCash = new BigDecimal("0");

		assertEquals(newCash, service.getCurrentMoney());

	}

	@Test
	public void testChangeFunc() throws Exception {

		String buyableItem = "Candy";
		Item fromDao = service.getItem(buyableItem);
		BigDecimal cash = new BigDecimal("8.51");
		Change change = service.buyItem(buyableItem, cash);

		assertEquals(buyableItem, fromDao.getItemName());

		assertEquals(1, change.getNumPennies());
		assertEquals(0, change.getNumNickles());
		assertEquals(0, change.getNumDimes());
		assertEquals(2, change.getNumQuaters());

	}

	@Test
	public void testChangeFunc12() throws Exception {

		String buyableItem = "candy";
		Item fromDao = service.getItem(buyableItem);
		BigDecimal cash = new BigDecimal("8.12");
		Change change = service.buyItem(buyableItem, cash);

		assertEquals(buyableItem, fromDao.getItemName());

		assertEquals(2, change.getNumPennies());
		assertEquals(0, change.getNumNickles());
		assertEquals(1, change.getNumDimes());
		assertEquals(0, change.getNumQuaters());

	}

	@Test
	public void testChangeFunc06() throws Exception {

		String buyableItem = "Candy";
		Item fromDao = service.getItem(buyableItem);
		BigDecimal cash = new BigDecimal("8.06");
		Change change = service.buyItem(buyableItem, cash);

		assertEquals(buyableItem, fromDao.getItemName());

		assertEquals(1, change.getNumPennies());
		assertEquals(1, change.getNumNickles());
		assertEquals(0, change.getNumDimes());
		assertEquals(0, change.getNumQuaters());

	}

	@Test
	public void testChangeFunc925() throws Exception {

		String buyableItem = "candy";
		Item fromDao = service.getItem(buyableItem);
		BigDecimal cash = new BigDecimal("9.25");
		Change change = service.buyItem(buyableItem, cash);

		assertEquals(buyableItem, fromDao.getItemName());

		assertEquals(0, change.getNumPennies());
		assertEquals(0, change.getNumNickles());
		assertEquals(0, change.getNumDimes());
		assertEquals(5, change.getNumQuaters());

	}

	@Test
	public void testInsufficientFunds() throws Exception {

		String buyableItem = "Candy";
		BigDecimal cash = new BigDecimal("7.25");

		try {
			service.buyItem(buyableItem, cash);
			fail("User money is less than , machine money");
		} catch (InsufficentFundsException e) {
			return;
		}
	}

	@Test
	public void testBuyOrRemoveItem() throws Exception {
		String buyableItem = "snicker";
		BigDecimal cash = new BigDecimal("8.25");
		try {
			service.buyItem(buyableItem, cash);
			fail("No such ,stock");
		} catch (NoItemInventoryException e) {
			return;
		}
	}

	@Test
	public void testRemoveItem() throws Exception {
		String buyableItem = "snicker";
		try {
			service.removeItem(buyableItem);
			fail("No such ,stock");
		} catch (NoItemInventoryException e) {
			return;
		}
	}

	@Test
	public void testAddItemInInv() throws Exception {
		Item item = new Item("candy");
		item.setItemQuantity(2);
		item.setItemPrice("12.00");
		assertEquals(20, service.addItem(item));
	}

	@Test
	public void testAddItemNotInInv() throws Exception {
		Item item = new Item("Snickers");
		item.setItemQuantity(2);
		item.setItemPrice("12.00");
		assertEquals(8, service.addItem(item));
	}

	/**
	 * Test of getall function
	 *
	 */
	@Test
	public void testGetAllItems() throws Exception {
		System.out.println("Size in Object before{}" + dao.getAllItems().size());
		Item item1 = new Item("1");
		item1.setItemPrice("0.50");
		item1.setItemQuantity(4);
		dao.addNewItem(item1);

		Item item2 = new Item("2");
		item2.setItemPrice("1.0");
		item2.setItemQuantity(2);
		dao.addNewItem(item2);
		System.out.println("Size in Object after{}" + dao.getAllItems().size());
		assertEquals(2, service.getAllItems().size());
	}

	@Test
	public void testValidateAttr() throws Exception {
		Item item = new Item("chocos");
		item.setItemQuantity(2);
		try {
			item.setItemPrice("");
			fail("Number Format Exception");
		} catch (NumberFormatException e) {
			return;
		}
		try {
			service.addItem(item);
			fail("Cannot add in to Inventory exceptions");
		} catch (NoItemInventoryException e) {
			return;
		}
	}

}