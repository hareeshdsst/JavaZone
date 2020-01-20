package com.sg.flooring.dao;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.Test;

import com.sg.flooring.model.Order;

public class OrdersDaoProdImplTest {

	private String dataFolder = "src/test/resources/";
	private OrderDao ordersDao = new OrdersDaoProdImpl(dataFolder);

	public OrdersDaoProdImplTest() {
	}

	@Test
	public void testAddOrder() throws Exception {
			LocalDate date = LocalDate.parse("07312039", DateTimeFormatter.ofPattern("MMddyyyy"));
			List<Order> initialOrders = ordersDao.getOrders(date);

			Order order = new Order();
			order.setDate(date);
			order.setCustomerName("Hareesh");
			order.setState("IN");
			order.setTaxRate(new BigDecimal("6.00"));
			order.setProductType("Laminate");
			order.setArea(new BigDecimal("100"));
			order.setCstPerSqrFt(new BigDecimal("1.75"));
			order.setLaborcstPerSqrFt(new BigDecimal("2.10"));
			order.setMaterialCost(order.getCstPerSqrFt().multiply(order.getArea()).setScale(2, RoundingMode.UP));
			order.setLaborCost(order.getLaborcstPerSqrFt().multiply(order.getArea()).setScale(2, RoundingMode.UP));
			order.setTax(order.getTaxRate().divide(new BigDecimal("100"))
					.multiply(order.getMaterialCost().add(order.getLaborCost())).setScale(2, RoundingMode.UP));
			order.setTotal(order.getMaterialCost().add(order.getLaborCost().add(order.getTax())));

			order = ordersDao.addOrder(order);

			List<Order> fromDao = ordersDao.getOrders(order.getDate());

			assertEquals(1, (fromDao.size() - initialOrders.size()));
	}
	
	@Test
	public void testEditOrder() throws Exception {
			LocalDate date = LocalDate.parse("07132040", DateTimeFormatter.ofPattern("MMddyyyy"));

			Order order = new Order();
			order.setDate(date);
			order.setCustomerName("Bhava");
			order.setState("IN");
			order.setTaxRate(new BigDecimal("6.00"));
			order.setProductType("Laminate");
			order.setArea(new BigDecimal("100"));
			order.setCstPerSqrFt(new BigDecimal("1.75"));
			order.setLaborcstPerSqrFt(new BigDecimal("2.10"));
			order.setMaterialCost(order.getCstPerSqrFt().multiply(order.getArea()).setScale(2, RoundingMode.UP));
			order.setLaborCost(order.getLaborcstPerSqrFt().multiply(order.getArea()).setScale(2, RoundingMode.UP));
			order.setTax(order.getTaxRate().divide(new BigDecimal("100"))
					.multiply(order.getMaterialCost().add(order.getLaborCost())).setScale(2, RoundingMode.UP));
			order.setTotal(order.getMaterialCost().add(order.getLaborCost().add(order.getTax())));

			order = ordersDao.addOrder(order);

			Order editedorder = order;
			
			editedorder.setCustomerName("Haran");
			
			editedorder = ordersDao.editOrder(editedorder);
			
			List<Order> initialOrders = ordersDao.getOrders(date);
			int orderNumber = editedorder.getOrderNumber();
			Order chosenorder = initialOrders.stream().filter(o -> o.getOrderNumber() == orderNumber).findFirst().orElse(null);
			assertEquals(editedorder, chosenorder);
	}
	
	@Test
	public void testRemoveOrder() throws Exception {
			LocalDate date = LocalDate.parse("08312039", DateTimeFormatter.ofPattern("MMddyyyy"));
			

			Order order1 = new Order();
			order1.setDate(date);
			order1.setCustomerName("Yotta");
			order1.setState("IN");
			order1.setTaxRate(new BigDecimal("6.00"));
			order1.setProductType("Laminate");
			order1.setArea(new BigDecimal("100"));
			order1.setCstPerSqrFt(new BigDecimal("1.75"));
			order1.setLaborcstPerSqrFt(new BigDecimal("2.10"));
			order1.setMaterialCost(order1.getCstPerSqrFt().multiply(order1.getArea()).setScale(2, RoundingMode.UP));
			order1.setLaborCost(order1.getLaborcstPerSqrFt().multiply(order1.getArea()).setScale(2, RoundingMode.UP));
			order1.setTax(order1.getTaxRate().divide(new BigDecimal("100"))
					.multiply(order1.getMaterialCost().add(order1.getLaborCost())).setScale(2, RoundingMode.UP));
			order1.setTotal(order1.getMaterialCost().add(order1.getLaborCost().add(order1.getTax())));

			order1 = ordersDao.addOrder(order1);

			Order order2 = new Order();
			order2.setDate(date);
			order2.setCustomerName("Vedhs");
			order2.setState("IN");
			order2.setTaxRate(new BigDecimal("6.00"));
			order2.setProductType("Laminate");
			order2.setArea(new BigDecimal("100"));
			order2.setCstPerSqrFt(new BigDecimal("1.75"));
			order2.setLaborcstPerSqrFt(new BigDecimal("2.10"));
			order2.setMaterialCost(order2.getCstPerSqrFt().multiply(order2.getArea()).setScale(2, RoundingMode.UP));
			order2.setLaborCost(order2.getLaborcstPerSqrFt().multiply(order2.getArea()).setScale(2, RoundingMode.UP));
			order2.setTax(order2.getTaxRate().divide(new BigDecimal("100"))
					.multiply(order2.getMaterialCost().add(order2.getLaborCost())).setScale(2, RoundingMode.UP));
			order2.setTotal(order2.getMaterialCost().add(order2.getLaborCost().add(order2.getTax())));

			order2 = ordersDao.addOrder(order2);
			
			List<Order> initialOrders = ordersDao.getOrders(date);
			initialOrders.remove(order2);
			
			List<Order> fromDao = ordersDao.getOrders(date);

			assertEquals(1, (fromDao.size() - initialOrders.size()));
	}
}
