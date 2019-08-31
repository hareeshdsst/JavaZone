package controller;

import java.util.List;
import java.util.Map;

import dao.AddressBookDao;
import dao.AddressBookDaoException;
import dto.Address;
import ui.AddressBookView;

public class AddressBookController {

	AddressBookView addressBookView;
	AddressBookDao addressBookDao;

	public AddressBookController(AddressBookView addressBookView, AddressBookDao addressBookDao) {
		this.addressBookView = addressBookView;
		this.addressBookDao = addressBookDao;
	}

	public void run() {
		boolean keepGoing = true;
		int menuSelection = 0;

		while (keepGoing) {
			menuSelection = addressBookView.printMenuAndGetSelection();

			switch (menuSelection) {
			case 1:
				addAddress();
				break;
			case 2:
				removeAddress();
				break;
			case 3:
				findAddress();
				break;
			case 4:
				viewNumberOfAddress();
				break;
			case 5:
				listAllAddress();
				break;
			case 6:
				keepGoing = false;
				break;
			default:
				unKnownCommand();
				break;
			}
		}
		exitMessage();
	}

	private void exitMessage() {
		addressBookView.exitBanner();

	}

	private void unKnownCommand() {
		addressBookView.displayUnknownCommand();

	}

	private void findAddress() {
		addressBookView.displayAddress();
		String lastName = addressBookView.getAddressNameChoice();
		Address address = addressBookDao.retrieveAddressByName(lastName);
		addressBookView.displayAddressByName(address);
	}

	private void listAllAddress() {
		addressBookView.displayAllAddress();
		List<Address> addressList = addressBookDao.listAllAddress();
		addressBookView.displayAddressList(addressList);
	}

	private void viewNumberOfAddress() {
		addressBookView.displayNumberOfAddress(addressBookDao.getNumberOfAddress());
	
		addressBookView.displayNumberSuccessAddress();
	}

	private void removeAddress() {
		addressBookView.removeAddressBanner();
		String lastName = addressBookView.getAddressNameChoice();
		addressBookDao.removeAddress(lastName);
		addressBookView.removeSuccessAddressBanner();
	}

	private void addAddress() {
		addressBookView.displayCreateAddreeBanner();
		Address newAddress = addressBookView.getNewAddressInfo();
		addressBookDao.addAddress(newAddress.getLastName(), newAddress);
		addressBookView.displayCreateSuccessBanner();
	}
}
