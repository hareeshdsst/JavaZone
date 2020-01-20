package com.sg.flooring.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.Test;

import com.sg.flooring.dao.OrderDao;
import com.sg.flooring.dao.OrdersDaoStubImpl;
import com.sg.flooring.dao.ProductDao;
import com.sg.flooring.dao.ProductDaoImpl;
import com.sg.flooring.dao.StateDao;
import com.sg.flooring.dao.StateDaoImpl;
import com.sg.flooring.model.Order;

public class ServiceImplTest {

	private Service service;

	public ServiceImplTest() {
		OrderDao ordersDao = new OrdersDaoStubImpl();
		ProductDao productDao = new ProductDaoImpl();
		StateDao stateDao = new StateDaoImpl();

		service = new ServiceImpl(ordersDao, productDao, stateDao);
	}

	@Test
	public void testGetOrders() throws Exception {
		assertEquals(1, service.getOrders(LocalDate.of(2001, 04, 30)).size());
	}

	@Test
	public void testGetOrder() throws Exception {
		Order order = service.getOrder(LocalDate.of(2001, 04, 30), 1);
		assertNotNull(order);

		try {
			order = service.getOrder(LocalDate.of(2001, 04, 30), 0);
			fail("Error");
		} catch (InvalidOrderNumberException e) {

		}
	}

	@Test
	public void testCalculateOrder() throws Exception {

		Order order1 = new Order();
		order1.setCustomerName("Hareesh");
		order1.setState("MI");
		order1.setProductType("Tile");
		order1.setArea(new BigDecimal("100"));

		Order order2 = new Order();
		order2.setCustomerName("Hareesh");
		order2.setState("MI");
		order2.setProductType("Tile");
		order2.setArea(new BigDecimal("100"));

		assertEquals(service.calculateOrder(order1), service.calculateOrder(order2));
	}

}
