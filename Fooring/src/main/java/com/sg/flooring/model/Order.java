package com.sg.flooring.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Order {
//order number, customer name, state, tax rate, product type, area, cost per square foot, 
	// labor cost per square foot, material cost, labor cost, tax, and total.
	private LocalDate date;
	private int orderNumber;
	private String customerName;
	private String state;
	private String productType;
	private BigDecimal taxRate;
	private BigDecimal area;
	private BigDecimal cstPerSqrFt;
	private BigDecimal laborcstPerSqrFt;
	private BigDecimal materialCost;
	private BigDecimal laborCost;
	private BigDecimal tax;
	private BigDecimal total;

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public BigDecimal getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(BigDecimal taxRate) {
		this.taxRate = taxRate;
	}

	public BigDecimal getArea() {
		return area;
	}

	public void setArea(BigDecimal area) {
		this.area = area;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getCstPerSqrFt() {
		return cstPerSqrFt;
	}

	public void setCstPerSqrFt(BigDecimal cstPerSqrFt) {
		this.cstPerSqrFt = cstPerSqrFt;
	}

	public BigDecimal getLaborcstPerSqrFt() {
		return laborcstPerSqrFt;
	}

	public void setLaborcstPerSqrFt(BigDecimal laborcstPerSqrFt) {
		this.laborcstPerSqrFt = laborcstPerSqrFt;
	}

	public BigDecimal getMaterialCost() {
		return materialCost;
	}

	public void setMaterialCost(BigDecimal materialCost) {
		this.materialCost = materialCost;
	}

	public BigDecimal getLaborCost() {
		return laborCost;
	}

	public void setLaborCost(BigDecimal laborCost) {
		this.laborCost = laborCost;
	}

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return " orderNumber: " + orderNumber + " |Customer Name: " + customerName + " |State: " + state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((cstPerSqrFt == null) ? 0 : cstPerSqrFt.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((laborCost == null) ? 0 : laborCost.hashCode());
		result = prime * result + ((laborcstPerSqrFt == null) ? 0 : laborcstPerSqrFt.hashCode());
		result = prime * result + ((materialCost == null) ? 0 : materialCost.hashCode());
		result = prime * result + orderNumber;
		result = prime * result + ((productType == null) ? 0 : productType.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((tax == null) ? 0 : tax.hashCode());
		result = prime * result + ((taxRate == null) ? 0 : taxRate.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
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
		Order other = (Order) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (cstPerSqrFt == null) {
			if (other.cstPerSqrFt != null)
				return false;
		} else if (!cstPerSqrFt.equals(other.cstPerSqrFt))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (laborCost == null) {
			if (other.laborCost != null)
				return false;
		} else if (!laborCost.equals(other.laborCost))
			return false;
		if (laborcstPerSqrFt == null) {
			if (other.laborcstPerSqrFt != null)
				return false;
		} else if (!laborcstPerSqrFt.equals(other.laborcstPerSqrFt))
			return false;
		if (materialCost == null) {
			if (other.materialCost != null)
				return false;
		} else if (!materialCost.equals(other.materialCost))
			return false;
		if (orderNumber != other.orderNumber)
			return false;
		if (productType == null) {
			if (other.productType != null)
				return false;
		} else if (!productType.equals(other.productType))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (tax == null) {
			if (other.tax != null)
				return false;
		} else if (!tax.equals(other.tax))
			return false;
		if (taxRate == null) {
			if (other.taxRate != null)
				return false;
		} else if (!taxRate.equals(other.taxRate))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		return true;
	}
	
	
}
