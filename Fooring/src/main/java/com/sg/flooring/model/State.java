package com.sg.flooring.model;

import java.math.BigDecimal;

public class State {
//State,TaxRate

	private String state;
	private BigDecimal taxRate;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}
}
