package com.javapractice.examples;

import java.util.Arrays;
import java.util.Scanner;

public class Factorizor {
	public static void main(String[] args) {

		@SuppressWarnings("resource")
		Scanner inputReader = new Scanner(System.in);

		System.out.println("Enter a number: ");

		int userNumber = 6;

		printFactorsOfANumber(userNumber);
		isPrimeNumber(userNumber);
	}

	public static void printFactorsOfANumber(int userNumber) {
		System.out.println("The factors of " + userNumber + " are : ");
		// Check the factors of a given number.
		int sum = 0;
		int[] numbers = new int[4];
		for (int i = 1; i < userNumber; i++) {
			if (userNumber % i == 0) {
				System.out.print(i + " ");
				numbers[i - 1] = i;
			}
		}
		sum = Arrays.stream(numbers).sum();
		if (sum == userNumber) {
			System.out.println("\n" + userNumber + "\n is  a perfect square.");
		}

	}

	public static boolean isPrimeNumber(int userNumber) {
		boolean isPrime = true;
		// Check if number is a prime or not.
		for (int i = 2; i < userNumber; i++) {
			if (userNumber % i == 0) {
				isPrime = false;
				break;
			}
		}
		if (isPrime) {
			System.out.println("\n" + userNumber + " " + "Is a prime number");
		}
		return isPrime;
	}
}
