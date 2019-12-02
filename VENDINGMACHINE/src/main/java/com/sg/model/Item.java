package com.sg.model;

import java.math.BigDecimal;

public class Item {
	
	private String itemId;
	private String itemName;
	private Integer itemQuantity;
	private BigDecimal itemPrice;
	public Item(String itemId) {
		this.itemId = itemId;
	}
	
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public Integer getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = new BigDecimal(itemPrice);
	}
  
}