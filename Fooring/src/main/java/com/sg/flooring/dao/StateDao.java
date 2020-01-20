package com.sg.flooring.dao;

import com.sg.flooring.model.State;

public interface StateDao {
	public State getState(String state) throws DataPersistenceException;
}
