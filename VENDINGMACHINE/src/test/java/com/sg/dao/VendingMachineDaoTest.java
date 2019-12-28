package com.sg.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sg.dao.VendingMachineDao;
import com.sg.dao.VendingMachineDaoFileImpl;
import com.sg.model.Item;

/**
 * @author hareeshdevarasetty
 *
 */
public class VendingMachineDaoTest {

    String inventoryFile = "inventory.txt";
	private VendingMachineDao dao = new VendingMachineDaoFileImpl(inventoryFile);
	

	public VendingMachineDaoTest() {
	}
	
	
	@Before
	public void setUp() throws Exception{
		List<Item> items = dao.getAllItems();
		for(Item item : items) {
			dao.removeItem(item.getItemId());
		}
	}
	
	@After
	public void tearDown() {
		
	}
	/**
	*Test of getall function 
	*
	*/
	@Test
	public void testGetAllItems() throws Exception {
		System.out.println("Size in Object before{}"  + dao.getAllItems().size());
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
		System.out.println("Size in Object after{}"  + dao.getAllItems().size());
		assertEquals(2, dao.getAllItems().size());
	}
	
	@Test
	public void testGetAllFilteredItems() throws Exception {
		System.out.println("Filtered Size in Object before{}"  + dao.getAllItemsFiletered().size());
		Item item1 = new Item("1");
		item1.setItemName("Taco");
		item1.setItemPrice("1.0");
		item1.setItemQuantity(0);
		dao.addItem(item1.getItemId(), item1);
		
		Item item2 = new Item("2");
		item2.setItemName("Snickers");
		item2.setItemPrice("1.0");
		item2.setItemQuantity(2);
		dao.addItem(item2.getItemId(), item2);
		System.out.println("Filtered Size in Object after{}"  + dao.getAllItemsFiletered().size());
		assertEquals(1, dao.getAllItemsFiletered().size());
	}
	
	@Test
	public void testGetItem() throws Exception {
		Item item1 = new Item("1");
		item1.setItemName("Taco");
		item1.setItemPrice("1.0");
		item1.setItemQuantity(3);
		dao.addItem(item1.getItemId(), item1);
		assertEquals(item1, dao.getItem("1"));
	}
	
	@Test
	public void testMakeSaleReduceInventory() throws Exception {
		Item item1 = new Item("4");
		item1.setItemName("Taco");
		item1.setItemPrice("1.0");
		item1.setItemQuantity(3);
		dao.addItem(item1.getItemId(), item1);
		Item updatedItem = dao.makeSaleReduceInventory("4");
		int itemSize = updatedItem.getItemQuantity();
		assertEquals(2, itemSize);
	}
	
	
	
}