package com.javapractice.examples;

import java.util.Scanner;

public class DontForgetToStoreIt {
	public static void main(String[] args) {
		int meaningOfLifeAndEverything = 42;
		double pi = 3.14159;
		String cheese, color;

		@SuppressWarnings("resource")
		Scanner inputReader = new Scanner(System.in);

		System.out.println("Give me pi to at least 5 decimals: ");
		pi = inputReader.nextDouble();

		System.out.println("What is the meaning of life, the universe & everything? ");
		meaningOfLifeAndEverything = inputReader.nextInt();

		System.out.println("What is your favorite kind of cheese? ");
		cheese = inputReader.next();

		System.out.println("Do you like the color red or blue more? ");
		color = inputReader.next();

		System.out.println("Ooh, " + color + " " + cheese + " soundsdelicious!");
		System.out.println("The circumference of life is " + (2 * pi * meaningOfLifeAndEverything));

	}
}
