package com.sg.ui;

import java.math.BigDecimal;
import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
	Scanner sc = new Scanner(System.in);
	
	
	@Override
	public void print(String message) {
		System.out.println(message);
	}

	@Override
	public double readDouble(String prompt) {
      return Double.parseDouble(prompt);
	}

	@Override
	public double readDouble(String prompt, double min, double max) {
		double amount;
		do {
			amount  = Double.parseDouble(prompt);
		}while(amount < min || amount > max);
		return amount;
	}

	@Override
	public float readFloat(String prompt) {
		return Float.parseFloat(prompt);
	}

	@Override
	public float readFloat(String prompt, float min, float max) {
		float amount;
		do {
			amount  = Float.parseFloat(prompt);
		}while(amount < min || amount > max);
		return amount;
	}

	@Override
	public int readInt(String prompt) {
		return Integer.parseInt(prompt);
	}

	@Override
	public int readInt(String prompt, int min, int max) {
		int amount;
		do {
			amount  = Integer.parseInt(readString(prompt));
		}while(amount < min || amount > max);
		return amount;
	}

	@Override
	public long readLong(String prompt) {
		return Long.parseLong(prompt);
	}

	@Override
	public long readLong(String prompt, long min, long max) {
		long amount;
		do {
			amount  = Long.parseLong(prompt);
		}while(amount < min || amount > max);
		return amount;
	}

	@Override
	public String readString(String prompt) {
		String input = "";
		System.out.println(prompt);
		input = sc.nextLine();
		return input;
	}

	@Override
	public BigDecimal readBigDecimal(String prompt) {
		return new BigDecimal(readString(prompt));
	}

	
}
