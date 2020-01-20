package com.sg.flooring.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sg.flooring.model.State;

public class StateDaoImpl implements StateDao {
	public final static String TAX_FILE = "Tax.txt";
	public final static String DELIMITER = ",";

	@Override
	public State getState(String taxState) throws DataPersistenceException {
		List<State> taxList = loadStateTaxData();
		if (taxList == null) {
			return null;
		} else {
			State taxSummary = taxList.stream().filter(o -> o.getState().equalsIgnoreCase(taxState)).findFirst()
					.orElse(null);
			return taxSummary;
		}
	}

	private List<State> loadStateTaxData() throws DataPersistenceException {

		List<State> taxList = new ArrayList<>();
		Scanner scanner;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(TAX_FILE)));
		} catch (FileNotFoundException e) {
			throw new DataPersistenceException("Couldnt load tax data in to memory");
		}
		String line;
		String[] tokens;
		scanner.nextLine();// Skipping header
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			tokens = line.split(DELIMITER);
			if (tokens.length == 2) {
				State tax = new State();
				tax.setState(tokens[0]);
				tax.setTaxRate(new BigDecimal(tokens[1]));
				taxList.add(tax);
			} else {

			}
		}
		scanner.close();
		if (taxList.isEmpty())
			return null;
		else {
			return taxList;
		}

	}

}
