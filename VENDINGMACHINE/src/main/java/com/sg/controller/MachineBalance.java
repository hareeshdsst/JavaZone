package com.sg.controller;

import java.math.BigDecimal;

public class MachineBalance {

	private BigDecimal currentBalance = new BigDecimal("0.00");

	public void addBalance(BigDecimal amount) {
		currentBalance = currentBalance.add(amount);
	}

	public void removeBalance(BigDecimal amount) {
		currentBalance = currentBalance.subtract(amount);
	}

	public BigDecimal getBalance() {
		return this.currentBalance;
	}
}
