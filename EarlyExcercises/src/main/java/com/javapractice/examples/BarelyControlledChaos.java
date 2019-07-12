package com.javapractice.examples;

import java.util.Random;

public class BarelyControlledChaos {
	public static void main(String[] args) {
		String color = randomColor();
		String animal = randomAnimal();
		String colorAgain = randomColor();
		int weight = randomIntFromRange(5, 200);
		int distance = randomIntFromRange(10, 20);
		int number = randomIntFromRange(10000, 20000);
		int time = randomIntFromRange(2, 6);

		System.out.println("Once, when I was very small...");

		System.out.println("I was chased by a " + color + ", " + weight + "lb " + " miniature " + animal + " for over "
				+ distance + " miles!!");

		System.out.println("I had to hide in a field of over " + number + " " + colorAgain + " poppies for nearly "
				+ time + " hours until it left me alone!");

		System.out.println("\nIt was QUITE the experience, " + "let me tell you!");

	}

	public static String randomColor() {
		Random rng = new Random();

		String color1 = "Green";
		String color2 = "Red";
		String color3 = "Yellow";
		String color4 = "Orange";
		String color5 = "Black";

		int numberGenerated = rng.nextInt();
		switch (numberGenerated) {
		case 1:
			return color1;
		case 2:
			return color2;
		case 3:
			return color3;
		case 4:
			return color4;
		case 5:
			return color5;
		}
		return "nothing";
	}

	public static String randomAnimal() {
		String option1 = "red panda";
		String option2 = "fox";
		String option3 = "cardinal";
		String option4 = "red snapper";
		String option5 = "parrot";

		Random rng = new Random();

		int choice = rng.nextInt(5);

		switch (choice) {
		case 1:
			return option1;
		case 2:
			return option2;
		case 3:
			return option3;
		case 4:
			return option4;
		case 5:
			return option5;
		}
		return "Something broke";
	}

	public static int randomIntFromRange(int min, int max) {
		Random rng = new Random();

		return rng.nextInt(max - 1) + min;
	}
}