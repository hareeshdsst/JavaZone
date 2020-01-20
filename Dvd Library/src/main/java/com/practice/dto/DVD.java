package com.practice.dto;

import java.time.LocalDate;

public class DVD {

	private String title;
	private LocalDate releaseDate;
	private String mpaaRating;
	private String directorName;
	private String studio;
	private String userNoteorRating;

	public DVD(String title) {
		this.title = title;
	}
	public DVD() {
		
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getMpaaRating() {
		return mpaaRating;
	}

	public void setMpaaRating(String mpaaRating) {
		this.mpaaRating = mpaaRating;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getStudio() {
		return studio;
	}
	public void setStudio(String studio) {
		this.studio = studio;
	}

	public String getUserNoteorRating() {
		return userNoteorRating;
	}

	public void setUserNoteorRating(String userNoteorRating) {
		this.userNoteorRating = userNoteorRating;
	}

}
