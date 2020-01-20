package com.sg.flooring.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import com.sg.flooring.dao.DataPersistenceException;
import com.sg.flooring.dao.OrderDao;
import com.sg.flooring.dao.ProductDao;
import com.sg.flooring.dao.StateDao;
import com.sg.flooring.model.Order;
import com.sg.flooring.model.Product;
import com.sg.flooring.model.State;

public class ServiceImpl implements Service {

	private OrderDao orderDao;
	private ProductDao productDao;
	private StateDao stateDao;


    
	public ServiceImpl(OrderDao orderDao, ProductDao productDao, StateDao stateDao) {
		this.orderDao = orderDao;
		this.productDao = productDao;
		this.stateDao = stateDao;
	}

	@Override
	public List<Order> getOrders(LocalDate dateChoice) throws DataPersistenceException {
		return orderDao.getOrders(dateChoice);
	}

	public void calculateTotal(Order order) {
		// calculate other order fields.
		order.setMaterialCost(order.getCstPerSqrFt().multiply(order.getArea()).setScale(2, RoundingMode.HALF_UP));
		order.setLaborCost(order.getLaborcstPerSqrFt().multiply(order.getArea()).setScale(2, RoundingMode.HALF_UP));
		order.setTax(order.getTaxRate().divide(new BigDecimal("100.00"))
				.multiply(order.getMaterialCost().add(order.getLaborCost())).setScale(2, RoundingMode.HALF_UP));
		order.setTotal(order.getMaterialCost().add(order.getLaborCost()).add(order.getTax()));
	}

	@Override
	public Order getOrder(LocalDate dateChoice, int orderNumber)
			throws DataPersistenceException, InvalidOrderNumberException {
		List<Order> ordersList = getOrders(dateChoice);
		Order order = ordersList.stream().filter(o -> o.getOrderNumber() == orderNumber).findFirst().orElse(null);
		if (order != null) {
			return order;
		} else {
			throw new InvalidOrderNumberException("ERROR: No orders with that number " + "exist on that date.");
		}
	}

	@Override
	public Order addOrder(Order order) throws DataPersistenceException, IOException, InvalidOrderNumberException {
		orderDao.addOrder(order);
		if (order != null) {
			return order;
		} else {
			throw new InvalidOrderNumberException("ERROR: No orders with that number " + "exist on that date.");
		}
	}

	@Override
	public Order compareOrders(Order savedOrder, Order editedOrder) {

		if (editedOrder.getCustomerName() == null || editedOrder.getCustomerName().trim().equals("")) {
			// Do nothing
		} else {
			savedOrder.setCustomerName(editedOrder.getCustomerName());
		}

		if (editedOrder.getState() == null || editedOrder.getState().trim().equals("")) {
			// Do nothing
		} else {
			savedOrder.setState(editedOrder.getState());
		}

		if (editedOrder.getProductType() == null || editedOrder.getProductType().trim().equals("")) {
			// Do nothing
		} else {
			savedOrder.setProductType(editedOrder.getProductType());
		}

		if (editedOrder.getArea() == null || editedOrder.getArea().compareTo(BigDecimal.ZERO) == 0) {
			// Do nothing
		} else {
			savedOrder.setArea(editedOrder.getArea());
		}

		calculateTotal(savedOrder);
		return savedOrder;
	}

	@Override
	public Order editOrder(Order updatedOrder) throws DataPersistenceException, InvalidOrderNumberException {
		orderDao.editOrder(updatedOrder);
		if (updatedOrder != null) {
			return updatedOrder;
		} else {
			throw new InvalidOrderNumberException("ERROR: No orders with that number " + "exist on that date.");
		}
	}

	@Override
	public Order removeOrder(Order removedOrder) throws DataPersistenceException, InvalidOrderNumberException {
		orderDao.removeOrder(removedOrder);
		if (removedOrder != null) {
			return removedOrder;
		} else {
			throw new InvalidOrderNumberException("ERROR: No orders with that number " + "exist on that date.");
		}
	}

	private void validateOrder(Order order) throws DataPersistenceException {
		String message = "";
		if (order.getCustomerName() == null || order.getCustomerName().isEmpty()) {
			message = "Customer name is required.\n";
		}
		if (order.getState() == null || order.getState().isEmpty()) {
			message = "State name is required.\n";
		}
		if (order.getArea() == null || order.getArea().compareTo(BigDecimal.ZERO) == 0) {
			message = "Customer name is required.\n";
		}
		if (order.getProductType() == null || order.getProductType().isEmpty()) {
			message = "Product name is required.\n";
		}
		if (!message.isEmpty()) {
			throw new DataPersistenceException(message);
		}
	}

	@Override
	public Order calculateOrder(Order order) throws DataPersistenceException, StateValidationException {
		validateOrder(order);
		calculateTax(order);
		calculateProduct(order);
		calculateTotal(order);
		return order;
	}

	private void calculateProduct(Order order) throws DataPersistenceException, StateValidationException {
		Product product = productDao.getProduct(order.getProductType());
		if (product == null) {
			throw new StateValidationException("ERROR: No such product.");
		}
		order.setCstPerSqrFt(product.getCostPerSquareFoot());
		order.setLaborcstPerSqrFt(product.getLaborCostPerSquareFoot());
		order.setProductType(product.getProductType());
	}

	private void calculateTax(Order order) throws DataPersistenceException, StateValidationException {
		State state = stateDao.getState(order.getState());
		if (state == null) {
			throw new StateValidationException("ERROR: No such state.");
		}
		order.setState(state.getState());
		order.setTaxRate(state.getTaxRate());
	}


}
