package ui;

import java.util.List;

import dto.Address;

public class AddressBookView {
	private UserIO io;

	public AddressBookView(UserIO io) {
		this.io = io;
	}


	/*
	 * Add new address.
	 */
	public Address getNewAddressInfo() {

		String firstName = io.readString("Please enter your first name");
		String lastName = io.readString("Please enter your last name");
		String street = io.readString("Please enter number and street");
		String state = io.readString("Please enter your City and  State");
		String zip = io.readString("Please enter your ZipCode");

		Address currentAddress = new Address(lastName);
		currentAddress.setLastName(lastName);
		currentAddress.setFirstName(firstName);
		currentAddress.setStreet(street);
		currentAddress.setCityState(state);
		currentAddress.setZipCode(zip);
		return currentAddress;
	}

	public void displayCreateAddreeBanner() {

		io.print("======= Create Address ========");
	}

	public void displayCreateSuccessBanner() {
		io.print("======= Address created successfully. Please hit enter to continue");
	}

	public void displayAddressList(List<Address> addressList) {
		for (Address address : addressList) {
			io.print(address.getFirstName() + ", " + address.getLastName() + ", " + address.getCityState() + ", "
					+ address.getStreet() + ", " + address.getZipCode());
		}
		io.print("Please hit enter to continue");
	} 
	public void displayAllAddress() {

		io.print("======= Display All Addresses ========");
	}
	
	public void displayAddress() {

		io.print("======= Display Address ========");
	}
	
	public String getAddressNameChoice() {
		return io.readString("Please enter last name.");
	}
	public void displayAddressByName(Address address) {
		if(address != null) {
			io.print(address.getFirstName() + ", " + address.getLastName() + ", " + address.getCityState() + ", "
					+ address.getStreet() + ", " + address.getZipCode());
		}else {
			io.print("No such address");
		}
		io.print("Please hit enter to continue");
	}
	
	public void removeAddressBanner() {
		io.print("======= Remove address");
	}
	
	public void removeSuccessAddressBanner() {
		io.print("======= Address removed successfully. Please hit enter to continue");
	}
	
	public void displayNumberOfAddress() {
		io.print("======= Number of addresses available");
	}
	
	public void displayNumberSuccessAddress() {
		io.print("=======Address successfully listed");
	}
	
	public void exitBanner() {
		io.print("=======Good Bye");
	}
	
	public void displayUnknownCommand() {
		io.print("=======Unknown command");
	}
	
	public void displayErrorMessage(String errorMsg) {
		io.print("=======Error=======");
		io.print(errorMsg);
	}

	public int printMenuAndGetSelection() {
		io.print("Main Menu");
		io.print("1. Add Address");
		io.print("2. Delete Address");
		io.print("3. Find Address");
		io.print("4. List Address Count");
		io.print("5. List All Addresses");
		io.print("6. Exit");
		return io.readInt("Please select from the above choices", 1, 6);
	}
	
}