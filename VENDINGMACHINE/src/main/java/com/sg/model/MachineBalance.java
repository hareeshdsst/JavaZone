package com.sg.model;

import java.math.BigDecimal;

public class MachineBalance {

	// initial amount is Zero
	private BigDecimal currentMoney = new BigDecimal("0");

	public BigDecimal getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(String currentMoney) {
		this.currentMoney = new BigDecimal(currentMoney);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentMoney == null) ? 0 : currentMoney.hashCode());
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
		MachineBalance other = (MachineBalance) obj;
		if (currentMoney == null) {
			if (other.currentMoney != null)
				return false;
		} else if (!currentMoney.equals(other.currentMoney))
			return false;
		return true;
	}
	
}
