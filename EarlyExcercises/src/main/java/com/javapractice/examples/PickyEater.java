package com.javapractice.examples;

import java.util.Scanner;

public class PickyEater {
	public static void main(String[] args) {
		int timesFried = 0;
		String hasSpinach = "y";
		String cheeseCovered = "y";
		int butterPats = 0;
		String chocolatedCovered = "y";
		String funnyName = "y";
		String isBroccoli = "y";

		@SuppressWarnings("resource")
		Scanner userInput = new Scanner(System.in);
		System.out.print("How many times has it been fried? (#) ");
		timesFried = userInput.nextInt();

		System.out.print("Does it have any spinach in it? (y/n) ");
		hasSpinach = userInput.next();

		System.out.print("Is it covered in cheese? (y/n) ");
		cheeseCovered = userInput.next();

		System.out.print("How many pats of butter are on top? (#) ");
		butterPats = userInput.nextInt();

		System.out.print("Is it covered in chocolate? (y/n) ");
		chocolatedCovered = userInput.next();

		System.out.print("Does it have a funny name? (y/n) ");
		funnyName = userInput.next();

		System.out.print("Is it broccoli? (y/n) ");
		isBroccoli = userInput.next();

		// Conditionals should go here! Here's the first one for FREE!
		if (hasSpinach.equals("y") || funnyName.equals("y")) {
			System.out.println("There's no way that'll get eaten.");
		}
		if (timesFried > 2 || timesFried < 4 && chocolatedCovered.equals("y")) {
			System.out.println("Oh, it's like a deep-fried Snickers. That'll be a hit!");
		}
		if (timesFried == 2 && cheeseCovered.equals("y")) {
			System.out.println("Mmm. Yeah, fried cheesy doodles will get et.");
		}
		if (isBroccoli.equals("y") && butterPats > 6 && cheeseCovered.equals("y")) {
			System.out.println("As long as the green is hidden by cheddar, it'll happen!");
		}
		if (isBroccoli.equals("y")) {
			System.out.println("Oh, green stuff like that might as well go in the bin.");
		}
	}
}