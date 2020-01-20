package com.sg.flooring.dao;

import com.sg.flooring.model.Product;

public interface ProductDao {

	public Product getProduct(String product) throws DataPersistenceException;
}
