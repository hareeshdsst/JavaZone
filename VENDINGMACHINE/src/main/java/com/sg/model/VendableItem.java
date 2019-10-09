package com.sg.model;

import java.math.BigDecimal;

public class VendableItem {

	private String name;

	private BigDecimal price;

	private int count;
  
	/** Creates vendable item with a name, price, and a default count of 1 **/
	public VendableItem(String name, BigDecimal price) {
		this.name = name;
		this.price = price;
		this.count = 1;
	}
	/** Creates vendable item with a name, price, and count **/
	public VendableItem(String name, BigDecimal price,int count) {
		this.name = name;
		this.price = price;
		this.count = count;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
