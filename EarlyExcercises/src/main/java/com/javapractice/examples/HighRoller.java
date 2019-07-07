package com.javapractice.examples;

import java.util.Random;
import java.util.Scanner;

public class HighRoller {
	public static void main(String[] args) {
		Random randomizer = new Random();

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter number of sides the dice has");

		int rollResult = randomizer.nextInt(sc.nextInt()) + 1;

		System.out.println("TIME TO ROOOOOOLL THE DICE!");
		System.out.println("I rolled a " + 6);

		if (rollResult == 1) {
			System.out.println("You rolled a critical failure!");
		}
		if (rollResult == 2) {
			System.out.println("You rolled a critical close");
		}
		if (rollResult == 3) {
			System.out.println("You rolled a critical okay");
		}
		if (rollResult == 4) {
			System.out.println("You rolled a little okay");
		}
		if (rollResult == 5) {
			System.out.println("You rolled a near to success!");
		}
		if (rollResult == 6) {
			System.out.println("You rolled a success one");
		}
	}
}
