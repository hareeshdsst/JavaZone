package com.practice.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.practice.dto.DVD;

public class DvdLibraryDaoImpl implements DvdLibraryDao {

	private Map<String, DVD> dvdMap = new HashMap<>();
	public static final String FILE_NAME = "dvdinfo.txt";
	public static final String DELIMETER = "::";

	@Override
	public DVD addDVD(String title, DVD dvds) throws DVDLibraryPersistenceException, IOException {
		DVD newDvd = dvdMap.put(title, dvds);
		writeDvdInfo();
		return newDvd;
	}

	@Override
	public DVD getDVD(String title) throws DVDLibraryPersistenceException {
		DVD dvdInfo = dvdMap.get(title);
		loadDvdInfo();
		return dvdInfo;
	}

	@Override
	public List<DVD> getAllDVDs() throws DVDLibraryPersistenceException{
		loadDvdInfo();
		return new ArrayList<DVD>(dvdMap.values());
	}

	@Override
	public DVD removeDVD(String title) throws DVDLibraryPersistenceException, IOException {
		DVD removeDvd = dvdMap.remove(title);
		writeDvdInfo();
		return removeDvd;
	}

	@Override
	public DVD editDVD(String title, DVD dvds) throws DVDLibraryPersistenceException, IOException {
		DVD editDvd = dvdMap.put(title, dvds);
		writeDvdInfo();
		return editDvd;
	}

	@SuppressWarnings("resource")
	public void loadDvdInfo() throws DVDLibraryPersistenceException {
		Scanner scanner;
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(FILE_NAME)));
		} catch (FileNotFoundException e) {
			throw new DVDLibraryPersistenceException("Couldnt load dvd data in to memory", e);
		}
		String currentLine;
		String[] currentTokens;

		while (scanner.hasNextLine()) {
			try {
				// get the next line from the file.
				currentLine = scanner.nextLine();
				// break up the line in to tokens.
				currentTokens = currentLine.split(DELIMETER);

				DVD dvdinfo = new DVD(currentTokens[0]);
				// set the remaining values on Current DVD manually.
				dvdinfo.setReleaseDate(LocalDate.parse(currentTokens[1]));
				dvdinfo.setMpaaRating(currentTokens[2]);
				dvdinfo.setDirectorName(currentTokens[3]);
				dvdinfo.setStudio(currentTokens[4]);
				dvdinfo.setUserNoteorRating(currentTokens[5]);
				// Put the dvd object in to map title as key.
				dvdMap.put(dvdinfo.getTitle(), dvdinfo);
			} catch (InputMismatchException e) {
				System.out.println("Unable to scan");
			}
		}
		// Close the scanner.
		scanner.close();
	}

	@SuppressWarnings("resource")
	public void writeDvdInfo() throws DVDLibraryPersistenceException, IOException {

		PrintWriter writer;

		writer = new PrintWriter(new FileWriter(FILE_NAME));
		List<DVD> dvds = this.getAllDVDs();
		for (DVD dvd : dvds) {
			writer.println(dvd.getTitle() + DELIMETER + dvd.getReleaseDate() + DELIMETER + dvd.getMpaaRating()
					+ DELIMETER + dvd.getDirectorName() + DELIMETER + dvd.getStudio() + DELIMETER
					+ dvd.getUserNoteorRating());
			// force printwriter to write in to file.
			writer.flush();
		}
		writer.close();
	}
}
