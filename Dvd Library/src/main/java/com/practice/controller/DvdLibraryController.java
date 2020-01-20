package com.practice.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import com.practice.dao.DVDLibraryPersistenceException;
import com.practice.dao.DvdLibraryDao;
import com.practice.dto.DVD;
import com.practice.ui.DVDLibraryView;

public class DvdLibraryController {
	DVDLibraryView dVDLibraryView;
	DvdLibraryDao dvdLibraryDao;

	public DvdLibraryController(DVDLibraryView dVDLibraryView, DvdLibraryDao dvdLibraryDao) {
		this.dVDLibraryView = dVDLibraryView;
		this.dvdLibraryDao = dvdLibraryDao;
	}

	public void run() throws DVDLibraryPersistenceException, IOException {
		boolean keepGoing = true;
		int selection = 0;

		while (keepGoing) {
			selection = dVDLibraryView.printMenuAndGetSelection();
			switch (selection) {
			case 1:
				addDvd();
				break;
			case 2:
				removeDvd();
				break;
			case 3:
				editDvd();
				break;
			case 4:
				listAllDvds();
				break;
			case 5:
				getADvd();
				break;
			case 6:
				keepGoing = false;
				break;
			default:
				unknownCommand();

			}
		}
	}

	private void listAllDvds() throws DVDLibraryPersistenceException {
		dVDLibraryView.listingAllDvdsBanner();
		List<DVD> dvdlist = dvdLibraryDao.getAllDVDs();
		dVDLibraryView.printAllDvds(dvdlist);

	}

	private void getADvd() throws DVDLibraryPersistenceException {
		dVDLibraryView.getADvdBanner();
		String dvdTitle = dVDLibraryView.getDvdTitleByChoice();
		DVD dvd = dvdLibraryDao.getDVD(dvdTitle);
		dVDLibraryView.printADvds(dvd);
	}

	private void editDvd() throws DVDLibraryPersistenceException, IOException {
		dVDLibraryView.editDvdBanner();
		// Retrieve DVD user wants to edit.
		String dvdTitle = dVDLibraryView.getDvdTitleByChoice();
		DVD dvd = dvdLibraryDao.getDVD(dvdTitle);
		int selection = 0;
		boolean keepGoing = true;

		while (keepGoing) {
			
			selection = getEditMenuSelection();
			switch (selection) {
			
			case 1:
				// Remove old title key from Hashmap.
				dvdLibraryDao.removeDVD(dvdTitle);
				String updatedTitle = dVDLibraryView.editTitle();
				dvd.setTitle(updatedTitle);
				dvdLibraryDao.editDVD(updatedTitle, dvd);
				break;
			case 2:
				String updatedreleaseDate = dVDLibraryView.editReleaseDate();
				dvd.setReleaseDate(LocalDate.parse(updatedreleaseDate));
				dvdLibraryDao.editDVD(dvdTitle, dvd);
				break;
			case 3:
				String updatedMPPARating = dVDLibraryView.editMPAARating();
				dvd.setMpaaRating(updatedMPPARating);
				dvdLibraryDao.editDVD(dvdTitle, dvd);
				break;
			case 4:
				String updatedDirectorName = dVDLibraryView.editDirectorName();
				dvd.setDirectorName(updatedDirectorName);
				dvdLibraryDao.editDVD(dvdTitle, dvd);
				break;
			case 5:
				String updatedStdName = dVDLibraryView.editStudioName();
				dvd.setStudio(updatedStdName);
				dvdLibraryDao.editDVD(dvdTitle, dvd);
				break;
			case 6:
				String updatedUserNote = dVDLibraryView.editUserNote();
				dvd.setUserNoteorRating(updatedUserNote);
				dvdLibraryDao.editDVD(dvdTitle, dvd);
				break;
			case 7:
				keepGoing = false;
				break;
			default:
				unknownCommand();
			}
		}
		dVDLibraryView.printEditDvdSuccessBanner();
	}

	private int getEditMenuSelection() {
		return dVDLibraryView.editMenuSelection();
	}

	private void removeDvd() throws DVDLibraryPersistenceException, IOException {
		dVDLibraryView.printRemoveDvdBanner();
		String dvdTitle = dVDLibraryView.getDvdTitleByChoice();
		dvdLibraryDao.removeDVD(dvdTitle);
		dVDLibraryView.printRemoveDvdSuccessBanner();

	}

	private void addDvd() throws DVDLibraryPersistenceException, IOException {
		dVDLibraryView.printAddDvdBanner();
		DVD dvdInfo = dVDLibraryView.getDvdInfo();
		dvdLibraryDao.addDVD(dvdInfo.getTitle(), dvdInfo);
		dVDLibraryView.printAddDvdSuccessBanner();
	}

	private void unknownCommand() {
		dVDLibraryView.unknownCommand();
	}
}
