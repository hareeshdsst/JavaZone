package dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import dto.Address;

public class AddressBookDaoFileImpl implements AddressBookDao {
	private Map<String, Address> addressMap = new HashMap<>();
	public static final String ADDRESS_FILE = "addressBook.txt";
	public static final String DELIMITER = "::";

	public Address addAddress(String lastName, Address address) {

		Address currentAddress = addressMap.put(lastName, address);

		return currentAddress;
	}

	public Address removeAddress(String lastName) {
		Address removeAdd = addressMap.remove(lastName);
		try {
			writeRoster();
		} catch (AddressBookDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return removeAdd;
	}

	public int getNumberOfAddress(Map<String, Address> address) {
		int numberOfAddresses = address.size();
		try {
			writeRoster();
		} catch (AddressBookDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberOfAddresses;
	}

	public List<Address> listAllAddress() {
		try {
			loadRoster();
		} catch (AddressBookDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<Address>(addressMap.values());
	}

	public Address retrieveAddressByName(String lastName) {
		try {
			loadRoster();
		} catch (AddressBookDaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return addressMap.get(lastName);
	}
	
	@SuppressWarnings("resource")
	private void loadRoster() throws AddressBookDaoException {
		Scanner scn;
		
		try {
			scn = new Scanner(new BufferedReader(new FileReader(ADDRESS_FILE)));
		}catch(FileNotFoundException e) {
			throw new AddressBookDaoException("Cannot load data in to memory", e);
		}
		
		String currentLine;
		String[] currentTokens;
		
		while(scn.hasNextLine()) {
			currentLine = scn.nextLine();
			
			currentTokens = currentLine.split(DELIMITER);
			
			Address address =  new Address(currentTokens[0]);
			address.setFirstName(currentTokens[1]);
			address.setLastName(currentTokens[2]);
			address.setStreet(currentTokens[3]);
			address.setCityState(currentTokens[4]);
			address.setZipCode(currentTokens[5]);
		}
		
	}


	private void writeRoster() throws AddressBookDaoException {
		PrintWriter out;
		
		try {
			out = new PrintWriter(new FileWriter(ADDRESS_FILE));
		}catch(IOException e) {
			throw new AddressBookDaoException("Could not save address book data.", e);
		}
		List<Address> addressList = this.listAllAddress();
		
		for(Address address : addressList) {
			out.println(address.getFirstName() + DELIMITER
					+ address.getLastName() + DELIMITER
					+ address.getCityState() + DELIMITER
					+ address.getStreet() + DELIMITER 
					+ address.getZipCode());
			//Force Printwriter to write line to the file.
			out.flush();
		}
		out.close();
	}
}
