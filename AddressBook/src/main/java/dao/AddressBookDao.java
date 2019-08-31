package dao;

import java.util.List;
import java.util.Map;

import dto.Address;

public interface AddressBookDao {
	Address addAddress(String lastName, Address address);

	Address removeAddress(String lastName);

	int getNumberOfAddress();

	List<Address> listAllAddress();

	Address retrieveAddressByName(String lastName);
}
