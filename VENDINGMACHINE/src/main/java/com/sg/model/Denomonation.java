package com.sg.model;

import java.math.BigDecimal;

/**
 * @author hareesh
 *
 */
public enum Denomonation {

	PENNY(new BigDecimal("0.01")), 
	NICKLE(new BigDecimal("0.05")),
	DIME(new BigDecimal("0.10")),
	QUATER(new BigDecimal("0.25")),
	HALF_DOLLAR(new BigDecimal("0.50")),
	DOLLAR(new BigDecimal("1.00")),
	FIVE_DOLLAR(new BigDecimal("5.00")),
	TEN_DOLLAR(new BigDecimal("10.00")),
	TWENTY_DOLLAR(new BigDecimal("20.00")),
	FIFTY_DOLLAR(new BigDecimal("50.00")),
	HUNDRED_DOLLAR(new BigDecimal("100.00"));

;
	private final BigDecimal val;

	private Denomonation(BigDecimal val) {
		this.val = val;
	}

	public BigDecimal getVal() {
		return this.val;
	}

}
