package com.sg.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
			dao.removeItem(item.getItemName());
		}
	}
	
	@After
	public void tearDown() {
		
	}
	/**
	*Test of buyItem function 
	*
	*/
	@Test
	public void testBuyItem() throws Exception {
		Item item1 = new Item("Candy");
		item1.setItemPrice("8");
		item1.setItemQuantity(2);
		dao.addNewItem(item1);
		dao.buyItem(item1.getItemName());
		Item fromDao = dao.getItem(item1.getItemName());
		assertEquals(1, fromDao.getItemQuantity());
		assertEquals(item1,fromDao);

	}
	
	/**
	*Test of buyItem function 
	*
	*/
	@Test
	public void testRemoveItem() throws Exception {
		Item item1 = new Item("Candy");
		item1.setItemPrice("8");
		item1.setItemQuantity(2);
		dao.addNewItem(item1);
		
		Item item2 = new Item("Cola");
		item2.setItemPrice("4");
		item2.setItemQuantity(2);
		dao.addNewItem(item2);

		dao.removeItem(item1.getItemName());
		
		List<Item> fromDaoList = dao.getAllItems();
		
		assertEquals(1, fromDaoList.size());
		assertNull(dao.getItem("Candy"));
	}
	
	@Test
	public void testAddItem() throws Exception {
		Item item1 = new Item("Candy");
		item1.setItemPrice("8");
		item1.setItemQuantity(2);
		dao.addNewItem(item1);
		
		dao.getItem(item1.getItemName());
		Item fromDao = dao.getItem(item1.getItemName());
		assertEquals(item1, fromDao);
		assertEquals(1, dao.getAllItems().size());
	}
	
	@Test
	public void testAddToItem() throws Exception {
		Item item1 = new Item("Candy");
		item1.setItemPrice("8");
		item1.setItemQuantity(4);
		dao.addNewItem(item1);
		
		Item itemToItem = new Item("Candy");
		itemToItem.setItemPrice("2");
		itemToItem.setItemQuantity(2);
		dao.addToItem(itemToItem);
		
		assertEquals(1, dao.getAllItems().size());
		assertEquals(6, dao.getItem(itemToItem.getItemName()).getItemQuantity());
		System.out.println("Item Price: " + item1.getItemPrice());
		assertEquals("2", dao.getItem(itemToItem.getItemName()).getItemPrice());
	}
	/**
	*Test of getall function 
	*
	*/
	@Test
	public void testGetAllItems() throws Exception {
		System.out.println("Size in Object before{}"  + dao.getAllItems().size());
		Item item1 = new Item("Taco");
		item1.setItemPrice("0.50");
		item1.setItemQuantity(4);
		dao.addNewItem(item1);
		
		Item item2 = new Item("2");
		item2.setItemPrice("1.0");
		item2.setItemQuantity(2);
		dao.addNewItem(item2);
		System.out.println("Size in Object after{}"  + dao.getAllItems().size());
		assertEquals(2, dao.getAllItems().size());
	}
	
	@Test
	public void testGetItem() throws Exception {
		Item item1 = new Item("1");
		item1.setItemPrice("1.0");
		item1.setItemQuantity(3);
		dao.addNewItem(item1);
		assertEquals(item1, dao.getItem("1"));
	}	
}