package com.javapractice.examples;

import java.util.Scanner;

public class GuessMe {
	public static void main(String[] args) {
		int guessNumber;
		int correctAnswer = 10;
		Scanner sc = new Scanner(System.in);
		guessNumber = sc.nextInt();

		if (guessNumber == correctAnswer) {
			System.out.println("Wow, nice guess! That was it!");
		} else if (guessNumber < correctAnswer) {
			System.out.println("Ha, nice try - too low! I chose " + correctAnswer);
		} else {
			System.out.println("Too bad, way too high. I chose #" + correctAnswer);
		}
	}
}
