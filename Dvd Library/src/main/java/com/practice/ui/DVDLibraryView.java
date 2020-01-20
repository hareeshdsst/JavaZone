package com.practice.ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.practice.dto.DVD;

public class DVDLibraryView {
	private DvdIO io;

	public DVDLibraryView(DvdIO io) {
		this.io = io;
	}

	public int printMenuAndGetSelection() {
		io.print("Main Menu");
		io.print("1. Add a DVD");
		io.print("2. Remove a DVD");
		io.print("3. Edit a DVD");
		io.print("4. List All Dvd's");
		io.print("5. Display information for a DVD");

		return io.readInt("Please select from above choices", 1, 5);
	}

	public DVD getDvdInfo() {
		String title = io.readString("Please enter title name:");
		LocalDate releaseDate = dateInput(io.readString("Please enter release date"));
		String mpaaRating = io.readString("Please enter MPAA rating");
		String directorName = io.readString("Please enter Director Name:");
		String studio = io.readString("Please enter Studio name:");
		String userNoteorRating = io.readString("Please enter User Note:");

		DVD newDvd = new DVD(title);
		newDvd.setTitle(title);
		newDvd.setReleaseDate(releaseDate);
		newDvd.setDirectorName(directorName);
		newDvd.setMpaaRating(mpaaRating);
		newDvd.setStudio(studio);
		newDvd.setUserNoteorRating(userNoteorRating);
		return newDvd;
	}

	private LocalDate dateInput(String releaseDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		LocalDate date = LocalDate.parse(releaseDate, formatter);
		return date;
	}

	public void printAddDvdBanner() {
		io.print("Create new DVD");
	}

	public void printAddDvdSuccessBanner() {
		io.readString("DVD created successfully");
	}
	
	public void printRemoveDvdBanner() {
		io.print("Enter the DVD title name you want to remove");
	}

	public void printRemoveDvdSuccessBanner() {
		io.readString("DVD removed successfully");
	}
	
	public String getDvdTitleByChoice() {
		return io.readString("Please enter the title of the DVD you looking for.");
	}
	
	public void listingAllDvdsBanner() {
		io.print("Listing all DVD's available");
	}
	
	public void printAllDvds(List<DVD> dvdList){
		for(DVD dvd : dvdList) {
			io.print(dvd.getTitle() + " , " + dvd.getDirectorName() + " , " + dvd.getMpaaRating()
			+ " , " + dvd.getStudio() + " , " + dvd.getReleaseDate() + " , " + dvd.getUserNoteorRating());
		}
		io.readString("Please hit enter to continue");
	}

	public void dvdLibraryDao() {
		io.print("Listing all DVD's available");
	}

	public void getADvdBanner() {
		io.print("Getting a DVD info");
	}
	
	
	public void printADvds(DVD dvd){
		if(dvd != null) {
			io.print(dvd.getTitle());
			io.print(dvd.getDirectorName());
			io.print(dvd.getMpaaRating());
			io.print(dvd.getStudio());
			io.printDate(dvd.getReleaseDate());
			io.print(dvd.getUserNoteorRating());
		}else {
			io.print("No such DVD");
		}

		io.readString("Please hit enter to continue");
	}
	
	public void editDvdBanner() {
		io.print("Editing a DVD info");
	}
	public String editTitle() {
		String title = io.readString("Please enter updated title name");
		return title;
	}
	public String editReleaseDate() {
		String date = io.readString("Please enter updated released date");
		return date;
	}
	public String editDirectorName() {
		String directorName = io.readString("Please enter updated Director name");
		return directorName;
	}
	public String editMPAARating() {
		String rating = io.readString("Please enter updated MPAARating");
		return rating;
	}
	public String editUserNote() {
		String userNote = io.readString("Please enter updated User Note");
		return userNote;
	}
	public String editStudioName() {
		String stdName = io.readString("Please enter updated Studio Name");
		return stdName;
	}
	
	public void unknownCommand() {
		io.print("unknown command");
	}
	

	public void printEditDvdSuccessBanner() {
		io.readString("DVD edited successfully");
	}

	public int editMenuSelection() {
		io.print("What information you would like to edit.");
		io.print("1. Title");
		io.print("2. Release date");
		io.print("3. MPAA rating");
		io.print("4. Director Name");
		io.print("5. Studio name");
		io.print("6. User Note/Rating");
		io.print("7. Exit");

		return io.readInt("Please select from above choices", 1, 7);
	}
	
}
