package com.javapractice.examples;

import java.util.Scanner;

public class GuessMeFinally {
	public static void main(String[] args) {
		int guessNumber;
		int correctAnswer = 10;

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter a number.");
			guessNumber = sc.nextInt();
			if (guessNumber == correctAnswer) {
				System.out.println("Nice Guess! Congrats");
				break;
			}
		}
	}
}
