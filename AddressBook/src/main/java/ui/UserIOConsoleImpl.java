package ui;

import java.util.Scanner;

public class UserIOConsoleImpl implements UserIO {
	private Scanner userInput = new Scanner(System.in);

	public void print(String message) {
		System.out.println(message);
	}

	public double readDouble(String prompt) {
		System.out.println(prompt);
		String input = userInput.nextLine();
		double numInput = Double.parseDouble(input);
		return numInput;
	}

	public double readDouble(String prompt, double min, double max) {
		System.out.println(prompt);
		String input = userInput.nextLine();
		System.out.println(prompt);
		input = userInput.nextLine();
		double numInputMax = Double.parseDouble(input);
		return numInputMax;
	}

	public int readInt(String prompt) {
		System.out.println(prompt);
		String input = userInput.nextLine();
		int numInput = Integer.parseInt(input);
		return numInput;
	}

	public int readInt(String prompt, int min, int max) {
		System.out.println(prompt);
		String input = userInput.nextLine();
		int numInput = Integer.parseInt(input);
		return numInput;
	}

	public String readString(String prompt) {
		System.out.println(prompt);
		String input = userInput.nextLine();
		return input;
	}

	public long readLong(String prompt) {
		System.out.println(prompt);
		String input = userInput.nextLine();
		long numInput = Long.parseLong(input);
		return numInput;
	}

	public long readLong(String prompt, long min, long max) {
		System.out.println(prompt);
		String input = userInput.nextLine();
		long numInput = Long.parseLong(input);
		return numInput;
	}

	public float readFloat(String prompt) {
		System.out.println(prompt);
		String input = userInput.nextLine();
		float numInput = Float.parseFloat(input);
		return numInput;
	}

	public float readFloat(String prompt, float min, float max) {
		System.out.println(prompt);
		String input = userInput.nextLine();
		float numInput = Float.parseFloat(input);
		return numInput;
	}
}