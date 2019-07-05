package com.javapractice.examples;

import java.util.Scanner;

public class PassingTheTuringTest {
	public static void main(String[] args) {

		String name;
		String color;
		String food;
		int favNumber;
		int multiplicationNumber;

		System.out.println("Hello There!");

		@SuppressWarnings("resource")
		Scanner inputReader = new Scanner(System.in);

		System.out.println("What is your name? ");
		name = inputReader.nextLine();

		System.out.println("Hi " + name + " What's your favorite color?");
		color = inputReader.nextLine();

		System.out.println("Huh, " + color + " Mine's Green");

		System.out.println("I really like grapes. ");

		System.out.println("Whas is your favorite fruit " + name);

		food = inputReader.nextLine();

		System.out.println("Really " + food + "? Thats wild");

		System.out.println("Speaking to favorites, what's your favorite number?");

		favNumber = inputReader.nextInt();

		multiplicationNumber = favNumber * -7;
		System.out.println(+ favNumber + "is a cool number. Mine's -7");

		System.out.println("Did you know" + favNumber * -7 + "is " + multiplicationNumber);
	}
}
