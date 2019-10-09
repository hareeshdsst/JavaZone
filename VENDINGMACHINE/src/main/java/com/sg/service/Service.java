package com.sg.service;

import java.math.BigDecimal;
import java.util.List;

import com.sg.dao.PersistenceException;
import com.sg.model.VendableItem;

public interface Service {


    /**
     * @param name the name of the item
     * @return a {@link VendableItem} with the given name or null no item with
     * the name exists*
     */
    public VendableItem getItem(String name) throws PersistenceException, NoItemInventoryException;

    /**
     *
     * @param name the name of the item
     * @param newCount the updated count for the item
     */
    public void setCount(String name, int newCount) throws PersistenceException;

    /**
     * @return all the items in the vending machine
     */
    public List<VendableItem> getAllItems() throws PersistenceException;

    /**
     * @return all the items in the vending machine that are in stock
     */
    public List<VendableItem> getAllItemsInStock() throws PersistenceException;

    /**
     * @return all the items in the vending machine that are in stock
     */
    public List<VendableItem> getAllItemsOutOfStock() throws PersistenceException;

    /**
     * Vends a item and removes one of the specific item from the machine
     * 
     * @param amountInMachine the amount currently in the vending machine
     * @param item the item to vend
     * @return the amount in the machine after vending the item
     * @throws InsufficentFundsException if item price > amountInMachine
     * @throws PersistenceException if there's a error updating the items count
     */
    public BigDecimal vendItem(BigDecimal amountInMachine, VendableItem item) throws InsufficentFundsException, PersistenceException;

    /**
     * adds a new item to the vending machine
     *
     * @param item the item to add
     * @return null if its the first time a item was added, otherwise returns
     * the item
     */
    public VendableItem addItem(VendableItem item) throws PersistenceException;

    /**
     * removes a item from the vending machine
     *
     * @param name the name of the item to remove
     * @return the VendableItem removed or null if nothing was removed
     */
    public VendableItem removeItem(String itemName) throws PersistenceException;

}
