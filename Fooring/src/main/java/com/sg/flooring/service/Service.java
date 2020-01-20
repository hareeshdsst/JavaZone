package com.sg.flooring.service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.sg.flooring.dao.DataPersistenceException;
import com.sg.flooring.dao.OrderDao;
import com.sg.flooring.model.Order;

public interface Service {

	List<Order> getOrders(LocalDate dateChoice) throws DataPersistenceException;

	Order calculateOrder(Order order) throws DataPersistenceException, StateValidationException;

	Order getOrder(LocalDate dateChoice, int orderNumber) throws DataPersistenceException, InvalidOrderNumberException;

	Order addOrder(Order order) throws DataPersistenceException, IOException, InvalidOrderNumberException;

	Order compareOrders(Order savedOrder, Order editedOrder);

	Order editOrder(Order updatedOrder) throws DataPersistenceException, InvalidOrderNumberException;

	Order removeOrder(Order removedOrder) throws DataPersistenceException, InvalidOrderNumberException;
}
