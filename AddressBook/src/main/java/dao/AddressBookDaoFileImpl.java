package dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dto.Address;

public class AddressBookDaoFileImpl implements AddressBookDao {
	private Map<String, Address> addressMap = new HashMap<>();

	public Address addAddress(String lastName, Address address) {

		Address currentAddress = addressMap.put(lastName, address);

		return currentAddress;
	}

	public Address removeAddress(String lastName) {
		Address removeAdd = addressMap.remove(lastName);

		return removeAdd;
	}

	public int getNumberOfAddress(Map<String, Address> address) {
		int numberOfAddresses = address.size();
		return numberOfAddresses;
	}

	public List<Address> listAllAddress() {
		return new ArrayList<Address>(addressMap.values());
	}

	public Address retrieveAddressByName(String lastName) {
		return addressMap.get(lastName);
	}
	
	

}
