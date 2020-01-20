package com.sg.model;

import java.math.BigDecimal;

public class Item {
	

	private String itemName;
	private int itemQuantity;
	private BigDecimal itemPrice;
	public Item(String itemName) {
		this.itemName = itemName;
	}
	

	public String getItemName() {
		return itemName;
	}

	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = new BigDecimal(itemPrice);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemPrice == null) ? 0 : itemPrice.hashCode());
		result = prime * result + itemQuantity;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemPrice == null) {
			if (other.itemPrice != null)
				return false;
		} else if (!itemPrice.equals(other.itemPrice))
			return false;
		if (itemQuantity != other.itemQuantity)
			return false;
		return true;
	}


	
	
  
}