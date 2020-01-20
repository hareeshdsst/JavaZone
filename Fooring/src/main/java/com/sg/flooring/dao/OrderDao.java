package com.sg.flooring.dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.sg.flooring.model.Order;



public interface OrderDao {
	   List<Order> getOrders(LocalDate dateChoice) throws DataPersistenceException;

	    Order addOrder(Order o) throws DataPersistenceException, IOException;

	    Order editOrder(Order editedOrder) throws DataPersistenceException;

	    Order removeOrder(Order o) throws DataPersistenceException;
}
