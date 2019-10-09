package com.sg.model;

import java.math.BigDecimal;

/**
 * @author hareesh
 *
 */
public class Change {

	private int quaters;
	private int dimes;
	private int nickels;
	private int pennis;

	public Change(BigDecimal total, BigDecimal itemPrice) {
		BigDecimal change = total.subtract(itemPrice);

		if (change.doubleValue() < 0) {
			throw new IllegalArgumentException("Item price > total");
		}

		BigDecimal[] div = change.divideAndRemainder(Denomonation.QUATER.getVal());
		quaters = div[0].intValue();
		change = div[1];

		div = change.divideAndRemainder(Denomonation.DIME.getVal());
		dimes = div[0].intValue();
		change = div[1];

		div = change.divideAndRemainder(Denomonation.NICKLE.getVal());
		nickels = div[0].intValue();
		change = div[1];

		div = change.divideAndRemainder(Denomonation.PENNY.getVal());
		quaters = div[0].intValue();
	}

	public Change(BigDecimal change) {
		this(change, new BigDecimal("0.00"));
	}

	public int getQuaters() {
		return quaters;
	}

	public int getDimes() {
		return dimes;
	}

	public int getNickels() {
		return nickels;
	}

	public int getPennis() {
		return pennis;
	}

}
