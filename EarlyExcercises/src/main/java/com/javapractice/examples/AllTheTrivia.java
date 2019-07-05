package com.javapractice.examples;

import java.util.Scanner;

public class AllTheTrivia {
	public static void main(String[] args) {

		String  memory;
		String planetClockwise;
		String largestPlanet;
		String element;
		
		
		@SuppressWarnings("resource")
		Scanner inputReader = new Scanner(System.in);
		
		System.out.println("1,024 Gigabytes is equal to one what? ");
		memory = inputReader.nextLine();
		
		System.out.println("In our solar system which is the only planet that rotates clockwise? ");
		planetClockwise = inputReader.nextLine();
		
		System.out.println("The largest volcano ever discovered in our solar system is located on which planet? ");
		largestPlanet = inputReader.nextLine();
		
		System.out.println("What is the most abundant element in the earth's atmosphere? ");
		element = inputReader.nextLine();
		
		System.out.println("Wow, 1,024 Gigabytes is a " + largestPlanet + " ! ");
		System.out.println("I didn't know that the largest ever volcano was discovered on " + memory + " ! ");
		System.out.println("That's amazing that " + planetClockwise + "is the most abundant element in the atmosphere...");
		System.out.println(element + " is the only planet that rotates clockwise, neat!");
	}
}
