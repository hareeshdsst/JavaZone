package com.sg.VENDINGMACHINE;

import org.junit.Before;
import org.junit.Test;

import com.sg.dao.VendingMachineDao;
import com.sg.dao.VendingMachineDaoFileImpl;

/**
 * @author hareeshdevarasetty
 *
 */
public class VendingMachineDaoTest {

	private VendingMachineDao dao = new VendingMachineDaoFileImpl();
	
	public VendingMachineDaoTest() {
	}
	
	@Before
	public void setUp() throws Exception{
		
	}
}
