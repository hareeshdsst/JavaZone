package com.sg.ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO{

	private Scanner sc;
	
	public UserIOConsoleImpl() {
		sc = new Scanner(System.in);
	}
	
	public void print(String message) {
		System.out.print(message);
	}

	public void println(String message) {
		System.out.println(message);
	}


	public double readDouble(String prompt) {
		throw new UnsupportedOperationException("Not supported yet");
	}

	
	public double readDouble(String prompt, double min, double max) {
		throw new UnsupportedOperationException("Not supported yet");
	}

	public float readFloat(String prompt) {
		throw new UnsupportedOperationException("Not supported yet");
	}

	public float readFloat(String prompt, float min, float max) {
		throw new UnsupportedOperationException("Not supported yet");
	}

	public int readInt(String prompt) {
		try {
			return Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			return -1;
		}
	}

	public int readInt(String prompt, int min, int max) {
		try {
			int val =  Integer.parseInt(sc.nextLine());
			if(val >= min && val <= max) {
				return val;
			}
		} catch (NumberFormatException e) {
			//
		}
		return -1;
	}

	public long readLong(String prompt) {
		throw new UnsupportedOperationException("Not supported yet");
	}

	public long readLong(String prompt, int min, int max) {
		throw new UnsupportedOperationException("Not supported yet");
	}

	public String readString(String prompt) {
		print(prompt);
		return sc.nextLine();
	}

}
