package com.javapractice.userIoLab;

import java.util.Scanner;

public class UserIoImpl implements UserIO {

	Scanner sc;

	public UserIoImpl() {
		sc = new Scanner(System.in);
	}

	public UserIoImpl(Scanner scan) {
		sc = scan;
	}

	@Override
	public void print(String message) {
		System.out.println(message);
	}

	public void printLn(String message) {
		System.out.println(message);
	}

	@Override
	public double readDouble(String prompt) {
		while (true) {
			print(prompt);
			try {
				return Double.parseDouble(sc.nextLine());
			} catch (NumberFormatException e) {
				printLn("Please enter a valid number");
			}
		}
	}

	@Override
	public double readDouble(String prompt, double min, double max) {
		double input = readDouble(prompt);
		while (!(min <= input && input <= max)) {
			print("Error: number out of range");
			input = readDouble(prompt);
		}
		return input;
	}

	@Override
	public float readFloat(String prompt) {
		while (true) {
			print(prompt);
			try {
				return Float.parseFloat(sc.nextLine());
			} catch (NumberFormatException e) {
				printLn("Please enter a valid number");
			}
		}
	}

	@Override
	public float readFloat(String prompt, float min, float max) {
		Float input = readFloat(prompt);
		while (!(min <= input && input <= max)) {
			print("Error: number out of range");
			input = readFloat(prompt);
		}
		return input;
	}

	@Override
	public int readInt(String prompt) {
		while (true) {
			print(prompt);
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				printLn("Please enter a valid number");
			}
		}
	}

	@Override
	public int readInt(String prompt, int min, int max) {
		Integer input = readInt(prompt);
		while (!(min <= input && input <= max)) {
			print("Error: number out of range");
			input = readInt(prompt);
		}
		return input;
	}

	@Override
	public long readLong(String prompt) {
		while (true) {
			print(prompt);
			try {
				return Long.parseLong(sc.nextLine());
			} catch (NumberFormatException e) {
				printLn("Please enter a valid number");
			}
		}
	}

	@Override
	public long readLong(String prompt, long min, long max) {
		Long input = readLong(prompt);
		while (!(min <= input && input <= max)) {
			print("Error: number out of range");
			input = readLong(prompt);
		}
		return input;
	}

	@Override
	public String readString(String prompt) {
		print(prompt);
		return sc.nextLine();
	}
}
