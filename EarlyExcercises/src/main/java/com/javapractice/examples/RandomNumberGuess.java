package com.javapractice.examples;

import java.util.Random;
import java.util.Scanner;

public class RandomNumberGuess {
	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in);
		int guess;
		int answer;

		Random randomGenerator = new Random();
		answer = randomGenerator.nextInt(20) + 1;

		while (true) {
			System.out.println("Enter a guess number between 1 - 20");
			guess = inputReader.nextInt();
			if (guess == answer) {
				break;
			}
			if (guess < 1 || guess > 20) {
				System.out.println("Your guess should be between 1 and 20");
				continue;
			}
			if (guess > answer) {
				System.out.println("Lower!!!");
			}
			System.out.println("Higher !!!");
		}
		System.out.println("You got it ! Answer is " + answer);
	}
}