package com.sg.flooring.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sg.flooring.model.Product;

public class ProductDaoImpl implements ProductDao {

	public final static String PRODUCT_FILE = "Products.txt";
	public final static String DELIMITER = ",";

	@Override
	public Product getProduct(String productType) throws DataPersistenceException {
		List<Product> products = loadAllProducts();
		if (products == null) {
			return null;
		} else {
			Product matchedProcduct = products.stream().filter(o -> o.getProductType().equalsIgnoreCase(productType))
					.findFirst().orElse(null);
			return matchedProcduct;
		}
	}

	private List<Product> loadAllProducts() throws DataPersistenceException {
		List<Product> productList = new ArrayList<>();

		Scanner scanner;

		try {
			scanner = new Scanner(new BufferedReader(new FileReader(PRODUCT_FILE)));
		} catch (FileNotFoundException e) {
			throw new DataPersistenceException("Couldnot load products data in to memory");
		}
		String line;
		String[] tokens;
		scanner.nextLine();// Skipping due to Header
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			tokens = line.split(DELIMITER);
			if (tokens.length == 3) {
				Product product = new Product();
				product.setProductType(tokens[0]);
				product.setCostPerSquareFoot(new BigDecimal(tokens[1]));
				product.setLaborCostPerSquareFoot(new BigDecimal(tokens[2]));
				// add each product to the product list
				productList.add(product);
			} else {
				// do nothing
			}

		}
		scanner.close();
		if (!productList.isEmpty()) {
			return productList;
		} else {
			return null;
		}
	}
}
